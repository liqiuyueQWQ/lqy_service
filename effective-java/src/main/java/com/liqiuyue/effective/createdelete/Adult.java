package com.liqiuyue.effective.createdelete;

/**
 * @ClassName: Adult
 * @Author: liqiuyue
 * @Date: 2021-12-10
 */
public class Adult {

    public static void main(String[] args) throws Exception {
//        adult();

        teenager();
    }

    static void adult() throws Exception{
        try (Room room = new Room(3)) {
            System.out.println("Goodbye");
        }
    }

    static void teenager() {
        new Room(9);
        System.out.println("Peace out");
    }

}
