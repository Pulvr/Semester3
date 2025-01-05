package algorithms.fizzbuzz;

import java.util.LinkedList;

public class FizzBuzz {

    LinkedList<String> fizzBuzzMethod(int start, int end) {
        LinkedList<String> list = new LinkedList<>();

        for (int i = start; i < end; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
