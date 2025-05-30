// Base class
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound(); // Abstract method

    void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// Dog class (inherits from Animal)
class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

// Cat class (inherits from Animal)
class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// Test class
public class AnimalTest {
    public static void main(String[] args) {
        Animal a1 = new Dog("Rocky");
        Animal a2 = new Cat("Whiskers");

        a1.makeSound();
        a1.sleep();

        a2.makeSound();
        a2.sleep();
    }
}
