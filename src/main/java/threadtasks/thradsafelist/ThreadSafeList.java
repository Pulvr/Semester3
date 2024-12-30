package threadtasks.thradsafelist;

import java.util.AbstractList;
import java.util.List;
import java.util.LinkedList;

class ThreadSafeList<E> extends AbstractList<E> {
    private final List<E> elements = new LinkedList<>();

    @Override
    public boolean add(E element) {
        elements.addLast(element);
        return true;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override public E get(int index) {
        return elements.get(index);
    }

    @Override
    public String toString() {
        return "ThreadSafeList[" + elements + "]";
    }
}
