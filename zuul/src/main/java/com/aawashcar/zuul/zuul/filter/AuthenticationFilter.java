package com.aawashcar.zuul.zuul.filter;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.aawashcar.zuul.zuul.service.AuthenticationService;
import com.aawashcar.zuul.zuul.util.ZuulConstants;
import com.alibaba.fastjson.JSON;
//import com.alib
import com.google.common.net.HttpHeaders;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AuthenticationFilter extends ZuulFilter {
	private static final int FILTER_ORDER = FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
	
	@Autowired
	private AuthenticationService authenticationService;

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println("ZUUL REQUEST URI: " + ctx.get(FilterConstants.REQUEST_URI_KEY));
		System.out.println("HTTP REQUEST URI:" + ctx.getRequest().getRequestURI());
		String httpURI = ctx.getRequest().getRequestURI();
		System.out.println("prefix " + ZuulConstants.APP_PREFIX);
		if (httpURI.startsWith(ZuulConstants.APP_PREFIX) 
				|| httpURI.contains("wechatnotifyorder") 
				|| httpURI.contains("wechatnotifypromotion") 
				|| httpURI.startsWith(ZuulConstants.ADMIN_PREFIX)) {
			System.out.println("No need to run this filter");
			return false;
		}
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String openId = request.getHeader(ZuulConstants.HEAD_OPEN_ID);
		System.out.println("OPENID is " + openId);
		if (StringUtils.isEmpty(openId)) {
			fillContextWithError(ctx, HttpStatus.BAD_REQUEST, "Bad request...");
		}
		
//		if (!authenticationService.checkOpenId(openId)) {
//			fillContextWithError(ctx, HttpStatus.UNAUTHORIZED, "Unauthorized user...");
//		} else {
//			// TODO: set jwt ?
//		}
		
		return null;
	}
	
	
	private void fillContextWithError(RequestContext ctx, HttpStatus status, String customizedMessage) {
		ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(status.value());
		ctx.getResponse().setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		// log here
		HashMap<String, String> errorMessage = new HashMap<>();
		errorMessage.put("error", customizedMessage);
		ctx.setResponseBody(JSON.toJSONString(errorMessage));
	}
	
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}

}
