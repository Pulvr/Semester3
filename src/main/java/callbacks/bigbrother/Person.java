package callbacks.bigbrother;

public class Person {
    //TODO

    private String name;

    Person(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    void setName(String name) {
        //TODO
    }

    void subscribeNameChanged(NameChangedCallback subscriber) {
        //TODO
    }
}
