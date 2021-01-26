package com.fall.ioc.anno;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/26
 * @time 17:15
 * @description
 */
public class Cup {
    private int size;
    private String color;

    public Cup() {
    }

    public Cup(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public void add() {
        System.out.println("----------cup");
    }
}
