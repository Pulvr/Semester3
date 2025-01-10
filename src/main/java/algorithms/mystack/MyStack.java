package algorithms.mystack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack<T> {
    ArrayList<T> myList;

    MyStack(ArrayList<T> list) {
        this.myList = list;
    }

    public void push(T element) {
        myList.addLast(element);
    }

    public T pop() throws NoSuchElementException {
        if (!myList.isEmpty()) {
            T element = myList.getLast();
            myList.remove(element);
            return element;
        } else {
            throw new IndexOutOfBoundsException("Index is Out of Bounds");
        }
    }

    public boolean isEmpty() {
        return myList.isEmpty();
    }
}
