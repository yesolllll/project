package comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO dao;
	
	@Override
	public List<CommentVO> selectAll(CommentVO vo) {
		
		//총갯수
				int totCount =dao.count(vo); 
				//총페이지수
				int totPage = totCount /vo.getPageRow(); 
				if(totCount % vo.getPageRow() > 0) totPage++;
				//시작페이지
				int startPage = (vo.getReqPage()-1)/vo.getPageRange()*vo.getPageRange()+1;
				int endPage = startPage+vo.getPageRange()-1;
				if(endPage > totPage) endPage = totPage; //전체 페이지가 5인데 10페이지 버튼이 나와버리는 문제처리 → (가지고 있는 페이지 끝 = 전체페이지)
						
				vo.setTotCount(totCount);
				vo.setTotPage(totPage);
				vo.setStartPage(startPage);
				vo.setEndPage(endPage);
				
				return dao.selectAll(vo);
	}

	@Override
	public int insert(CommentVO vo) {
		return dao.insert(vo);
	}

	@Override
	public int delete(CommentVO vo) {
		return dao.delete(vo);
	}

	@Override
	public int count(CommentVO vo) {
		return dao.count(vo);
	}

}
