package base.board;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FileDownController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileDownController.class);

	@Autowired
	private BoardServiceImpl boardService;


	/**
	 * 
	 * @설명 : 일반적인 파일 다운로드
	 * @param map
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/normalFiledown.do")
	public void normalFiledown(@RequestParam HashMap<String, String> map, HttpServletResponse response) throws Exception {
		LOGGER.debug("@@@@@@@@@@@ normalFiledown 시작=" + map);

		HashMap<String, Object> resultData = boardService.selectBoardFileOne(map);
		LOGGER.debug("@@@@@@@@@@@ selectBoardFileOne DB 조회 결과=" + resultData);
		
	    byte[] fileData = (byte[]) resultData.get("FILE_DATA");
	    String fileName = (String)resultData.get("FILE_NAME");

        response.setContentType("application/octet-stream"); 
        response.setContentLength(fileData.length);
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName,"UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileData);
        response.getOutputStream().flush();
        response.getOutputStream().close();
	}
	
	
}
