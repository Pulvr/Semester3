package algorithms;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {

    public static List<Integer> toSquaredIntegerList(List<Object> objectList){
        List<Integer> result = List.of();

        for( Object object: objectList){

        }

        return result;
    }


    LinkedList<String> fizzBuzzMethod(int start, int end){
        LinkedList<String> list = new LinkedList<>();

        for (int i=start ; i < end; i++){
            if((i % 3 == 0) && ( i % 5 == 0)){
                list.add("FizzBuzz");
            } else if ( i % 3 == 0) {
                list.add("Fizz");
            } else if ( i % 5 == 0) {
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        return  list;
    }
}
