package com.dg.vote.config;

import com.dg.vote.model.User;
import com.dg.vote.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        info.addStringPermission("user:add");
//        info.addStringPermission("user:update");

        //拿到当前登陆的对象
//        Subject subject = SecurityUtils.getSubject();
//        User currentUser = (User) subject.getPrincipal();
//
//        //设置当前用户的权限
//        info.addStringPermission(currentUser.getPerms());

        //return AuthorizationInfo
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //连接数据库
        User user = userService.queryUserByName(token.getUsername());

        //数据库不存在该用户
        if (user == null) {
            return null;
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);

        //密码认证
        //第一个参数传值到授权
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
