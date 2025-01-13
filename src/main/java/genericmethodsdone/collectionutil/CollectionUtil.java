package genericmethodsdone.collectionutil;


import java.util.*;

final class CollectionUtil {

    static void runAll(Iterable<? extends Runnable> runnables) {
        runnables.forEach(Runnable::run);
    }

    /**
     * source und target können gelesen und geschrieben werden
     *
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

    static <T extends Comparable<T>> T findMaxInList(List<T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Liste ist leer");
        }

        //wäre auch gegangen, hätte aber ein Optional zurückgegeben, also anderer ReturnType als T
        //return list.stream().max(Comparator.naturalOrder());

        //Hier auch okay,wäre eine Option mit Stream
        //return list.stream().max(Comparable::compareTo).orElseThrow();
        return Collections.max(list);
    }
}
