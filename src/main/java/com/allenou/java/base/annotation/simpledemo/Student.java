package com.allenou.java.base.annotation.simpledemo;

@Test_Table(value="t_student111111")
public class Student {
    @Test_Column("C_ID")
    private  int id;

    @Test_Column("C_NAME")
    private String name;

    @Test_Column("C_AGE")
    private int age;

    public void setId(int id ) {
        this.id = id;
    }
    public  int getAge() {
        return  age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
}
