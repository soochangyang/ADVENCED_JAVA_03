package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {
    public WildcardMain1() {
    }

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);
        System.out.println("*******************");

        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);
        System.out.println("*******************");

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
        Animal animal1 = WildcardEx.printAndReturnWildcard(dogBox);

        catBox.set(new Cat("양양이", 180));
        Animal animal2 = WildcardEx.printAndReturnWildcard(catBox);
    }
}
