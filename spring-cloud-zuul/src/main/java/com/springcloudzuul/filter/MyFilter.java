package com.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * zuul不仅只是路由，并且还能过滤，做一些安全验证。
 *
 * @author zlj
 */
@Component
public class MyFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *  pre：路由之前
     *  routing：路由之时
     *  post： 路由之后
     *  error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 可以写逻辑判断，是否要过滤，true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        LOGGER.info("{}, {}", request.getMethod(), request.getRequestURL());

        String accessToken = request.getParameter("hello");

        if (StringUtils.isEmpty(accessToken)) {
            LOGGER.warn("Token is Empty!");

            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        LOGGER.info("OK!");
        return null;
    }
}
