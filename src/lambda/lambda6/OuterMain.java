package lambda.lambda6;

public class OuterMain {
    private String message = "외부 클래스";

    public void execute(){
        //1.익명 클래스
        Runnable anonymous = new Runnable(){

            private String message ="익명 클래스";

            @Override
            public void run(){
                //익명 클래스에서 this는 익명 클래스의 인스턴스를 가리킴
                System.out.println("[anonymous class] this : " + this);
                System.out.println("[anonymous class] this.class : " + this.getClass());
                System.out.println("[anonymous class] this.message : " + this.message);
            }
        };

        //2.lambda expression
        Runnable lambda = () -> {
            String message = "lambda message";
            // 람다에서의 this는 람다가 선언된 클래스의 인스턴스 (즉, 외부 클래스) 가리킴
            System.out.println("[Lambda] this : " + this);
            System.out.println("[Lambda] this.class : " + this.getClass());
            System.out.println("[Lambda] this.message : " + this.message);
            System.out.println("[Lambda] message : " + message);
        };

        anonymous.run();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        lambda.run();
    }

    static void main(String[] args) {
        OuterMain outer = new OuterMain();
        System.out.println("[외부클래스] : " + outer);
        outer.execute();
    }
}
