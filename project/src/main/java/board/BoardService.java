package board;

import java.util.List;

public interface BoardService {
	List<BoardVO> selectAll(BoardVO vo);
	BoardVO detail(BoardVO vo);
	int insert(BoardVO vo);
	BoardVO edit(BoardVO vo);
	int update(BoardVO vo);
	int delete(BoardVO vo);
}
