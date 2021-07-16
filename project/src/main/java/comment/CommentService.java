package comment;

import java.util.List;

public interface CommentService {
	List<CommentVO> selectAll(CommentVO vo);
	int count(CommentVO vo);
	int insert(CommentVO vo);
	int delete(CommentVO vo);
}
