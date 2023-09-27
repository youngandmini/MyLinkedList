import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {

    private int max_size = 10;
    private int nextIndex = 0;
    private E[] listArray;


    /**
     * 생성자
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.listArray = (E[]) new Object[max_size];
    }

    /**
     * 리스트에 현재 들어있는 요소의 개수를 반환
     * @return size of List
     */
    @Override
    public int size() {
        return nextIndex;
    }

    /**
     * 기존 배열의 크기의 두배로 늘린 새로운 배열을 만들고 값 복사
     */
    @SuppressWarnings("unchecked")
    private void doubleArray() {
        max_size *= 2;
        E[] newListArray = (E[]) new Object[max_size];
        System.arraycopy(listArray, 0, newListArray, 0, nextIndex);
        this.listArray = newListArray;
    }

    /**
     * 새로운 데이터를 리스트의 맨 뒤에 삽입
     * @param data: 추가할 데이터
     */
    @Override
    public void add(E data) {
        listArray[nextIndex] = data;
        nextIndex++;

        //삽입 후에 배열이 절반 이상 차게 된다면 배열의 사이즈를 두배로 늘림
        if (nextIndex > max_size / 2) {
            doubleArray();
        }
    }

    /**
     * 해당 인덱스에 있는 데이터를 가져옴
     * @param index: 찾고 싶은 데이터의 index
     * @return data
     */
    @Override
    public E get(int index) {
        if (index >= nextIndex) {
            throw new ArrayIndexOutOfBoundsException("리스트의 범위를 벗어났습니다.");
        }
        return this.listArray[index];
    }

    /**
     * 해당 인덱스에 있는 데이터를 삭제
     * @param index: 삭제하고 싶은 데이터의 index
     */
    @Override
    public void delete(int index) {

        if (index >= nextIndex) {
            throw new ArrayIndexOutOfBoundsException("리스트의 범위를 벗어났습니다.");
        }
        nextIndex--;
        for (int i = index; i < nextIndex; i++) {
            this.listArray[i] = this.listArray[i+1];
        }
    }

    /**
     * 이터레이터를 반환
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator() {

        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<E> {
        private int nowIndex = 0;

        @Override
        public boolean hasNext() {
            return nowIndex < nextIndex;
        }

        @Override
        public E next() {
            return listArray[nowIndex++];
        }
    }
}
