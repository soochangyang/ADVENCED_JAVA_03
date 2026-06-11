package optional.logger;

public class LogMain1 {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.setDebug(true);
        // 연산 순서에 따라 debug함수 인자 10+20을 연산한 후에 debug 메서드를 호출한다.
        logger.debug( 10 + 20);

        System.out.println("=== Debug mode off ===");
        logger.setDebug(false);
        logger.debug( 100 + 200);
    }
}
