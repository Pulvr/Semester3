package genericmethodsdone;

import java.util.function.Function;

class SimpleBag<E> {
    private final E element;

    SimpleBag(E value) {
        this.element = value;
    }

    E getElement() {
        return element;
    }

    public static void main(String[] args) {
        SimpleBag<Integer> bag = new SimpleBag<>(42);

        //Returns an Integer<E> of SimpleBag as Integer, which is here
        //autoboxed to int.
        int elementsAsInt = bag.getElement();
        System.out.println(elementsAsInt);

        //R: DOUBLE                      E:Int             R: Double
        double elementAsDouble = bag.map(element -> Double.valueOf(element));
        System.out.println(elementAsDouble);
    }

    <R> R map(Function<E, R> mapper) { //verwendet Functional Interface FUNCTION
        return mapper.apply(element);
    }

}