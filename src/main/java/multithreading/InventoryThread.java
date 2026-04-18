package multithreading;

public class InventoryThread {
    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        IncrementThread incrementThread =  new IncrementThread(inventory);
        DecrementThread decrementThread = new DecrementThread(inventory);

        Thread thread = new Thread(incrementThread);
        Thread thread1 =  new Thread(decrementThread);

        thread.start();

        thread1.start();
        thread.join();
        thread1.join();
        inventory.print();
    }

    static class Inventory {
        private int value = 0;

        public void increment() {
             ++value;
        }

        public void decrement() {
            --value;
        }

        public void print() {
            System.out.println("value "+value);
        }
    }

    static class IncrementThread implements Runnable{
        private final Inventory inventory;
        IncrementThread(Inventory inventory) {
          this.inventory = inventory;
        }


        @Override
        public void run() {
            for (int i=0;i<1000;i++) {
                inventory.increment();
            }
        }
    }
    static class DecrementThread implements Runnable{
        private final Inventory inventory;
        DecrementThread(Inventory inventory) {
            this.inventory = inventory;
        }


        @Override
        public void run() {
            for (int i=0;i<1000;i++) {
                inventory.decrement();
            }
        }
    }
}
