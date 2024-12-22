package callbacks.cod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {
    @Test
    void playerEliminationTest(){
        //Arrange
        GameEngine engine = new GameEngine();

        //Assert
        engine.subscribePlayerEliminated( (eliminator,eliminatee)-> {
            assertEquals(1,eliminator.score());
            assertEquals(0,eliminatee.score());
        });

        //Act
        engine.run();

        //weil wegen Callbacks muss die Reihenfolge umgedreht werden. Es gibt keinen direkten return Type.
    }

    @Test
    void correctPlayerOutputTest(){
        GameEngine engine = new GameEngine();

        engine.subscribePlayerEliminated((eliminator, eliminatee) -> {
            assertNotEquals(eliminator.name(), eliminatee.name());
            assertEquals("Player{name='" + eliminator.name() + '\'' + ", score=" + eliminator.score() + '}',eliminator.toString());
        });

        engine.run();
    }
}