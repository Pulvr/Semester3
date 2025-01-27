package higherorderfunctions.higherorderfunctionstest;

@FunctionalInterface
public interface Combiner<T, U> {
    U combine(T element1, T element2);
}
