package datastructure.stackqueue;

public class StackQueue {

    ArrayStack inStack = new ArrayStack();
    ArrayStack outStack = new ArrayStack();

    public void enQueue(Object obj) {
        inStack.push(obj);
    }
    
    public Object deQueue() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.enQueue("first");
        queue.enQueue("second");
        queue.enQueue("third");
        queue.enQueue("fourth");

        System.out.println("1." + queue.deQueue());
        System.out.println("2." + queue.deQueue());
        System.out.println("3." + queue.deQueue());
        System.out.println("4." + queue.deQueue());
    }
}
