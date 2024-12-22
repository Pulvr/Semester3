package callbacks.cod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GameEngine {

    private static final int PLAYERS_TO_CREATE=10;
    private static final Random RANDOM=new Random();

    private final List<Player> players = new ArrayList<>();
    private final Collection<PlayerEliminated> playerEliminatedSubscribers = new ArrayList<>();

    GameEngine(){
        createPlayers();
    }

    private void createPlayers(){
        for (int i = 0; i < PLAYERS_TO_CREATE; i++) {
            String defaultName = "Player" +i;
            players.add(new Player(defaultName));
        }
    }

    void subscribePlayerEliminated(PlayerEliminated subscriber){
        playerEliminatedSubscribers.add(subscriber);
    }

    void notifyPlayerEliminated(Player eliminator,Player eliminatee){
        playerEliminatedSubscribers.forEach(subscriber -> subscriber.playerEliminated(eliminator,eliminatee));
    }

    void run(){
        Player eliminator = getRandomPlayer();
        Player eliminatee = getRandomPlayer();
        if(eliminator != eliminatee){
            eliminator.incrementScore();
        }
        notifyPlayerEliminated(eliminator,eliminatee);
    }

    private Player getRandomPlayer() {
        return players.get(randomPlayerIndex());
    }

    private int randomPlayerIndex() {
        return RANDOM.nextInt(0,players.size());
    }

}
