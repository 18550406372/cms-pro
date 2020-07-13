package com.cms.portal.security.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.web.filter.authc.UserFilter;
@Getter
@Setter
public class CmsUserFilter extends UserFilter {
    private String adminLoginUrl;  //后台登录连接
    private String adminPrefix;
}
