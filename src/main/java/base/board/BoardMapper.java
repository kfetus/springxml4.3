package base.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	
	public List<HashMap<String,String>> selectBoardList(HashMap<String,String> map);

	public HashMap<String,String> selectBoardOne(String seq);

	public int insertBoardOne(HashMap<String,String> map);
	
	public int updateBoardOne(String seq);
	
	public int deleteBoardOne(String seq);
}
