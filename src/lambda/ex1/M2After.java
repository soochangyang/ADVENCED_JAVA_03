package lambda.ex1;

public class M2After {



    public static void print(int weight, String unit) {

        System.out.println("Weight: " + weight + unit);
    }

    public static void main(String[] args) {
        print(10, "KG");
        print(50, "KG");
        print(200, "G");
        print(40, "G");
    }
    //1부터 n 까지 더하는 로직과 , 배열을 정렬하는 (Array.sort()) 로직을 각각 실행하고, 이 두가지 로직 모두 실행에 걸린 시간을 측정 하고 싶다.
}
