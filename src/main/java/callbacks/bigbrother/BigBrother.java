package callbacks.bigbrother;

import java.util.LinkedList;
import java.util.List;

class BigBrother {
    private final List<String> log = new LinkedList<>();

    BigBrother add(Person person) {
        person.subscribeNameChanged((oldName, newName) -> {
            log.add(oldName + " changed name to " + newName);
        });
        return this;
    }

    boolean logContains(String line) {
        return log.contains(line);
    }
}
