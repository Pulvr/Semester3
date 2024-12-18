package streamstwo;


import java.util.*;
import java.util.stream.Collectors;

public class StreamsTwoTesting {


    static void taskOdd(){
        final List<Integer> reverseList = List.of(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> unevenNumbersList = reverseList.stream()
                .filter(x -> x % 2 != 0)
                .toList();
        System.out.println(unevenNumbersList.reversed());
    }

    static List<Integer> taskDuplicates(){
        final List<Integer> listWithDuplicates = List.of(1, 3, 8, 3, 9, 7, 1, 5, 8, 3, 9, 4, 7, 4, 6, 0, 8, 3, 7);
        List<Integer> listWithoutAnyDuplicates = new ArrayList<>();

        for (int i = 0; i < listWithDuplicates.size();i++){
            for ( int j = i + 1; j < listWithDuplicates.size();j++){
                if(listWithDuplicates.get(i).equals(listWithDuplicates.get(j))){
                    // DISTINCT Returns a stream consisting of the distinct elements (according to Object. equals(Object)) of this stream
                    listWithoutAnyDuplicates = listWithDuplicates.stream().distinct().collect(Collectors.toList());

                    //Hier würde eine Liste in ein Set umgewandelt und DANN returned werden.
                    //Set<Integer> listAsSet = listWithDuplicates.stream().collect(Collectors.toSet());
                    //listWithoutAnyDuplicates = listAsSet.stream().toList();
                    return listWithoutAnyDuplicates;

                }
            }
        }
        System.out.println("Die Liste enthält keine Duplikate");
        return List.of();
    }




    public static void main(String[] args) {
        List<Integer> myList = taskDuplicates();
        System.out.println(myList);
    }

}
