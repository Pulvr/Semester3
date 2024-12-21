package callbacks.youtube;

class Youtube {

    public static void main(String[] args) {
        var chris = new User("Chris");
        var anna = new User("Anna");
        var linus = new User("Linus");
        var sara = new User("Sara");

        chris.subscribe(anna);
        linus.subscribe(anna);
        chris.subscribe(linus);
        linus.subscribe(chris);
        sara.subscribe(chris);

        chris.add(new Video("I dont wanna do this anymore"));
        linus.add(new Video("Uni ist zu hart für dich"));
        anna.add((new Video("Zockung 2024")));

        //Goaloutput
        /* Sara has been notified of a new video 'I dont wanna do this anymore' by Chris
        Linus has been notified of a new video 'I dont wanna do this anymore' by Chris
        Chris has been notified of a new video 'Uni ist zu hart für dich' by Linus
        Chris has been notified of a new video 'Zockung 2024' by Anna
        Linus has been notified of a new video 'Zockung 2024' by Anna */
    }

}
