package com.loukaiwei;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//要么在这里加Componet，要么在Config文件里面加
//@Component
public class PreRequestLogFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

    public PreRequestLogFilter() {

    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest servletRequest = context.getRequest();
        String header = servletRequest.getHeader("BlockMe");
        if (header != null && header.equalsIgnoreCase("true")) {

            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("BlockMe value cannot be true,stop your fucking action");
        }
        LOGGER.info(String.format("发送 %s 请求到 %s", servletRequest.getMethod(), servletRequest.getRequestURL().toString()));
        return null;
    }
}
