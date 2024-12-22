package callbacks.observerexample;

import java.util.LinkedList;
import java.util.List;

public class Publisher {
    private final List<Subscriber> subscribers = new LinkedList<>();
    private int count = 0;

    void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    void unsubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    void notifySubscribers(){
        subscribers.forEach(subscriber -> subscriber.update(count));
    }

    void mainBusinessLogic(){
        count++;
        notifySubscribers();
    }

    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        Subscriber callback = count -> System.out.println(count);

        publisher.subscribe(callback);
        publisher.mainBusinessLogic();
        publisher.mainBusinessLogic();

        publisher.unsubscribe(callback);
        publisher.mainBusinessLogic();
    }
}
