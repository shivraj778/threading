package multithreading;

public class FirstExample {
    public static void main(String[] args) {
        Thread thread =  new Thread(()->{
            System.out.println("We are new Thread "+Thread.currentThread().getName());
            System.out.println("Current Thread Priority is "+Thread.currentThread().getPriority());
        });
        thread.setName("worker Thread");
        System.out.println("We are in Thread before Starting new Thread "+Thread.currentThread().getName());
        thread.start();
        System.out.println("We are in Thread after Starting new Thread "+Thread.currentThread().getName());

    }
}
