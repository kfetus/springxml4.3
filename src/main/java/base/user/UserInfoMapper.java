package base.user;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

	public HashMap<String,String> selectUserInfoOne(String seq);

	public int insertUserInfoOne(HashMap<String,String> map);
	
	public int updateUserInfoOne(HashMap<String,String> map);
	
	public int deleteUserInfoOne(String seq);
}
