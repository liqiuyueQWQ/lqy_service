package com.liqiuyue.effective.singleton;

/**
 * @ClassName: StaticWay
 * @Description: 私有构造器强化singleton属性
 * @Author: liqiuyue
 * @Date: 2021-08-04
 */
public class StaticWay {

    // 1.
//    public static StaticWay INSTANCE = new StaticWay();
//
//    public String score;

    private static final StaticWay STATIC_WAY = new StaticWay();

    public String score;

    public static StaticWay getInstance() {
        return STATIC_WAY;
    }

}
