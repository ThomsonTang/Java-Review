package com.thomson.concurrent.cookbook.ch5.creating;

/**
 * 商品类，保存了名称和价格两个字段。
 *
 * @author Thomson Tang
 * @version Created: 19/09/2017.
 */
public class Product {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
