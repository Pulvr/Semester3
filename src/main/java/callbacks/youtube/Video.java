package callbacks.youtube;

public record Video(String title) {

    @Override
    public String toString(){
        return title;
    }
}
