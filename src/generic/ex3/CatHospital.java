package generic.ex3;

import generic.animal.Cat;

public class CatHospital {
    private Cat animal;

    public void set(Cat animal) {
        this.animal = animal;
    }

    public Cat get() {
        return animal;
    }

    public void checkup(){
        System.out.println("동물이름 : " + animal.getName());
        System.out.println("동물크기 : " + animal.getSize());
        animal.sound();
    }

    public Cat bigger(Cat target){

        return animal.getSize() > target.getSize() ? target : animal;
    }
}
