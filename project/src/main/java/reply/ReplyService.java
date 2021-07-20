package reply;

import java.util.List;

public interface ReplyService {
	List<ReplyVO> selectAll(ReplyVO vo);
	ReplyVO detail(ReplyVO vo);
	int insert(ReplyVO vo); //gno update 는 insert 문이 실행이 될때 필요하므로 여기에 추가하면 됨
	int insertReply(ReplyVO vo); 
	ReplyVO edit(ReplyVO vo);
	int update(ReplyVO vo);
	int delete(ReplyVO vo);
}
