package com.itangcent.springboot.demo;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * 登录用户信息处理Resolver
 *
 * @author qinkangdeid
 * @date 2019-10-29
 */
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
//        Class<?> parameterType = parameter.getParameterType();
//        boolean assignableFrom = parameterType.isAssignableFrom(UserContent.class);
//        boolean b = parameter.hasParameterAnnotation(UserContext.class);
//        return assignableFrom && b;
        return true;
    }

    @Override
    public UserContent resolveArgument(MethodParameter parameter, ModelAndViewContainer container, NativeWebRequest request, WebDataBinderFactory factory) {
        return new UserContent(1);
    }


}
