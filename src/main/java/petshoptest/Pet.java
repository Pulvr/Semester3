package petshoptest;

interface Pet {
    default void makeSound() {
        System.out.println("Some generic Pet Sound");
    }
}
