package refactoring.animalfarm.animals;

import java.util.Objects;

public abstract class Animal {
    private final int animalId;
    private final String name;
    private final int requiredSpaceInSquareMeter; //könnte auch float sein

    private final boolean isLandAnimal;
    private final boolean isWaterAnimal;

    public Animal(int animalId, String name, int requiredSpaceInSquareMeter, boolean isWaterAnimal, boolean isLandAnimal) {
        this.animalId = animalId;
        this.name = name;
        this.requiredSpaceInSquareMeter = requiredSpaceInSquareMeter;
        this.isWaterAnimal = isWaterAnimal;
        this.isLandAnimal = isLandAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(animalId);
    }

    public String getName() {
        return name;
    }

    public int getRequiredSpaceInSquareMeter() {
        return requiredSpaceInSquareMeter;
    }

    public boolean isLandAnimal() {
        return isLandAnimal;
    }

    public boolean isWaterAnimal() {
        return isWaterAnimal;
    }
}
