package base.schedule;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("scheduleService")
public class ScheduleServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

	@Autowired
	private ScheduleMapper scheduleMapper;
	
	public List<HashMap<String,String>> selectScheduleList(HashMap<String,String> paramMap) throws Exception {
		LOGGER.debug("@@@@@@@@@@@@@ selectScheduleList paramMap=" + paramMap);
		List<HashMap<String,String>> result = scheduleMapper.selectScheduleList(paramMap);
		return result;
	}
}
