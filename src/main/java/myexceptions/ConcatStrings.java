package myexceptions;

import java.util.Arrays;

public class ConcatStrings {

    public static void main(String[] args) {

        concat(null, "222");
    }

    public static String concat(String str1, String str2) {

        if(str1 == null ||str2 == null){
            throw new NullPointerException();
        }else {
            return str1 + str2;
        }

    }

}
