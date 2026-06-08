package generic.ex3;

public class AnimalHospitalV2<T> {
    private T animal;

    public void set(T animal){

        this.animal = animal;
    }

    public void checkup(){
        animal.toString();

        // T의 타입은 메서드를 정의 하는 시점에는 알 수 없다. Object 기능만 사용
        //System.out.println("동물이름 : " + animal.getName());
        //System.out.println("동물크기 : " + animal.getSize());
        //animal.sound();
    }

    public T bigger(T target){
        return null;
        //return animal.getSize() < target.getSize() ? target : animal;
    }
}
