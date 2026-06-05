package lambda.lambda4;

public class RunnableMain {

    static void main(String[] args) {
        //Anonymous
        Runnable runnable1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("Hello Runnable Anonymous");
            }
        };
        runnable1.run();

        //Lambda
        Runnable runnable2 = () -> System.out.println("Hello Runnable Lambda");
        runnable2.run();
    }


}
