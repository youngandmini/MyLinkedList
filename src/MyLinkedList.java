import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {

    private final Node<E> head = new Node<>(null);
    private int nextIndex = 0;


    @Override
    public int size() {
        return nextIndex;
    }

    @Override
    public void add(E data) {
        Node<E> node = head;

        for (int i = 0; i < nextIndex; i++) {
            node = node.nextNode;
        }
        node.nextNode = new Node<>(data);
        nextIndex++;
    }

    @Override
    public E get(int index) {
        if (index >= nextIndex) {
            throw new RuntimeException("리스트의 범위를 벗어났습니다.");
        }
        Node<E> node = head;
        for (int i = 0; i <= index; i++) {
            node = node.nextNode;
        }
        return node.data;
    }

    @Override
    public void delete(int index) {
        if (index >= nextIndex) {
            throw new RuntimeException("리스트의 범위를 벗어났습니다.");
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }
        node.nextNode = node.nextNode.nextNode;
        nextIndex--;
    }

    /**
     * 이터레이터를 반환
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator() {

        return new MyLinkedListIterator();
    }


    private class MyLinkedListIterator implements Iterator<E> {
        private int nowIndex = 0;
        private Node<E> nowNode = head;

        @Override
        public boolean hasNext() {
            return nowIndex < nextIndex;
        }

        @Override
        public E next() {
            nowNode = nowNode.nextNode;
            nowIndex++;
            return nowNode.data;
        }
    }

    private static class Node<E> {
        private E data;
        private Node<E> nextNode;

        public Node(E data) {
            this.data = data;
        }
    }


}
