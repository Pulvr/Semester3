package org.unittest.warrior;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Warrior warrior1;
    Warrior warrior2;

    @BeforeEach
    void setupWarriors(){
        warrior1 = new Warrior(10);
        warrior2 = new Warrior(40);
    }

    @Test
    void attackRocketLauncherTest() {
        warrior1.weapon = new RocketLauncher();
        warrior1.attack(warrior2);
        assertEquals(20,warrior2.getHealth());
    }

    @Test
    void attackLoveTest(){
        warrior2.weapon = new Love();
        warrior2.attack(warrior1);
        assertEquals(0,warrior1.getHealth());
    }

    @Test
    void getHealth() {
        assertEquals(10,warrior1.getHealth());
    }
}