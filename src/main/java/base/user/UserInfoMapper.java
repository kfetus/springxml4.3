package base.user;

import org.apache.ibatis.annotations.Mapper;

import base.vo.UserVO;

@Mapper
public interface UserInfoMapper {

	public UserVO selectUserInfoOne(String userNo);

	public int insertUserInfoOne(UserVO vo);
	
	public int updateUserInfoOne(UserVO vo);
	
	public int deleteUserInfoOne(String userNo);
}
