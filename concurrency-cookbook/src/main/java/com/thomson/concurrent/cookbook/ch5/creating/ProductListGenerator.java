package com.thomson.concurrent.cookbook.ch5.creating;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品列表生成器，根据指定大小生成相应的商品列表。
 *
 * @author Thomson Tang
 * @version Created: 19/09/2017.
 */
public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Product product = new Product("Product" + i, 10);
            ret.add(product);
        }
        return ret;
    }
}
