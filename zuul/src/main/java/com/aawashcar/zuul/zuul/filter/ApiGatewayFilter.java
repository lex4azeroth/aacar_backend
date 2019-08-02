package com.aawashcar.zuul.zuul.filter;

import static com.aawashcar.zuul.zuul.util.ZuulConstants.SERVICE_ID_APIGATEWAY;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ApiGatewayFilter extends ZuulFilter {
	
	private static final int FILTER_ORDER = FilterConstants.PRE_DECORATION_FILTER_ORDER + 2;
	
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		String serviceId = ctx.get(FilterConstants.SERVICE_ID_KEY).toString();
		return SERVICE_ID_APIGATEWAY.equals(serviceId);
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		String redirect = ctx.getRequest().getRequestURI();
		if (redirect.startsWith("/admin/external")) {
			redirect = redirect.replace("/admin/external", "");
		}
		
		ctx.put(FilterConstants.REQUEST_URI_KEY, redirect);
		return null;
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
