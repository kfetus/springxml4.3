package base.rest;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author ojh
 *
 */
@Controller
@ResponseBody
public class RestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);
	
	@RequestMapping(value = "/sampleRest.do")
	public String sampleRest(HttpServletRequest req, @RequestBody Map<String, Object> map) {
		LOGGER.debug("@@@@@@@@@@@@@@@@@@"+req.getParameterMap());
		LOGGER.debug("@@@@@@@@@@@@@@@@@@"+map);
		
		Enumeration<String> e = req.getParameterNames();
		
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			LOGGER.debug("param key="+key+", value="+req.getParameter(key));	
		}
		
		
		Enumeration<String> attribute = req.getAttributeNames();
		
		while(attribute.hasMoreElements()) {
			String key2 = attribute.nextElement();
			LOGGER.debug("attribute key="+key2+", value="+req.getAttribute(key2));	
		}

		Enumeration<String> header = req.getHeaderNames();
		
		while(header.hasMoreElements()) {
			String key3 = header.nextElement();
			LOGGER.debug("header key="+key3+", value="+req.getHeader(key3));	
		}

		
		return "sample";
	}
	
	
	@RequestMapping(value = "/restBaseModel.do")
	public Map<String,String> restBaseModel(@RequestBody Map<String, String> map) {
		LOGGER.debug("@@@@@@@@@@@ restBaseModel 시작="+map);
		


		LOGGER.debug("@@@@@@@@@@@ restBaseModel 종료");
		return map;
	}

}
