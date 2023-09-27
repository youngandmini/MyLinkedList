
public class MyStack<E> {

    private final MyList<E> myList = new MyLinkedList<>();

    public void push(E data) {

        myList.add(data);
    }

    public E pop() {
        if (myList.size() == 0) {
            throw new RuntimeException("스택이 비어있습니다");
        }

        E returnData = myList.get(myList.size()-1);
        myList.delete(myList.size()-1);

        return returnData;
    }
}
