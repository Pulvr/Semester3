package recursiontasks;

import java.util.List;

public class SumListGenerics {

    static double sum(List<? extends Number> numbers){
        int size = numbers.size();

        if(numbers.isEmpty()){
            return 0.0;
        }else {
            //es wird das erste Element der Liste genommen und dann die Methode erneut aufgerufen mit einer sublist der Originalliste
            //da es sich um generics handelt, muss explizit der Double-Value geholt werden, da der Compiler sonst von einem Number Object ausgeht.
            return numbers.getFirst().doubleValue() + sum(numbers.subList(1,size));
        }
    }
}
