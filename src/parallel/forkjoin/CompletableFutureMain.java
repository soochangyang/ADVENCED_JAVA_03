package parallel.forkjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class CompletableFutureMain {
    static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()-> log("Fork/Join"));  // Fork/Join 공용 풀

        ExecutorService es = Executors.newFixedThreadPool(100);
        CompletableFuture.runAsync(()->log("Customer Pool"), es); //별도의 풀
        Thread.sleep(100);
        es.close();
    }
}
