package threadtasks;

import java.util.ArrayList;
import java.util.List;

public class StringAdderApp {

    static List<String> compute(int limit) throws InterruptedException{
        List<String> sharedList = new ArrayList<>();

        Thread aThread = createThreadWhichAddsCharacterToList(limit, sharedList,"a");
        Thread bThread = createThreadWhichAddsCharacterToList(limit, sharedList,"b");

        aThread.start();
        bThread.start();

        aThread.join(); //wait for aThread to finish
        bThread.join(); //wait for bThread to finish
        return sharedList;
    }

    private static Thread createThreadWhichAddsCharacterToList(int limit, List<String> myList, String character) {
        return Thread.ofVirtual().factory().newThread(() -> {
            for (int i = 0; i < limit; i++) {
                synchronized (myList) { //synchronized um vor raceconditions zu schützen
                    myList.add(character);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
