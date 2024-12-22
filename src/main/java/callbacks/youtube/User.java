package callbacks.youtube;


import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

class User {
    private final String name;
    private final Collection<Video> videos = new ArrayList<>();
    private final Collection<User> subscribers = new ArrayList<>();

    User(String name) {
        this.name = name;
    }

    void add(Video video) {
        videos.add(video);
        for (User sub: subscribers){
            sub.notifySubscriberOfNewVideo(this,video);
        }
    }

    void subscribe(User subscriber) {
        subscriber.subscribers.add(this);
    }

    void notifySubs(User uploader, Video video, Consumer<String> callback){
        BiConsumer<User, Video> userVideoBiConsumer = this::notifySubscriberOfNewVideo;
        callback.accept(userVideoBiConsumer.toString());
    }

    private void notifySubscriberOfNewVideo(User uploader, Video video) {
        System.out.printf("%s has been notified of a new video '%s' by %s%n", name, video, uploader);
    }

    @Override
    public String toString() {
        return name;
    }
}