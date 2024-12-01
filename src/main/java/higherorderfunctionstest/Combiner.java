package higherorderfunctionstest;

/**
 * Kombiniert zwei werte und gibt sie in einem gewissen Rückgabewert typen aus
 *
 * @param <T> Werte die kombiniert werden sollen
 * @param <U> Rückgabewert
 */
@FunctionalInterface
public interface Combiner<T, U> {
    U combine(T dataToCombine1, T dataToCombine2);
}