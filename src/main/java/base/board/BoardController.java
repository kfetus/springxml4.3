package base.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import base.util.SessionManager;
import base.vo.UserVO;

@Controller
@ResponseBody
public class BoardController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private SessionManager sessionManager;
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping(value = "/boardList.do")
	public Map<String,Object> boardList(@RequestBody  HashMap<String,String> map) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ boardList 시작=" + map);
		Map<String , Object> retMap = new HashMap<String,Object>();
		
		List<HashMap<String,String>> resultList = boardService.selectBoardList(map);

		if( resultList.size() == 0) {
			retMap.put("RESCODE","0000");
			retMap.put("RESMSG","데이타 없습니다.");
			retMap.put("RESULT_SIZE","0");
			return retMap;
		} else {
			retMap.put("RESCODE","0000");
			retMap.put("RESMSG","");
			retMap.put("RESULT_SIZE",resultList.size());
			retMap.put("RESULT_LIST",resultList);
		}

		LOGGER.debug("@@@@@@@@@@@ boardList 종료"+ retMap);
		return retMap;
	}
	
	@RequestMapping(value = "/boardOne.do")
	public Map<String,Object> selectBoardOne(@RequestBody  HashMap<String,String> map) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ selectBoardOne 시작=" + map);
		Map<String , Object> retMap = new HashMap<String,Object>();
		
		String seq = map.get("SEQ");
		
		HashMap<String,String> resultData = boardService.selectBoardOne(seq);

		retMap.put("RESCODE","0000");
		retMap.put("RESMSG","");
		retMap.put("RESULT_DATA",resultData);

		LOGGER.debug("@@@@@@@@@@@ selectBoardOne 종료"+retMap);
		return retMap;
	}
	
	@RequestMapping(value = "/insertBoardOne.do")
	public Map<String,Object> insertBoardOne(@RequestBody  HashMap<String,String> map, HttpServletRequest req) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ insertBoardOne 시작=" + map);
		Map<String , Object> retMap = new HashMap<String,Object>();
		
		UserVO vo = sessionManager.getUserInfo(req);
		if (vo == null) {
			retMap.put("RESCODE","9998");
			retMap.put("RESMSG","로그인 정보가 없습니다.");
			LOGGER.debug("@@@@@@@@@@@ insertBoardOne 에러발생=" + retMap);
			return retMap;
		}
		
		int result = boardService.insertBoardOne(map);

		retMap.put("RESCODE","0000");
		retMap.put("RESMSG","");
		retMap.put("RESULT_CNT",result);

		LOGGER.debug("@@@@@@@@@@@ insertBoardOne 종료"+retMap);
		return retMap;
	}
	
	
	@RequestMapping(value = "/updateBoardOne.do")
	public Map<String,Object> updateBoardOne(@RequestBody  HashMap<String,String> map, HttpServletRequest req) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ updateBoardOne 시작=" + map);
		Map<String , Object> retMap = new HashMap<String,Object>();
		
		UserVO vo = sessionManager.getUserInfo(req);
		if (vo == null) {
			retMap.put("RESCODE","9998");
			retMap.put("RESMSG","로그인 정보가 없습니다.");
			return retMap;
		}
		
		int result = boardService.updateBoardOne(map);

		retMap.put("RESCODE","0000");
		retMap.put("RESMSG","");
		retMap.put("RESULT_CNT",result);

		LOGGER.debug("@@@@@@@@@@@ updateBoardOne 종료"+retMap);
		return retMap;
	}
	
	@RequestMapping(value = "/deleteBoardOne.do")
	public Map<String,Object> deleteBoardOne(@RequestBody  HashMap<String,String> map) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ updateBoardOne 시작=" + map);
		Map<String , Object> retMap = new HashMap<String,Object>();
		String seq = map.get("SEQ");
		int result = boardService.deleteBoardOne(seq);

		retMap.put("RESCODE","0000");
		retMap.put("RESMSG","");
		retMap.put("RESULT_CNT",result);

		LOGGER.debug("@@@@@@@@@@@ updateBoardOne 종료"+retMap);
		return retMap;
	}
}
