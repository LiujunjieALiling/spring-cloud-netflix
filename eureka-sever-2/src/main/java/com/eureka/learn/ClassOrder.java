package com.eureka.learn;

/**
 * 类加载顺序
 *
 * @author Ljj
 * @date 2020/5/29 18:30
 * @since 1.0
 */
public class ClassOrder {

    public static void main(String[] args) {


        Bar bar = new Bar();
        System.out.println(bar.getValue());

//        test();
    }


//    static ClassOrder cl = new ClassOrder();


    static {
        System.out.println("静态代码块");
    }

    static int a =100;

    int b = 10;

    {
        System.out.println("实例代码块");
    }


    ClassOrder() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }


    static void test(){
        System.out.println("静态方法");
    }

}
class Foo {
    int i = 1;

    Foo() {
        System.out.println(i);
        int x = getValue();
        System.out.println(x);
    }

    {
        i = 2;
    }

    protected int getValue() {
        return i;
    }
}

//子类
class Bar extends Foo {
    int j = 1;

    Bar() {
        j = 2;
    }

    {
        j = 3;
    }

    @Override
    protected int getValue() {
        return j;
    }
}