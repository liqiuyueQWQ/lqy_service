package com.liqiuyue.effective.commonobj;

import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: Point
 * @Author: liqiuyue
 * @Date: 2021-12-16
 */
public class Point {

    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode(){
        return 3;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(){}
    static Set<Point> unitCircle = Set.of(new Point(1, 0), new Point(0, 1), new Point(-1, 0), new Point(0, -1));
    public static void main(String[] args) {
        Map<Point, String> m = new HashMap<>();
        m.put(new Point(1, 0), "10");
        m.put(new Point(1, 0), "11");
        System.out.println(m.get(new Point(1,0)));
        System.out.println(1);
//        System.out.println(new Point(1, 0).equals(new Point(1, 0)));
//        System.out.println(new Point(1, 0).hashCode());
//        System.out.println(new Point(1, 0).hashCode());
//        System.out.println(unitCircle.contains(new Point(1, 0)));
    }

    static class CounterPoint extends Point {
        private static final AtomicInteger counter = new AtomicInteger();

        public CounterPoint(int x, int y) {
            super(x, y);
            counter.incrementAndGet();
        }
        public static int numberCreated(){
            return counter.get();
        }
    }
}
