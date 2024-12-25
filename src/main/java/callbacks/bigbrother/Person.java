package callbacks.bigbrother;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<NameChangedCallback> subscribers = new ArrayList<>();

    private String name;

    Person(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    void setName(String name) {
        subscribers.forEach(subscriber -> subscriber.nameChanged(this.name, name));
        this.name = name;
    }

    void subscribeNameChanged(NameChangedCallback subscriber) {
        subscribers.add(subscriber);
    }
}
