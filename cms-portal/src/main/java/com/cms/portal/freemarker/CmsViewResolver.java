package com.cms.portal.freemarker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 配置全局绝对路径，解决部署后资源引入问题
 */
@Slf4j
public class CmsViewResolver extends FreeMarkerView {
    private static final String ADMIN_PATH="/admin/cms/";
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        /**
         * getContextPath():获取项目的根路径
         * getServletPath():获取能够与web.xml中的<servlet-mapping>标签中“url-pattern”中匹配的路径，注意是完全匹配的部分，*的部分不包括
         * getRequestURI() 返回除去host（域名或者ip）部分的路径
         */
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        //如果包含，就认为是后台请求路径
        if (requestURI.contains(ADMIN_PATH)){
            model.put("adminPath",contextPath+servletPath);
        }
        model.put("basePath",contextPath);
    }
}
