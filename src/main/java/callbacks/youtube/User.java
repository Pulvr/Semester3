package callbacks.youtube;


import java.util.ArrayList;
import java.util.Collection;

class User {
    private final String name;
    private final Collection<Video> videos = new ArrayList<>();
    private final Collection<User> subscribers = new ArrayList<>();

    User(String name) {
        this.name = name;
    }

    void add(Video video) {
        videos.add(video);
        for (User sub : subscribers) {
            sub.notifySubscriberOfNewVideo(this, video);
        }
    }

    void subscribe(User subscriber) {
        subscriber.subscribers.add(this);
    }

    private void notifySubscriberOfNewVideo(User uploader, Video video) {
        System.out.printf("%s has been notified of a new video '%s' by %s%n", name, video, uploader);
    }

    @Override
    public String toString() {
        return name;
    }
}