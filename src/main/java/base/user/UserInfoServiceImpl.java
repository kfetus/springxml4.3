package base.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.vo.UserVO;

@Service("userInfoService")
public class UserInfoServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoMapper userInfoMapper;

	
	public int checkDupIdOne(UserVO vo) throws Exception {
		int cnt = userInfoMapper.checkDupIdOne(vo);
		return cnt;
	}
	
	
	public int insertUserInfoOne(UserVO vo) throws Exception {
		LOGGER.debug("@@@@@@@@@@@@@ insertUserInfoOne data=" + vo.toString());
		int result = userInfoMapper.insertUserInfoOne(vo);
		return result;
	}
	
	public UserVO selectUserInfoOne(String userNo) throws Exception {
		UserVO vo = userInfoMapper.selectUserInfoOne(userNo);
		return vo;
	}

	public int updateUserInfoOne(UserVO vo) throws Exception {
		LOGGER.debug("@@@@@@@@@@@@@ updateUserInfoOne map=" + vo.toString());
		int result = userInfoMapper.updateUserInfoOne(vo);
		return result;
	}
	
	public int deleteUserInfoOne(String userNo) throws Exception {
		LOGGER.debug("@@@@@@@@@@@@@ deleteUserInfoOne key=" + userNo);
		int result = userInfoMapper.deleteUserInfoOne(userNo);
		return result;
	}
}
