package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {
    public static void main(String[] args) {
        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("야옹이1", 300);

        //개병원
        dogHospital.set(dog);
        dogHospital.checkup();

        //고양이병원
        catHospital.set(cat);
        catHospital.checkup();

        //개 병원에 고양이 전달
        //dogHospital.set(cat); //컴파일 오류가 발생...(매개변수 체크 성공)

        dogHospital.set(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog: " + biggerDog);
    }
}
