class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    // Common method
    void eat() {
        System.out.println(name + " is eating.");
    }

    // Default sound
    void sound() {
        System.out.println(name + " makes a sound");
    }
}

class Cat extends Animal {
    String color;

    Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    void sound() {
        System.out.println(name + " meows: Meow!");
    }

    void purr() {
        System.out.println(name + " is purring.");
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    void sound() {
        System.out.println(name + " barks: Woof!");
    }

    void wagTail() {
        System.out.println(name + " is wagging tail.");
    }
}

class Bird extends Animal {
    boolean canFly;

    Bird(String name, boolean canFly) {
        super(name);
        this.canFly = canFly;
    }

    @Override
    void sound() {
        System.out.println(name + " chirps.");
    }

    void fly() {
        if (canFly)
            System.out.println(name + " is flying.");
        else
            System.out.println(name + " cannot fly.");
    }
}

class Eagle extends Bird {

    Eagle(String name) {
        super(name, true);
    }

    @Override
    void sound() {
        System.out.println(name + " is hunting.");
    }
}

class Penguin extends Bird {

    Penguin(String name) {
        super(name, false);
    }

    @Override
    void sound() {
        System.out.println(name + " honks!");
    }

    @Override
    void fly() {
        System.out.println(name + " swims instead of flying.");
    }

    void swim() {
        System.out.println(name + " is swimming.");
    }
}

public class Animalikingdom {

    public static void main(String[] args) {

        Dog dog = new Dog("Buddy", "Labrador");
        Cat cat = new Cat("Whiskers", "Black");
        Eagle eagle = new Eagle("Simba");
        Penguin penguin = new Penguin("Pingu");

        // Dog
        System.out.println("\nDog:");
        dog.sound();
        dog.eat();
        dog.wagTail();

        // Cat
        System.out.println("\nCat:");
        cat.sound();
        cat.eat();
        cat.purr();

        // Eagle
        System.out.println("\nEagle:");
        eagle.sound();
        eagle.eat();
        eagle.fly();

        // Penguin
        System.out.println("\nPenguin:");
        penguin.sound();
        penguin.fly();
        penguin.swim();
    }
}