package comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<CommentVO> selectAll(CommentVO vo) {
		return sqlSession.selectList("comment.selectAll", vo);
	}
	public int count(CommentVO vo) {
		return sqlSession.selectOne("comment.count", vo);
	}
	public int insert(CommentVO vo) {
		return sqlSession.insert("comment.insert",vo);
	}
	public int delete(CommentVO vo) {
		return sqlSession.delete("comment.delete",vo);
	}
}
