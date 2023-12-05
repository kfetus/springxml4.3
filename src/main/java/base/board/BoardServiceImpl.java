package base.board;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardMapper boardMapper;

	public int insertBoardOne(HashMap<String,String> map) throws Exception {
		LOGGER.debug("@@@@@@@@@@@@@ data=" + map);
		int result = boardMapper.insertBoardOne(map);
		return result;
	}
	
	public List<HashMap<String,String>> selectBoardList(HashMap<String,String> map) throws Exception {
		List<HashMap<String,String>> result = boardMapper.selectBoardList(map);
		return result;
	}

	public HashMap<String,String> selectBoardOne(String seq) throws Exception {
		HashMap<String,String> result = boardMapper.selectBoardOne(seq);
		return result;
	}

	public int updateBoardOne(String seq) throws Exception {
		LOGGER.debug("@@@@@@@@@@@@@ key=" + seq);
		int result = boardMapper.updateBoardOne(seq);
		return result;
	}
	
	public int deleteBoardOne(String seq) throws Exception {
		LOGGER.debug("@@@@@@@@@@@@@ key=" + seq);
		int result = boardMapper.deleteBoardOne(seq);
		return result;
	}
	

}

