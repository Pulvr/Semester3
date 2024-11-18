package refactoring.animalfarm;

import refactoring.animalfarm.animals.Animal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class FreelandOrganicHappyAnimalFarm {

    private final List<Animal> animals = new ArrayList<>();

    public boolean add(Animal animal) {
        return animals.add(animal);
    }

    public int numberOfDifferentAnimals() {
        return new HashSet<>(animals).size();
    }

    public double requiredSpaceInSquareMeters() {
        int requiredSpace = 0;
        for (Animal animal : animals) {
            requiredSpace += animal.getRequiredSpaceInSquareMeter();
        }
        return requiredSpace;
    }

    public boolean containsWaterAnimals() {
        var containsWaterAnimal = false;
        for (Animal animal : animals) {
            containsWaterAnimal |= animal.isWaterAnimal();
        }
        return containsWaterAnimal;
    }

    public boolean containsLandAnimals() {
        var containsLandAnimal = false;
        for (Animal animal : animals) {
            containsLandAnimal |= animal.isLandAnimal();
        }
        return containsLandAnimal;
    }
}