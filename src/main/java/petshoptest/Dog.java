package petshoptest;

class Dog implements Pet {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
