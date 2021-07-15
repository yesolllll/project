package user;

import java.util.List;

public interface UserService {
	List<UserVO> selectAll(UserVO vo);
	UserVO deatil(UserVO vo);
	int insert(UserVO vo);
	UserVO edit(UserVO vo);
	int update(UserVO vo);
	int delete(UserVO vo);
	int isDuplicateId(String id);
	UserVO login(UserVO vo);
	UserVO searchId(UserVO vo);
	UserVO searchPwd(UserVO vo);
	
}
