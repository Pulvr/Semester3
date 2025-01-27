package higherorderagain.mylist;

import java.util.List;
import java.util.function.Predicate;

class MyList<T> {
    final List<T> myInternalList;

    public MyList(List<T> myInternalList) {
        this.myInternalList = myInternalList;
    }

    public boolean contains(Object object) {
        for (T element : myInternalList) {
            if (object.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Predicate<T> predicate) {
        for (T element : myInternalList) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }


}
