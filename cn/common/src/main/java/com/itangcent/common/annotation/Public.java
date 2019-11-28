package com.itangcent.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 声明接口为公开接口
 */

@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface Public {
}
