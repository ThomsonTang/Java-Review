package sharingobject;

import java.util.EventListener;

/**
 * 使用工程方法来防止 {@code this} 引用在构造过程中逸出
 *
 * <p> 如果想在构造函数中注册一个事件监听器或启动线程，那么可以使用一个私有的构造函数和一个公共的工厂方法，从而避免不正确的构造过程。 </p>
 *
 * @author Thomson Tang
 * @version Created: 06/08/2017.
 */
public class SafeListener {
    private final EventListener eventListener;

    private SafeListener() {
        this.eventListener = new EventListener() {
            public void onEvent(Event event) {
                doSomething(event);
            }
        };
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener listener = new SafeListener();
        source.registerListener(listener.eventListener);
        return listener;
    }

    private void doSomething(Event event) {
    }
}

class Event {

}

class EventSource {

    public void registerListener(EventListener eventListener) {
        //此处省略
    }
}
