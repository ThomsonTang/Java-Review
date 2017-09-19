package com.thomson.concurrent.cookbook.ch5.creating;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品对象生成器。
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
