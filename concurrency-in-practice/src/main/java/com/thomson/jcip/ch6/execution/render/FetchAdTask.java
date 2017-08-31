package com.thomson.jcip.ch6.execution.render;

import java.util.concurrent.Callable;

/**
 * 获取广告的任务
 *
 * @author Thomson Tang
 * @version Created: 31/08/2017.
 */
public class FetchAdTask implements Callable<Ad> {

    @Override
    public Ad call() throws Exception {
        // 获取广告的具体实现方法
        return new Ad();
    }
}
