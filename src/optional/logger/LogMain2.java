package optional.logger;

public class LogMain2{
    static void main(String[] args) {
        Logger logger = new Logger();
        logger.setDebug(true);
        // 연산 순서에 따라 debug함수 인자 10+20을 연산한 후에 debug 메서드를 호출한다.
        logger.debug( value100() + value200());

        System.out.println("=== Debug mode off ===");
        logger.setDebug(false);
        logger.debug( value100() + value200());

        // 추가
        System.out.println("=== Debug mode check ===");
        if (logger.isDebug()) {
            logger.debug( value100() + value200());
        }
    }

    static int value100(){
        System.out.println("value100 호출");
        return 100;
    }

    static int value200(){
        System.out.println("value200 호출");
        return 200;
    }
}
