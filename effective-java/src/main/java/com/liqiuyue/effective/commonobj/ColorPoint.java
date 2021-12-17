package com.liqiuyue.effective.commonobj;

/**
 * @ClassName: ColorPoint
 * @Author: liqiuyue
 * @Date: 2021-12-16
 */
public class ColorPoint extends Point{

    enum Color{RED,BLUE, WHITE}

    private Color color;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    static class SmellPoint extends Point{
        private Color color;

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            if (!(o instanceof SmellPoint)) { // ---->SmellPoint1 equals
                return o.equals(this);
            }
            return super.equals(o) && ((SmellPoint) o).color == color;
        }
    }

    static class SmellPoint1 extends Point{
        private Color color;

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            if (!(o instanceof SmellPoint)) { // ---->SmellPoint equals
                return o.equals(this);
            }
            return super.equals(o) && ((SmellPoint) o).color == color;
        }

    }


    public static void main(String[] args) {
        SmellPoint1 cp = new SmellPoint1();
        cp.x = 1;
        cp.y = 2;
        cp.color = Color.BLUE;
        SmellPoint cp1 = new SmellPoint();
        cp.x = 1;
        cp.y = 2;
        cp.color = Color.WHITE;

        Point p = new Point(1,2);

        System.out.println(cp.equals(p));
        System.out.println(p.equals(cp));
        // 堆溢出
//        System.out.println(cp.equals(cp1));
    }
}
