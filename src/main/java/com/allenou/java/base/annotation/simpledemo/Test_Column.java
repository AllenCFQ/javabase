package com.allenou.java.base.annotation.simpledemo;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface Test_Column {
    String value();
}

