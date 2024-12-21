package callbacks.youtube;

import java.util.ArrayList;
import java.util.Collection;

class User {
    private final String name;
    private final Collection<Video> videos = new ArrayList<>();

    User(String name) {
        this.name = name;
    }

    void add(Video video) {
        videos.add(video);
        // TODO
    }

    private void notifySubscriberOfNewVideo(User uploader, Video video) {
        System.out.printf("%s has been notified of a new video '%s' by %s%n", name, video, uploader);
    }

    void subscribe(User subscriber) {
        //TODO
    }

    @Override
    public String toString() {
    return name;
    }
}