package optional.logger;

import java.util.function.Supplier;

public class Logger {

    private boolean isDebug = false;

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        this.isDebug = debug;
    }

    //DEBUG 로 설정한 경우만 출력 - 데이터를 받음
    public void debug(Object message) {
        if (isDebug) {
            System.out.println("[DEBUG] " + message);
        }
    }

    //추가
    // DEBUG로 설정한 경우만 출력 - 람다를 받아서 실행
    public void debug(Supplier<?> supplier){
        if (isDebug) {
            // supplier.get() 이 실행이 될때 파라메터의 연산이 실행된다
            // 그러나 if 문의 먼저 대기 하고 있기때문에 디버그 모드가 꺼져 있을때 람다를 실행하지 않는다.
            System.out.println("[DEBUG] " + supplier.get());
        }
    }
}
