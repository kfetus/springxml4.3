package base.schedule;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {

	public List<HashMap<String,String>> selectScheduleList(String yymmdd);
}
