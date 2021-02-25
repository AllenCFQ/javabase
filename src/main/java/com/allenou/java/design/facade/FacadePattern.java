package com.allenou.java.design.facade;

/**
 * 外观（Facade）模式是“迪米特法则”的典型应用，它有以下主要优点。
 * 1.降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。
 * 2.对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。
 * 3.降低了大型软件系统中的编译依赖性，简化了系统在不同平台之间的移植过程，因为编译一个子系统不会影响其他的子系统，也不会影响外观对象。
 * <p>
 * 外观（Facade）模式的主要缺点如下。
 * 1.不能很好地限制客户使用子系统类，很容易带来未知风险。
 * 2.增加新的子系统可能需要修改外观类或客户端的源代码，违背了“开闭原则”。
 * <p>
 * 什么是开闭原则？？
 *
 * 外观模式、装饰者模式和适配器模式，难道这三个模式有什么共同点吗？
 * 是的，它们的共同点就是：对接口进行再次封装。
 * 装饰者模式是将被装饰者的接口动态的加上新的职责，
 * 适配器模式是将被适配者的接口转换成新的接口，
 * 外观模式则是组合多个系统的接口创造新的接口。
 * 各种模式都有各自独特的作用，要看你怎么用了。
 * OYP
 */
public class FacadePattern {
    public static void main(String[] args) {
        /**
         * 使用外观facade模式
         */
        Facade f = new Facade();
        f.method();

        /**
         * 不使用外观facade模式
         */
        SubSystem01 obj1 = new SubSystem01();
        SubSystem02 obj2 = new SubSystem02();
        SubSystem03 obj3 = new SubSystem03();
        obj1.method1();
        obj2.method2();
        obj3.method3();

    }
}

//外观角色
class Facade {
    private SubSystem01 obj1 = new SubSystem01();
    private SubSystem02 obj2 = new SubSystem02();
    private SubSystem03 obj3 = new SubSystem03();

    public void method() {
        obj1.method1();
        obj2.method2();
        obj3.method3();
    }
}

//子系统角色
class SubSystem01 {
    public void method1() {
        System.out.println("子系统01的method1()被调用！");
    }
}

//子系统角色
class SubSystem02 {
    public void method2() {
        System.out.println("子系统02的method2()被调用！");
    }
}

//子系统角色
class SubSystem03 {
    public void method3() {
        System.out.println("子系统03的method3()被调用！");
    }
}
