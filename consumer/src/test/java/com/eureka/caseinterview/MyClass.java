package com.eureka.caseinterview;

/**
 * @author Ljj
 * @date 2020/4/21 15:00
 * @since 1.0
 */
public class MyClass {

    public static void main(String[] args) {
        System.out.println(test());
    }
    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
            return temp;
        }
    }
}
