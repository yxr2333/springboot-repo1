package com.ctgu.yxr.service.impl;

import com.ctgu.yxr.annotation.PassToken;
import com.ctgu.yxr.entity.User;
import com.ctgu.yxr.exception.DataNotFoundException;
import com.ctgu.yxr.exception.NeedToLoginException;
import com.ctgu.yxr.service.UserService;
import com.ctgu.yxr.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        System.out.println("object:" +object);
        String token = request.getHeader("token");
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        //获得对应controller里面的方法
        Method method = handlerMethod.getMethod();
        System.out.println("method:" + method);
        // 如果是被注解了@PassToken的话，那么就不进行校验
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            //如果 passToken注解的required值为true => 表示不需要token
            if(passToken.required()){
                return true;
            }
        }else{
            System.out.println("被jwt拦截了，需要进行token权限认证");
            // 请求头中没有找到token
            if(token == null){
                throw new NeedToLoginException("需要先登录");
            }
            String userName = JwtUtils.getAudience(token);
            User user = userService.getOneByName(userName);
            if(user == null){
                System.out.println("AdminNotExist");
                throw new DataNotFoundException("不存在此用户");
            }

            JwtUtils.verifyToken(token,userName);

            String name = JwtUtils.getClaimByName(token, "userName").asString();
            System.out.println("name:" + name);
            request.setAttribute("username",name);
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

