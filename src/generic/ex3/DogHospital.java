package generic.ex3;

import generic.animal.Dog;

public class DogHospital {
    private Dog animal;

    public void set(Dog animal) {
        this.animal = animal;
    }

    public Dog get() {
        return animal;
    }

    public void checkup(){
        System.out.println("동물이름 : " + animal.getName());
        System.out.println("동물크기 : " + animal.getSize());
        animal.sound();
    }

    public Dog bigger(Dog target){
        return animal.getSize() < target.getSize() ? target : animal;
    }
}
