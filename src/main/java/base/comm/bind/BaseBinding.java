package base.comm.bind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class BaseBinding implements WebBindingInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseBinding.class);
	
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		LOGGER.debug("@@@@@@@@@@@ BaseBinding.initBinder 시작=" + binder.getObjectName());
	}

}
