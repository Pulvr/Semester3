package optionaltesting;

import myexceptions.IsNotANumberException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AverageOptional {

    public static void main(String[] args) {
        System.out.println(calculateAverage(List.of(1,2,3)).orElse(0.0));
    }

    static Optional<Double> calculateAverage(Collection<Integer> numbers){
        if(numbers.isEmpty()){
            return Optional.empty();
        }else{
            double averageSum = numbers.stream().reduce(0, Integer::sum) / (double) numbers.size();
            return Optional.of(averageSum);
        }

    }
}
