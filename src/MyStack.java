
public class MyStack<E> {

    private final MyArrayList<E> myLinkedList = new MyArrayList<>();

    public void push(E data) {

        myLinkedList.add(data);
    }

    public E pop() {
        if (myLinkedList.size() == 0) {
            throw new RuntimeException("스택이 비어있습니다");
        }

        E returnData = myLinkedList.get(myLinkedList.size()-1);
        myLinkedList.delete(myLinkedList.size()-1);

        return returnData;
    }
}
