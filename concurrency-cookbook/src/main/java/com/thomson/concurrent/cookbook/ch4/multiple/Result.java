package com.thomson.concurrent.cookbook.ch4.multiple;

/***
 * This class store the results generated in the concurrent tasks of this example.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/18/16-16:58
 */
public class Result {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
