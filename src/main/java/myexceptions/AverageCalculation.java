package myexceptions;

import java.util.Collection;
import java.util.List;

public class AverageCalculation {

    public static void main(String[] args) {
        printAverage(List.of(6, 6, 6, 5));
        printAverage(List.of());
    }

    static double calculateAverage(Collection<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();
    }

    static void printAverage(Collection<Integer> numbers) {
        try{
            System.out.println(calculateAverage(numbers));
        }catch (IllegalArgumentException e){
            System.out.println("Liste ist leer, IllegalArgument");
        }
    }
}
