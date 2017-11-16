package com.mastermoin.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mastermoin.demo.security.AuthTokenValidator;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter{
	
	private static final AuthTokenValidator authTokenValidator = new AuthTokenValidator();
	
	@Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("____________________________________________");
		System.out.println("RequestURI::" + request.getRequestURI());
		System.out.println("____________________________________________");
		
		boolean authenticate =  authTokenValidator.isValid(request.getHeader("Authorization"));
		
		if(!authenticate) {
			response.setStatus(401);
		}
		
		return authenticate;
	 }

	 @Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model) throws Exception {
		System.out.println("_________________________________________");
		System.out.println("In postHandle request processing completed by @RestController");
		System.out.println("_________________________________________");
	 }
	

}
