package functional;

public class ImmutablePerson {
    private final String name;
    private final int age;


    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Setter를 제공하지 않는다.
    // 새로운 객체가 필요한경우 새로운 객체를 반환
    public ImmutablePerson withAge(int age) {
        return new ImmutablePerson(name, age);
    }


    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
