package threadtasks.thradsafelist;

import java.util.List;

class FixThreadSafeList {
    private static final int TEN_TIMES = 10;

    static boolean readWriteList() throws InterruptedException {
        List<Integer> threadSafeList = new ThreadSafeList<>();
        threadSafeList.add(0);
        boolean[] exceptionWasThrown = {false};

        var aThread = new Thread(() -> {
            for (int i = 1; i <= TEN_TIMES; i++) {
                synchronized (threadSafeList){
                    try {
                        threadSafeList.add(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                        exceptionWasThrown[0] = true;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        var bThread = new Thread(() -> {
            for (int i = 1; i <= TEN_TIMES; i++) {
                synchronized (threadSafeList){
                    try {
                        System.out.println(threadSafeList);
                    } catch (Exception e) {
                        e.printStackTrace();
                        exceptionWasThrown[0] = true;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        aThread.start();
        bThread.start();

        aThread.join();
        bThread.join();
        return exceptionWasThrown[0];
    }

    public static void main(String[] args) throws InterruptedException {
        readWriteList();
    }
}