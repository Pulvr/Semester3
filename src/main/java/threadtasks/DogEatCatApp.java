package threadtasks;

public class DogEatCatApp {

    static Thread threadCreatorWithMessage(String message){
        return Thread.ofVirtual().factory().newThread( ()-> {
            while(true){
                System.out.println(message);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static void main(String[] args)  {

        Thread dog = threadCreatorWithMessage("Dog");
        Thread eat = threadCreatorWithMessage("Eat");
        Thread cat = threadCreatorWithMessage("Cat");

        dog.start();
        eat.start();
        cat.start();
        try {
            cat.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
