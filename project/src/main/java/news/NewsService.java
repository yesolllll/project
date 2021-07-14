package news;

import java.util.List;

public interface NewsService {
	List<NewsVO> selectAll(NewsVO vo);
	NewsVO detail(NewsVO vo);
	int insert(NewsVO vo);
	NewsVO edit(NewsVO vo);
	int update(NewsVO vo);
	int delete(NewsVO vo);
}
