package com.thomson.concurrent.pattern.ch3immutableobject;

/**
 * 状态不可变的位置信息模型
 *
 * @author Thomson Tang
 * @version Created: 10/06/2017.
 */
public final class Location {
    public final double x;
    public final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
