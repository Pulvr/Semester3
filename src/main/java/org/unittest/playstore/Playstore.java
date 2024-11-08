package org.unittest.playstore;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class Playstore {

    private final PlaystoreDatabase database;

    Playstore(PlaystoreDatabase database) {
        this.database = database;
    }

    Collection<PlaystoreGame> searchGame(String name){
        try{
            return database.findGamesByName(name);
        }catch (IOException e){
            return List.of();
        }
    }
}
