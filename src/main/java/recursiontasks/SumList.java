package recursiontasks;

import java.util.List;

public class SumList {

    static double sum(List<Double> numbers){
        int size = numbers.size();

        if(numbers.isEmpty()){
            return 0.0;
        }else {
            //es wird das erste Element der Liste genommen und dann die Methode erneut aufgerufen mit einer sublist der Originalliste
            return numbers.getFirst() + sum(numbers.subList(1,size));
        }
    }

}
