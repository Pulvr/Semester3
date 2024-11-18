package refactoring.animalfarm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import refactoring.animalfarm.animals.*;

import static org.junit.jupiter.api.Assertions.*;

class FreelandOrganicHappyAnimalFarmTest {

    private static final double TOLERANCE = 0.0000000001;
 
    private FreelandOrganicHappyAnimalFarm farm;

    @BeforeEach
    void setUp() {
        farm = new FreelandOrganicHappyAnimalFarm();
    }

    @Test
    void addValidAnimal() {
        // Arrange
        boolean added = farm.add(new Elephant());

        // Act
        int numberOfAnimals = farm.numberOfDifferentAnimals();

        // Assert
        assertTrue(added);
        assertEquals(1, numberOfAnimals);
    }

    @Test
    void numberOfDifferentAnimals() {
        // Arrange
        farm.add(new Elephant());
        farm.add(new Elephant());
        farm.add(new Elephant());
        farm.add(new Crocodile());
        farm.add(new Crocodile());
        farm.add(new Kangaroo());

        // Act
        int numberOfAnimals = farm.numberOfDifferentAnimals();

        // Assert
        assertEquals(3, numberOfAnimals);
    }

    @Test
    void requiredSpaceInSquareMeters() {
        // Arrange
        farm.add(new Elephant());
        farm.add(new Crocodile());
        farm.add(new Kangaroo());
        farm.add(new Tortoise());

        // Act
        double requiredSpace = farm.requiredSpaceInSquareMeters();

        // Assert
        assertEquals(1360, requiredSpace);
    }

    @Test
    void requiredSpaceInSquareMetersWhenEmpty() {
        // Act
        double requiredSpace = farm.requiredSpaceInSquareMeters();

        // Assert
        assertEquals(0, requiredSpace, TOLERANCE);
    }


    @Test
    void containsAtLeastOneWaterAnimal() {
        // Arrange
        farm.add(new Elephant());
        farm.add(new Crocodile());
        farm.add(new Kangaroo());

        // Act
        boolean containsWaterAnimals = farm.containsWaterAnimals();

        // Assert
        assertTrue(containsWaterAnimals);
    }

    @Test
    void containsNoWaterAnimal() {
        // Arrange
        farm.add(new Elephant());
        farm.add(new Kangaroo());

        // Act
        boolean containsWaterAnimals = farm.containsWaterAnimals();

        // Assert
        assertFalse(containsWaterAnimals);
    }

    @Test
    void containsAtLeastOneLandAnimals() {
        // Arrange
        farm.add(new Elephant());
        farm.add(new Kangaroo());
        farm.add(new Tortoise());

        // Act
        boolean containsLandAnimals = farm.containsLandAnimals();

        // Assert
        assertTrue(containsLandAnimals);
    }

    @Test
    void containsNoLandAnimals() {
        // Arrange
        farm.add(new Tortoise());

        // Act
        boolean containsLandAnimals = farm.containsLandAnimals();

        // Assert
        assertFalse(containsLandAnimals);
    }

    @Test
    void unknownAnimalsCanBeAdded() {
        // Arrange
        boolean added = farm.add(new UnknownAnimal());

        // Act
        int numberOfAnimals = farm.numberOfDifferentAnimals();

        // Assert
        assertTrue(added);
        assertEquals(1, numberOfAnimals);
    }

    @Test
    void unknownAnimalsRequireDefaultSpace() {
        // Arrange
        boolean added = farm.add(new UnknownAnimal());

        // Act
        double actual = farm.requiredSpaceInSquareMeters();

        // Assert
        assertTrue(added);
        assertEquals(1, actual);
    }

    @Test
    void unknownAnimalsAreNoWaterAnimals() {
        // Arrange
        farm.add(new UnknownAnimal());

        // Act
        boolean containsWaterAnimals = farm.containsWaterAnimals();

        // Assert
        assertFalse(containsWaterAnimals);
    }

    @Test
    void unknownAnimalsAreLandAnimalsByDefault() {
        // Arrange
        farm.add(new UnknownAnimal());

        // Act
        boolean containsLandAnimals = farm.containsLandAnimals();

        // Assert
        assertTrue(containsLandAnimals);
    }

    @Test
    void unknownAnimalsAreNoWaterAnimalsByDefault() {
        // Arrange
        farm.add(new UnknownAnimal());

        // Act
        boolean containsWaterAnimals = farm.containsWaterAnimals();

        // Assert
        assertFalse(containsWaterAnimals);
    }
}