package base.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ScheduleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired
	private ScheduleServiceImpl scheduleService;
	
	@RequestMapping(value = "/scheduleCalender.do")
	public Map<String,Object> scheduleCalender(@RequestBody  HashMap<String,String> map) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ scheduleCalender 시작=" + map);
		Map<String , Object> retMap = new HashMap<String,Object>();
		String yyyymmdd = map.get("yyyymmdd");
		if( !StringUtils.hasText(yyyymmdd)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date now = new Date();
			yyyymmdd = format.format(now);
		} else {
			yyyymmdd = yyyymmdd + "01";
		}
		List<HashMap<String,String>> resultList = scheduleService.selectScheduleList(yyyymmdd);

		retMap.put("RESCODE","0000");
		retMap.put("RESMSG","");
		retMap.put("RESULT_DATA",resultList);

		LOGGER.debug("@@@@@@@@@@@ scheduleCalender 종료"+ retMap);
		return retMap;
	}
}
