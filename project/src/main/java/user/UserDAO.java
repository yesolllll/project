package user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<UserVO> selectAll(UserVO vo) {
		return sqlSession.selectList("user.selectAll", vo);
	}
	
	public int count(UserVO vo) {
		return sqlSession.selectOne("user.count", vo);
	}
	
	public UserVO detail(UserVO vo) {
		return sqlSession.selectOne("user.detail", vo);
	}
	
	public int insert(UserVO vo) {
		return sqlSession.insert("user.insert", vo);
	}
	
	public int update(UserVO vo) {
		return sqlSession.update("user.update", vo);
	}
	
	public int delete(UserVO vo) {
		return sqlSession.delete("user.delete", vo);
	}
	
	public int isDuplicateId(String id) {
		return sqlSession.selectOne("user.isDuplicateId",id);
	}
	public UserVO login(UserVO vo) {
		return sqlSession.selectOne("user.login", vo);
	}
}
