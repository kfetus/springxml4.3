package base.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import base.util.SessionManager;
import base.vo.UserVO;

/**
 * 
 * @author ojh
 *
 */
@Controller
@ResponseBody
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private SessionManager sessionManager;
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@RequestMapping(value = "/restLogin.do")
	public Map<String,Object> restLogin(@RequestBody  UserVO vo, HttpServletRequest req) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ restLogin 시작="+vo.toString());
		Map<String , Object> retMap = new HashMap<String,Object>();
		
		if( !StringUtils.hasText(vo.getUserId())) {
			retMap.put("RESCODE","9999");
			retMap.put("RESMSG","아이디가 없습니다.");
			return retMap;
		}
		if (!StringUtils.hasText(vo.getUserPass()) ) {
			retMap.put("RESCODE","9999");
			retMap.put("RESMSG","패스워드가 없습니다.");
			return retMap;
		}

		UserVO vo2 = loginService.selectOneUserVo(vo);
		LOGGER.debug("@@@@@@@@@@@ restLogin after="+vo2);
		if( vo2 == null) {
			retMap.put("RESCODE","0001");
			retMap.put("RESMSG","사용자가 없습니다.");
			return retMap;
			
		} else {
			retMap.put("RESCODE","0000");
			retMap.put("RESMSG","");
//			vo.setUserIp((null != req.getHeader("X-FORWARDED-FOR")) ? req.getHeader("X-FORWARDED-FOR") : req.getRemoteAddr());
			vo2.setUserPass("");
			retMap.put("userInfo", vo2);
			
			sessionManager.createUserInfo(req, vo2);
		}

		LOGGER.debug("@@@@@@@@@@@ restLogin 종료"+sessionManager.getUserInfo(req));
		return retMap;
	}
	
	
	@RequestMapping(value = "/restLogOut.do")
	public Map<String,Object> restLogOut(@RequestBody Map<String, Object> map, HttpServletRequest req) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ restLogOut 시작="+map);

		sessionManager.removeUserInfo(req);
		LOGGER.debug("@@@@@@@@@@@ restLogOut 종료");
		return map;
	}

	@RequestMapping(value = "/checkUser.do")
	public Map<String,Object> checkUser(HttpServletRequest req) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ checkUser 시작=");
		
		Map<String , Object> retMap = new HashMap<String,Object>();
		retMap.put("RESCODE","0000");
		retMap.put("RESMSG","");
				
		UserVO vo = (UserVO)sessionManager.getUserInfo(req);
		if( vo != null) {
			LOGGER.debug("@@@@@@@@@@@ 로그인 사용자 정보:"+vo.toString());
			retMap.put("loginYn","Y");
		} else {
			retMap.put("loginYn","N");
		}
		retMap.put("userInfo", vo);
		LOGGER.debug("@@@@@@@@@@@ checkUser 종료");
		return retMap;
	}

	
}
