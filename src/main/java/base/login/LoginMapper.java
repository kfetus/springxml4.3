package base.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import base.vo.UserVO;

@Mapper
public interface LoginMapper {
	
	public UserVO selectOneUserVo(UserVO vo);
	
	public List<UserVO> selectListUserVo();
}

