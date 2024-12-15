package genericmethodtesting.collectionutil;

import java.util.Collection;

public class CollectionUtil {

    static <T extends Runnable> void runAll(Iterable<T> runnables) {
        for (Runnable runnable : runnables) {
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /**
     * @param source Quell Collection
     * @param target Ziel Collection
     * @param <E>    mindestens Number oder Unterklasse
     */
    static <E extends Number> void copyNumbers(Collection<E> source, Collection<E> target) {
        for (E number : source) {
            if (number != null) {
                target.add(number);
            }
        }
    }

    /**
     * extends fürs lesen und super fürs schreiben/modifizieren
     *
     * @param source extends : Number und beliebige Unterklassen sind erlaubt
     * @param target super: muss MINDESTENS vom Type Number sein
     */
    static void copyNumbersWildcards(Collection<? extends Number> source, Collection<? super Number> target) {
        for (Number number : source) {
            if (number != null) {
                target.add(number);
            }
        }
    }
}
