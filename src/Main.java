
public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> myList = new MyArrayList<>();

        for (int i = 0; i < 20; i++) {
            myList.add(i);
        }
        for (Integer i : myList) {
            System.out.println("i = " + i);
        }
        System.out.println("myList.getSize() = " + myList.size());

        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("aaaa");
        stringStack.push("bbbb");
        stringStack.push("cccc");
        stringStack.push("dddd");
        System.out.println("myStack.pop() = " + stringStack.pop());
        System.out.println("myStack.pop() = " + stringStack.pop());
        System.out.println("myStack.pop() = " + stringStack.pop());

        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
    }
}
