package news;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl  implements NewsService{
	
	@Autowired
	NewsDAO dao;

	@Override
	public List<NewsVO> selectAll(NewsVO vo) {
		//기본값을 vo 생성자에서 초기화 한 경우 get사용하기 10 → vo.getPageRow()
		
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
	public NewsVO detail(NewsVO vo) {   	
		dao.updateReadcount(vo);		//조회수 증가 메서드
		return dao.detail(vo);			//상세조회 메서드
	}
	@Override
	public int insert(NewsVO vo) {   	
		return dao.insert(vo);			
	}
	
	@Override
	public NewsVO edit(NewsVO vo) {   	
		return dao.detail(vo);		
	}
	@Override
	public int update(NewsVO vo) { 
		if("1".equals(vo.getIsDel())) {
			dao.delFilename(vo);
		}
		return dao.update(vo);			
	}
	@Override
	public int delete(NewsVO vo) {   	
		return dao.delete(vo);		
	}
}
