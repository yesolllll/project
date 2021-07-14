package news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<NewsVO> selectAll(NewsVO vo) {
		return sqlSession.selectList("news.selectAll", vo);
	}
	public int count(NewsVO vo) {
		return sqlSession.selectOne("news.count", vo);
	}
	///////////////////////////////////////////////////////
	//상세 페이지 와 수정 페이지에서 호출해야하는 메소드라 조회수 메소드 따로 만들어야함
	//상세 페이지 = detail + updateReadcount 
	//수정 페이지 = detail
	public NewsVO detail(NewsVO vo) {
		return sqlSession.selectOne("news.detail",vo);
	}
	//조회수 메소드
	public void updateReadcount(NewsVO vo) {
		sqlSession.update("news.updateReadcount",vo);
	}
	///////////////////////////////////////////////////////
	public int insert(NewsVO vo) {
		return sqlSession.insert("news.insert",vo);
	}
	public int update(NewsVO vo) {
		return sqlSession.update("news.update",vo);
	}
	public int delFilename(NewsVO vo) {
		return sqlSession.update("news.delFilename",vo);
	}
	public int delete(NewsVO vo) {
		return sqlSession.delete("news.delete",vo);
	}
}
