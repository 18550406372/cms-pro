package com.cms.portal.security.filter;

import com.alibaba.fastjson.JSON;
import com.cms.context.foundation.Result;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 登录拦截配置类
 */
public class CmsAuthenticationFilter extends FormAuthenticationFilter {
    private static final String ADMIN_LOGIN = "/admin/cms/login.do";
    //判断是不是一个登录的请求
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(), request) || this.pathsMatch(ADMIN_LOGIN, request);
    }

    /**
     * 处理登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;Charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(Result.success("登录成功")));

        return false;
    }




}
