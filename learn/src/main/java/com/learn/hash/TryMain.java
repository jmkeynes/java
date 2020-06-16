package com.learn.hash;

/**
 * @author 江文谱
 * @version 1.0
 * @date
 */
public class TryMain {

    public static void main(String[] args) {
        int len = 10;
        try {
            for (int i = 0; i < len; i++) {
                if (i == 2) {
                    System.out.println("main" + i);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("err");
        } finally {
            System.out.println("finally");
        }
    }
}
