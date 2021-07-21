package board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<BoardVO> selectAll(BoardVO vo) {
		return sqlSession.selectList("board.selectAll", vo);
	}
	public int count(BoardVO vo) {
		return sqlSession.selectOne("board.count", vo);
	}
	///////////////////////////////////////////////////////
	//상세 페이지 와 수정 페이지에서 호출해야하는 메소드라 조회수 메소드 따로 만들어야함
	//상세 페이지 = detail + updateReadcount 
	//수정 페이지 = detail
	public BoardVO detail(BoardVO vo) {
		return sqlSession.selectOne("board.detail",vo);
	}
	//조회수 메소드
	public void updateReadcount(BoardVO vo) {
		sqlSession.update("board.updateReadcount",vo);
	}
	///////////////////////////////////////////////////////
	public int insert(BoardVO vo) {
		return sqlSession.insert("board.insert",vo);
	}
	public int update(BoardVO vo) {
		return sqlSession.update("board.update",vo);
	}
	public int delFilename(BoardVO vo) {
		return sqlSession.update("board.delFilename",vo);
	}
	public int delete(BoardVO vo) {
		return sqlSession.delete("board.delete",vo);
	}
	public int deleteGroup(BoardVO vo) {
		return sqlSession.delete("board.deleteGroup",vo);
	}
}
