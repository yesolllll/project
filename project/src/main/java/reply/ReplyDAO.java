package reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ReplyVO> selectAll(ReplyVO vo) {
		return sqlSession.selectList("reply.selectAll", vo);
	}
	public int count(ReplyVO vo) {
		return sqlSession.selectOne("reply.count", vo);
	}
//-----------------------------------------------------
	//상세 페이지 와 수정 페이지에서 호출해야하는 메소드라 조회수 메소드 따로 만들어야함
	//상세 페이지 = detail + updateReadcount 
	//수정 페이지 = detail
	public ReplyVO detail(ReplyVO vo) {
		return sqlSession.selectOne("reply.detail",vo);
	}
	//조회수 메소드
	public void updateReadcount(ReplyVO vo) {
		sqlSession.update("reply.updateReadcount",vo);
	}
//-----------------------------------------------------
	/*등록할때*/
	public int insert(ReplyVO vo) {
		return sqlSession.insert("reply.insert",vo);
	}

	/* 답변달때 */
	public int insertReply(ReplyVO vo) {
		return sqlSession.insert("reply.insertReply",vo);
	}
	public void gno(int no) {
			sqlSession.update("reply.gno",no);
	}
	public int onoUpdate(ReplyVO vo) {
		return sqlSession.update("reply.onoUpdate",vo);
	}
//-----------------------------------------------------
	public int update(ReplyVO vo) {
		return sqlSession.update("reply.update",vo);
	}
	public int delFilename(ReplyVO vo) {
		return sqlSession.update("reply.delFilename",vo);
	}
	public int delete(ReplyVO vo) {
		return sqlSession.delete("reply.delete",vo);
	}
}
