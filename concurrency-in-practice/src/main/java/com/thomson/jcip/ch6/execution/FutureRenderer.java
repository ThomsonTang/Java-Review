package com.thomson.jcip.ch6.execution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用Future等待图像下载
 *
 * 模拟了根据页面内容分开渲染文本和图片，渲染图片时需要先下载图片，这个过程可以异步执行。
 *
 * @author Thomson Tang
 * @version Created: 27/08/2017.
 */
public class FutureRenderer {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> result = new ArrayList<>();
                for (ImageInfo info : imageInfos) {
                    result.add(info.downloadImage());
                }
                return result;
            }
        };

        Future<List<ImageData>> future = executor.submit(task);
        renderText(source);

        try {
            List<ImageData> imageData = future.get();
            for (ImageData data : imageData) {
                renderImage(data);
            }
        } catch (InterruptedException e) {
            // 重新设置线程的中断状态
            Thread.currentThread().interrupt();
            // 由于不需要结果，因此取消任务
            future.cancel(true);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private void renderImage(ImageData data) {
        // 渲染图片...
    }

    private void renderText(CharSequence source) {
        // 渲染文本...
    }

    /**
     * 扫描并获得页面中所有的图片信息
     *
     * @param source 页面内容
     * @return 图片信息
     */
    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        return new ArrayList<>();
    }

    // 图片信息类
    private class ImageInfo {
        public ImageData downloadImage() {
            // 下载具体的图片数据
            return new ImageData();
        }
    }

    // 图片数据类
    private class ImageData {
    }
}
