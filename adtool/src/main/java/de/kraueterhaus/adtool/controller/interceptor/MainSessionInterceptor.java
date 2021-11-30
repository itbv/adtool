package de.kraueterhaus.adtool.controller.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import de.kraueterhaus.adtool.controller.ADToolRootController;
import de.kraueterhaus.adtool.model.Login;

public class MainSessionInterceptor implements HandlerInterceptor
{
	public static final String ADTOOLUSER_KEY = "adToolUserKey";

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws IOException
	{
		if (modelAndView == null) {
			return;
		}
		
		boolean isLoginView = ADToolRootController.VIEW_LOGIN_NAME.equals(modelAndView.getViewName());
		Login login = (Login) modelAndView.getModel().get(ADToolRootController.MODEL_LOGIN_NAME);
		String sessionToken = (String) request.getSession().getAttribute(ADToolRootController.SESSION_TOKEN_KEY);

		if (login == null && !isLoginView && sessionToken == null)
		{
			response.sendRedirect(ADToolRootController.LOGIN_URL);
		}

		return;
	}
}
