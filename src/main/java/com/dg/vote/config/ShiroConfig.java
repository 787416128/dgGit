package com.dg.vote.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //3.shiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
        *   anno:   无需认证就可以访问
        *   authc:  必须认证了才能访问
        *   user:   必须拥有 记住我 功能才能使用
        *   perms:  拥有对某个资源的权限才能访问
        *   role:   拥有某个角色权限才能访问
        * */



        Map<String, String> filterMap = new LinkedHashMap<>();
        //授权
//        filterMap.put("/user/add", "perms[user:add]");
//        filterMap.put("/user/update", "perms[user:update]");

//        filterMap.put("/user/add", "authc");
//        filterMap.put("/user/update", "authc");

        filterMap.put("/images/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/js/**","anon");

        //拦截
//        filterMap.put("/user/userCentral", "authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置未授权请求页面
        bean.setUnauthorizedUrl("/noauth");

        //设置登录的请求
        bean.setLoginUrl("/user/toLogin");

        return bean;
    }

    //2.DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    //1.创建 Reaelm 对象，自定义类
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
