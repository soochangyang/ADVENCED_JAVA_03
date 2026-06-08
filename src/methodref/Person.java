package methodref;

public class Person {
    private String name;

    public Person(){
        this("Unknown");
    }

    public Person(String name){
        this.name = name;
    }

    //Static method (정적메소드)
    public static String greeting(){
        return "Hello";
    }

    //Static method (정적메소드)
    public static String greetingWithName(String name){
        return "Hello " + name;
    }


    public String getName(){
        return name;
    }

    //Instance method
    public String introduce(){
        return "I am " + name;
    }

    //Instance method , parameter
    public String introduceWithNumber(int number){
        return "I am " + name + ", my number is "+number;
    }

}
