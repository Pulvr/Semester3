package petshoptest;

import java.util.List;

class Petshop {
    void init() {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Cat> cats = List.of(new Cat(), new Cat());
        List<Pet> pets = List.of(new Dog(), new Cat());

        printSounds(dogs);//subtype list allowed
        printSounds(cats);//subtype list allowed
        printSounds(pets);//interface list allowed
    }

    void printSounds(List<? extends Pet> pets) {
        //List<Pet> wäre NICHT kompilierbar sowie List<?> weil dann in der for schleife ein Object erwartet wäre.
        for (Pet pet : pets) {
            pet.makeSound();
        }
    }
}
