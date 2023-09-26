public class MyQueue<E> {

    private int first = 0;
    private int end = 0;


    private final MyArrayList<E> myLinkedList = new MyArrayList<>();

    public void enqueue(E data) {
        myLinkedList.add(data);
        end++;
    }

    //1번째 방법: 1번째 요소를 삭제 - 성능상 좋지 않을 것 같음
    //2번째 방법: 그냥 포인터를 옮김 - 채택
    public E dequeue() {
        if (first == end) {
            throw new RuntimeException("큐가 비어있습니다");
        }

        return myLinkedList.get(first++);
    }

}
