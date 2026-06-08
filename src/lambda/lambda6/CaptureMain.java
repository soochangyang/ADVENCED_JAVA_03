package lambda.lambda6;

public class CaptureMain {

    static void main(String[] args) {
        //명시적 Final
        final int final1 = 10;
        // Effectively final 유사
        int final2 = 20;
        // nomal
        int changedVar = 30;

        //1. Capture in Anonymous Class
        Runnable anonymous = new Runnable() {
            @Override
            public void run(){
                System.out.println("Anonymous class - final1 : " + final1);
                System.out.println("Anonymous class - final2 : " + final2);
                //컴파일 오류
                //System.out.println("Anonymous class - changedVar : " + changedVar);
            }
        };

        //2. Capture in Lambda Expression
        Runnable lambda = () -> {
            System.out.println("lambda - final1 : " +  final1);
            System.out.println("lambda - final2 : " +  final2);
            //컴파일 오류
            //System.out.println("lambda - changedVar : " + changedVar);

        };

        //Variable used in lambda expression should be final or effectively final
        changedVar++;
        anonymous.run();
        lambda.run();
    }
}
