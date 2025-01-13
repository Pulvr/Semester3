package genericsagain.collectionutil;

import java.util.Collection;

public class CollectionUtil {
    static void runAll(Iterable<? extends Runnable> myRunnables) {
        for (Runnable runnable : myRunnables) {
            runnable.run();
        }
    }

    static <E extends Number> void copyNumberGeneric(Collection<E> source, Collection<E> target) {
        target.addAll(source);
    }

    static void copyNumberWildCards(Collection<? extends Number> source, Collection<? super Number> target) {
        target.addAll(source);
    }
}
