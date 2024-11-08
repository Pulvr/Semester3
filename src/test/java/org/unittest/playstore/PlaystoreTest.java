package org.unittest.playstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaystoreTest {

    private static class PlayStoreDatabaseMock implements PlaystoreDatabase{

        @Override
        public List<PlaystoreGame> findGamesByName(String name) throws IOException {
            var games = new ArrayList<>(List.of(
               new PlaystoreGame("Game1",3),
               new PlaystoreGame("Game2",5),
               new PlaystoreGame("Game3",6)
            ));
            return games.stream()
                    .filter(game -> game.name().toLowerCase().contains(name.toLowerCase()))
                    .toList();
        }
    }

    private Playstore playstore;

    @BeforeEach
    void beforeAll(){
        playstore = new Playstore(new PlayStoreDatabaseMock());
    }

    @Test
    void noGameFound(){
        var emptyList = List.of();
        var actual = playstore.searchGame("No Game");

        assertEquals(emptyList,actual);
        assertThat(playstore.searchGame("No Game")).isEmpty();
    }

    @Test
    void searchGameTest() {
        var expected = new ArrayList<>(List.of(
                new PlaystoreGame("Game1",3)
        ));
        Collection<PlaystoreGame> result =   playstore.searchGame("Game1");
        assertEquals(expected,result);
    }

    @Test
    void findGamesThrowsIOException(){
        var database = new PlaystoreDatabase(){
            @Override
            public List<PlaystoreGame> findGamesByName(String name) throws IOException{
                throw new IOException("No games found");
            }
        };

        playstore = new Playstore(database);
        var expected = List.of();
        var actual = playstore.searchGame("anything");

        assertEquals(expected,actual);
        assertThat(playstore.searchGame("anything")).isEmpty();
    }


    @Test
    void findNullThrowsException(){
        assertThrows(NullPointerException.class,()->playstore.searchGame(null));
    }
}