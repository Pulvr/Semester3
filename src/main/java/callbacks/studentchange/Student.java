package callbacks.studentchange;

import java.util.ArrayList;
import java.util.Collection;

class Student {
    private int id;
    private String name;
    private final Collection<OnStudentCallbackComplete> callbacks = new ArrayList<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id() {
        return id;
    }

    void setId(int id) {
        this.id = id;
        publishOnComplete(this);
    }

    String name() {
        return name;
    }

    void setName(String name) {
        this.name = name;
        publishOnComplete(this);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' + '}';
    }


    void subscribeOnModified(OnStudentCallbackComplete callback) {
        callbacks.add(callback);
    }

    void publishOnComplete(Student student) {
        callbacks.forEach(callback -> callback.studentChanged(student));
    }
}