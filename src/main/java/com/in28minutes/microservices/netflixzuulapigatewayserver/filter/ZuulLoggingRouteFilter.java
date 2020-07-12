package com.in28minutes.microservices.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingRouteFilter extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		
		 // Get Current Request being Handled
		  HttpServletRequest request = RequestContext.getCurrentContext().getRequest();  
		  logger.info("***Route Filter***** " + String.format("Request to : %s",request.getMethod(), request.getRequestURL().toString()));
	      return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "route";
	}
	
	

}
