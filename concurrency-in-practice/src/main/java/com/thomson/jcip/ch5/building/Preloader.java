package com.thomson.jcip.ch5.building;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Using {@link java.util.concurrent.FutureTask} to Preload Data that is Needed later.
 *
 * @author Thomson Tang
 * @version Created: 19/08/2017.
 */
public class Preloader {
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return loadProductInfo();
        }
    });

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw launderThrowable(e);
        }
    }

    private RuntimeException launderThrowable(Throwable e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else if (e instanceof Error) {
            throw (Error) e;
        } else {
            throw new IllegalStateException("Not unchecked", e);
        }
    }

    private ProductInfo loadProductInfo() {
        return new ProductInfo("1111111", "Apple iPhone 6");
    }

    class ProductInfo {
        private String productId;
        private String productName;

        public ProductInfo(String productId, String productName) {
            this.productId = productId;
            this.productName = productName;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        @Override
        public String toString() {
            return "ProductInfo{" +
                    "productId='" + productId + '\'' +
                    ", productName='" + productName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Preloader preloader = new Preloader();
        preloader.start();
        System.out.println(preloader.get());
    }
}
