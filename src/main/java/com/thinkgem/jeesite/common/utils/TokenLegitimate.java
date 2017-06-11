package com.thinkgem.jeesite.common.utils;

import com.thinkgem.jeesite.common.supcan.common.properties.Properties;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by jkf on 2017/4/8.
 */
@Provider
@Priority(Priorities.AUTHENTICATION)//最高优先级
//实现该拦截器借口
//@Provider可以自动注册
public class TokenLegitimate implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

    }
}
