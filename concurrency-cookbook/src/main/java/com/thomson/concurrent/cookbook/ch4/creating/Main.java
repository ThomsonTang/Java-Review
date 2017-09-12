package com.thomson.concurrent.cookbook.ch4.creating;

/**
 * <h2>Creating a thread executor</h2>
 *
 * 需要注意的是使用完{@code ThreadPoolExecutor}一定要记得显式的关闭线程池, 否则程序将不会退出。
 *
 * @author Thomson Tang
 * @version Created: 12/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            ExecTask task = new ExecTask("Task" + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
