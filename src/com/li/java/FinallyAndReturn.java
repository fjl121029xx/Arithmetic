package com.li.java;

/**
 * http://www.cnblogs.com/lanxuezaipiao/p/3440471.html
 */
public class FinallyAndReturn {

    public static void main(String[] args) {

        System.out.println(test2());
    }

    public static String test11() {
        try {
            System.out.println("try block");

            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test12() {
        System.out.println("return statement");

        return "after return";
    }

    public static int test2() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return 200;
        }

        // return b;
    }

    public static int test3() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            b = 150;
        }

        return 2000;
    }

}
