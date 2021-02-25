package com.allenou.java.base.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationDemo {
    //注解可以显示赋值，如果没有默认值，则必须给注解赋值
    @MyAnnotation(index = 10,name = "world")
    public void test(String name,int index){
        System.out.println(name + index);
    }

    public static void main(String[] args) {

    }
}

@Target({ElementType.METHOD,ElementType.TYPE})//作用域
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    //注解参数：参数类型 + 参数名()
    String name() default "";//default 默认值

    int index();

    String[] vals() default {"hello"};
}

