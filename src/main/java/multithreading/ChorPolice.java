package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChorPolice {
    public static final int MAX_PASSWORD = 9999;
    private static int guessPassword = 0;
    public static void main(String[] args) {
        Random random =  new Random();
        guessPassword = random.nextInt(MAX_PASSWORD);
         Vault vault= new Vault(guessPassword);
        List<Thread> list =  new ArrayList<>();
        list.add(new AscendingOrderThread(vault));
        list.add(new DecendingHacker(vault));
        list.add(new Police());
        list.forEach(Thread::start);
    }
    private static class Vault {
        private int password;
        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(3);
            } catch (InterruptedException ignored) {

            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread "+ this.getName());
            super.start();
        }
    }

    private static class AscendingOrderThread extends HackerThread {

        public AscendingOrderThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i=0;i<MAX_PASSWORD;i++) {
                if (vault.isCorrectPassword(i)) {
                    System.out.println(this.getName() + " guessed password " + i);
                    System.exit(0);
                }
            }
        }
    }

    private static class DecendingHacker extends HackerThread {

        public DecendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i= MAX_PASSWORD;i>0;i--) {
                if (vault.isCorrectPassword(i)) {
                    System.out.println(this.getName() + " guessed password " + i);
                    System.exit(0);
                }
            }
        }
    }

    private static class Police extends Thread {
        @Override
        public void run() {
            for (int i=10;i>0;i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println(i);
            }
            System.out.println("Game Over for you hackers");
            System.out.println("password "+guessPassword);
            System.exit(0);
        }
    }
}
