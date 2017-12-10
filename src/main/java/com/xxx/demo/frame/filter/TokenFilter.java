package com.xxx.demo.frame.filter;


import com.xxx.demo.frame.util.TokenUtils;
import com.xxx.demo.mapper.sys.SysUserMapper;
import com.xxx.demo.models.sys.SysUser;
import io.jsonwebtoken.Claims;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:Token验证过滤器
 * 自定义类上面加上@WebFilter，其中@Order注解表示执行过滤顺序，值越小，越先执行
 * @author:@luomouren.
 * @Date:2017-12-10 22:40
 */
@Order(1)
@WebFilter(filterName = "tokenFilter", urlPatterns = "/*")
public class TokenFilter implements HandlerInterceptor {
    public final static String ACCESS_TOKEN = "accessToken";

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 判断是否存在令牌信息，如果存在，则允许登录
        String accessToken = httpServletRequest.getParameter(ACCESS_TOKEN);
        // 首先验证token是否正确.
        if (accessToken != null) {
            Claims claims = TokenUtils.parseJWT(accessToken);
            String username = claims.getId();
/*
            //根据用户名查询用户信息并存入request中
            SysUserMapper usersMapper = SpringUtil.getBean(SysUserMapper.class);
            SysUser user = usersMapper.findInfoByUsername(username);
            logger.debug("isAccessAllowed user >>>>>>>> " + user);
            req.setAttribute(SecurityConfig.VAL_CURRENT_USER, user);
            return valid(username,claims.getExpiration());*/
        }

        return false;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
