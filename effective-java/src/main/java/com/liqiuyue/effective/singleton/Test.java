package com.liqiuyue.effective.singleton;

/**
 * @ClassName: Test
 * @Description: 测试
 * @Author: liqiuyue
 * @Date: 2021-08-04
 */
public class Test {

    public static void main(String[] args) {
        testStaticWay();
    }

    public static void testStaticWay(){
        StaticWay instance = StaticWay.getInstance();
        instance.score = "20";
        StaticWay instance1 = StaticWay.getInstance();
        System.out.println(instance1.score);
    }

}
