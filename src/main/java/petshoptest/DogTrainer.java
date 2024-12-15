package petshoptest;

import java.util.ArrayList;
import java.util.List;

class DogTrainer {
    void init() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        List<Pet> pets = new ArrayList<>();
        pets.add(new Dog());
        pets.add(new Cat());

        trainDog(dogs); //subtype list allowed
        // trainDog(cats); //DOES NOT COMPILE
        trainDog(pets); //interface list allowed
    }

    //List<Pet> pets wäre NICHT kompilierbar
    void trainDog(List<? super Dog> pets) {
        pets.add(new Dog()); //ONLY DOG is allowed

    }
}