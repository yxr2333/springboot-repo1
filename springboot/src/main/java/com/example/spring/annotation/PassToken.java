package com.example.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 14:30 2021/11/4
 */
@Target(value = {ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean requiredToken() default true;
}
