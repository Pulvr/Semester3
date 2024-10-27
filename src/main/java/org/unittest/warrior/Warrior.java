package org.unittest.warrior;

public class Warrior {
    double health;
    Weapon weapon;

    void attack( Warrior otherWarrior) {
        otherWarrior.health -= weapon.attack();
    }

    public double getHealth() {
        return this.health;
    }

    Warrior(double health){
        this.health = health;
    }

}
