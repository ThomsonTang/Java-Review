package com.thomson.jcip.ch6.execution.render;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 使用{@link CompletionService}使页面元素在下载完成后立即显示出来
 *
 * @author Thomson Tang
 * @version Created: 30/08/2017.
 */
public class Renderer {
    private final ExecutorService executor;

    public Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    public void renderPage(CharSequence source) {
        List<ImageInfo> info = ImageInfoService.scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executor);
        for (final ImageInfo imageInfo : info) {
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }

        renderText(source);

        try {
            for (int i = 0, j = info.size(); i < j; i++) {
                Future<ImageData> future = completionService.take();
                ImageData imageData = future.get();
                renderImage(imageData);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void renderText(CharSequence source) {
    }

    private void renderImage(ImageData imageData) {
    }
}
