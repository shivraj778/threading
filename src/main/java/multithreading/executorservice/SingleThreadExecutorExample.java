package multithreading.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        //normalThreadExecutionExample();
        usingExcutorServiceExample();
    }

    private static void usingExcutorServiceExample() {
        Runnable printInventory = () -> System.out.println("Printing Zoo Inventory " + Thread.currentThread().getName());
        Runnable printRecords = ()-> {
            for (int i=0;i<3;i++) {
                System.out.println("Printing record: "+i);
            }
        };
        try(ExecutorService service = Executors.newSingleThreadExecutor()) {
            System.out.println("Begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");
        }
    }

    private static void normalThreadExecutionExample() throws InterruptedException {
        Runnable printInventory = () -> System.out.println("Printing Zoo Inventory " + Thread.currentThread().getName());
        Runnable printRecords = ()-> {
          for (int i=0;i<3;i++) {
              System.out.println("Printing record: "+i);
          }
        };
        System.out.println("Begin");
        var platFormThread = Thread.ofPlatform()
                .priority(10)
                .name("Priority-Thread")
                .start(printInventory);
        var virtualThread = Thread.ofVirtual().start(printRecords);
        var constructThread = new Thread(printInventory);
        constructThread.start();

        platFormThread.join();
        virtualThread.join();
        constructThread.join();
        System.out.println("end");

    }
}
