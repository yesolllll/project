package user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserDAO dao;
	
	@Override
	public List<UserVO> selectAll(UserVO vo) {
		int totCount = dao.count(vo); // 총갯수
		// 총페이지수
		int totPage = totCount / vo.getPageRow();
		if (totCount % vo.getPageRow() > 0) totPage++;
		// 시작페이지
		int startPage = (vo.getReqPage()-1)/vo.getPageRange()
						*vo.getPageRange()+1;
		int endPage = startPage+vo.getPageRange()-1;
		if (endPage > totPage) endPage = totPage;
		
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotCount(totCount);
		vo.setTotPage(totPage);
		return dao.selectAll(vo);
	}

	@Override
	public UserVO deatil(UserVO vo) {
		return dao.detail(vo);
	}

	@Override
	public int insert(UserVO vo) {
		return dao.insert(vo);
	}

	@Override
	public UserVO edit(UserVO vo) {
		return dao.detail(vo);
	}
	
	@Override
	public int update(UserVO vo) {
		return dao.update(vo);
	}
	
	@Override
	public int delete(UserVO vo) {
		return dao.delete(vo);
	}

	@Override
	public int isDuplicateId(String id) {
		return dao.isDuplicateId(id);
	}
	
	@Override
	public UserVO login(UserVO vo) {
		return dao.login(vo);
	}
}
