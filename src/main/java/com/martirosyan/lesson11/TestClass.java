package com.martirosyan.lesson11;

public class TestClass {

    @BeforeSuite
    public void method1(){
        System.out.println("first");
    }

    @AfterSuite
    public void method2(){
        System.out.println("last");
    }

    @Test
    public void method3(){
        System.out.println("m1-1");
    }

    @Test
    public void method4(){
        System.out.println("m1-2");
    }

    @Test(3)
    public void method5(){
        System.out.println("3");
    }

    @Test(4)
    public void method6(){
        System.out.println("4");
    }
}
