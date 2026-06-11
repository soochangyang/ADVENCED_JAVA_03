package optional.logger;

public class LogMain3 {
    static void main(String[] args) {
        Logger logger = new Logger();
        logger.setDebug(true);
        // lambda --> lazy evaluation
        logger.debug(() -> value100() + value200());

        System.out.println("=== Debug mode off ===");
        logger.setDebug(false);
        logger.debug(() -> value100() + value200());

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
