package diningPhilosophersMonitor;


public class DiningPhilosophersMonitor {

    private static final int N = 5;

    static class Table {

        private final boolean[] eating = new boolean[N];

        private boolean canEat(int id) {
            int left = (id + N - 1) % N;
            int right = (id + 1) % N;

            return !eating[left] && !eating[right];
        }

        synchronized void pickUpForks(int id)
                throws InterruptedException {

            while (!canEat(id)) {
                wait();
            }

            eating[id] = true;

            System.out.println(
                "Philosopher " + id + " picked up both forks and is eating."
            );
        }

        synchronized void putDownForks(int id) {

            eating[id] = false;

            System.out.println(
                "Philosopher " + id + " finished eating and put down the forks."
            );

            notifyAll();
        }
    }

    static class Philosopher extends Thread {

        private final int id;
        private final Table table;

        Philosopher(int id, Table table) {
            this.id = id;
            this.table = table;
        }

        @Override
        public void run() {
            try {
                System.out.println(
                    "Philosopher " + id + " is thinking."
                );

                Thread.sleep(500);

                table.pickUpForks(id);

                Thread.sleep(700);

                table.putDownForks(id);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                System.out.println(
                    "Philosopher " + id + " was interrupted."
                );
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Table table = new Table();
        Philosopher[] philosophers = new Philosopher[N];

        for (int i = 0; i < N; i++) {
            philosophers[i] = new Philosopher(i, table);
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
