package base.comm.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class BaseExceptionResolver extends SimpleMappingExceptionResolver{

	@Override
	protected ModelAndView doResolveException(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		//에러 로그 출력
		logger.error("¿¿¿¿¿¿¿¿¿¿¿¿ BaseExceptionResolver.doResolveException 에러로그 ¿¿¿¿¿¿¿¿¿¿¿¿");
		ex.printStackTrace();
		
		String viewName = determineViewName(ex, request);
		logger.error("¿¿¿¿¿¿¿¿¿¿¿¿ BaseExceptionResolver.doResolveException viewNam="+viewName);
		if (viewName != null) {
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			return getModelAndView(viewName, ex, request);
		}
		else {
			return null;
		}
	}
}
