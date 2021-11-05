package com.example.web.springbootweb.annotation;

import javax.persistence.Table;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 22:06 2021/11/5
 */
@Target(value = {ElementType.METHOD,ElementType.PACKAGE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PassToken {
    public boolean required() default true;
}
