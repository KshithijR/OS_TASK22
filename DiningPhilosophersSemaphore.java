package diningPhilosophersSemaphore;


import java.util.concurrent.Semaphore;

public class DiningPhilosophersSemaphore {

    private static final int N = 5;

    private static final Semaphore[] forks = new Semaphore[N];

    // Allows at most four philosophers to compete for forks at once.
    private static final Semaphore room = new Semaphore(N - 1);

    static {
        for (int i = 0; i < N; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    static class Philosopher extends Thread {
        private final int id;

        Philosopher(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            int leftFork = id;
            int rightFork = (id + 1) % N;

            try {
                System.out.println("Philosopher " + id + " is thinking.");
                Thread.sleep(500);

                room.acquire();

                forks[leftFork].acquire();
                System.out.println(
                    "Philosopher " + id + " picked up left fork " + leftFork
                );

                forks[rightFork].acquire();
                System.out.println(
                    "Philosopher " + id + " picked up right fork " + rightFork
                );

                System.out.println("Philosopher " + id + " is eating.");
                Thread.sleep(700);

                System.out.println("Philosopher " + id + " finished eating.");

                forks[rightFork].release();
                forks[leftFork].release();
                room.release();

                System.out.println(
                    "Philosopher " + id + " put down both forks."
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(
                    "Philosopher " + id + " was interrupted."
                );
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Philosopher[] philosophers = new Philosopher[N];

        for (int i = 0; i < N; i++) {
            philosophers[i] = new Philosopher(i);
        }

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }

        for (Philosopher philosopher : philosophers) {
            philosopher.join();
        }

        System.out.println(
            "\nDining Philosophers execution completed."
        );
    }
}
