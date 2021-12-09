package com.liqiuyue.effective.di;

import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: SpellChecker
 * @Description: 拼写检查器
 * @Author: liqiuyue
 * @Date: 2021-11-04
 */
public class SpellChecker {

    private String pizza = null;

    public SpellChecker(String pizza) {
        this.pizza = Objects.requireNonNull(pizza);
    }
    // 当创建一个新的实例时，就将该资源传到构造器中。这就是依赖注入的一种形式

    // 频繁使用的方法和变量 使用单例

    //避免创建不必要的对象
    // 静态工厂创建对象

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Long  sumL = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sumL += i;
        }

        // 效率比上面高
        long  suml = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            suml += i;
        }
//        System.out.println(sum);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }
}
