package multithreading.schedule;

import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
       //try(ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor()) {
         try(var service = Executors.newScheduledThreadPool(cores)) {
            Runnable task1  =  () -> System.out.println("Hello Zoo");
            Callable<String> task2 = () -> "Monkey";
            service.scheduleAtFixedRate(task1,10,5, TimeUnit.SECONDS);
            ScheduledFuture<String> str = service.schedule(task2,8,TimeUnit.SECONDS);
            //hread.sleep(9000);
             System.out.println(str.get());
            while (true) {
                Thread.sleep(10000);
                System.out.println(" 1");
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
