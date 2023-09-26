public interface MyList<E> extends Iterable<E> {

    void add(E data);

    E get(int index);

    void delete(int index);
}
