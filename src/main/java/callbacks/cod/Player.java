package callbacks.cod;

class Player {
    private final String name;
    private int score;


    Player(String name) {
        this.name = name;
    }

    String name(){
        return name;
    }

    int score(){
        return score;
    }

    void incrementScore(){
        score++;
    }

    @Override
    public String toString(){
        return "Player{name='" + name + '\'' + ", score=" + score + '}';
    }
}
