package com.liqiuyue.effective.objects;

/**
 * @ClassName: CalZone
 * @Description:
 * @Author: liqiuyue
 * @Date: 2021-08-03
 */
public class CalZone extends Pizza{

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }

        @Override public CalZone build() {
            return new CalZone(this);
        }

        @Override protected Builder self() {
            return this;
        }
    }

    private CalZone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    public static void main(String[] args) {
        CalZone calZone = new CalZone.Builder().addTopping(Topping.HAM).sauceInside().build();
    }
}
