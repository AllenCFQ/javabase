package com.allenou.java.base.annotation.simpledemo;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
/**
 * https://www.cnblogs.com/xiaostudy/p/11421534.html
 */
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(666);
        student.setName("uzi");
        student.setAge(23);
        System.out.println(querySql(student));
    }

    private static String querySql(Object f)  {
        StringBuilder sql = new StringBuilder();
        Class cl = f.getClass();
        boolean exists = cl.isAnnotationPresent(Test_Table.class);
        if (!exists) {
            return null;
        }
        // 获取类上注解
        Test_Table t = (Test_Table) cl.getAnnotation(Test_Table.class);

        String tableName = t.value();
        log("类"+f.getClass()+"的注解:"+t.toString());

        Field[] fields =cl.getDeclaredFields();
        for (Field field:fields){
            boolean fexists = field.isAnnotationPresent(Test_Column.class);
            if (!fexists) {
                continue;
            }
            // 获取field上的注解
            Test_Column column = field.getAnnotation(Test_Column.class);
            String columnName = column.value();
            // 获取字段的值
            String fieldName = field.getName();
            String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method method = null;
            Object columuValue = null;
            try {
                method = cl.getMethod(getMethodName);
                columuValue = method.invoke(f);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            log("属性"+fieldName+"注解："+column.toString()+"  实际的值为"+columuValue);

        }
        return tableName;
    }

    public static  void log ( String string ) {
        System.out.println(string);
    }
}
