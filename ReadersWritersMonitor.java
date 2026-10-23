package dining_with_monitor;


public class ReadersWritersMonitor {

    private static int readerCount = 0;
    private static int sharedData = 0;
    private static boolean writerActive = false;

    static class SharedResource {

        synchronized void startReading(int id)
                throws InterruptedException {

            while (writerActive) {
                wait();
            }

            readerCount++;

            System.out.println(
                "Reader " + id + " starts reading. Data: " + sharedData
            );
        }

        synchronized void finishReading(int id) {

            readerCount--;

            System.out.println("Reader " + id + " finishes reading.");

            if (readerCount == 0) {
                notifyAll();
            }
        }

        synchronized void startWriting(int id)
                throws InterruptedException {

            while (writerActive || readerCount > 0) {
                wait();
            }

            writerActive = true;

            System.out.println("Writer " + id + " starts writing.");

            sharedData++;
        }

        synchronized void finishWriting(int id) {

            System.out.println(
                "Writer " + id + " finishes writing. Data: " + sharedData
            );

            writerActive = false;
            notifyAll();
        }
    }

    static class Reader extends Thread {
        private final int id;
        private final SharedResource resource;

        Reader(int id, SharedResource resource) {
            this.id = id;
            this.resource = resource;
        }

        @Override
        public void run() {
            try {
                System.out.println("Reader " + id + " is waiting.");

                resource.startReading(id);
                Thread.sleep(500);
                resource.finishReading(id);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Reader " + id + " was interrupted.");
            }
        }
    }

    static class Writer extends Thread {
        private final int id;
        private final SharedResource resource;

        Writer(int id, SharedResource resource) {
            this.id = id;
            this.resource = resource;
        }

        @Override
        public void run() {
            try {
                System.out.println("Writer " + id + " is waiting.");

                resource.startWriting(id);
                Thread.sleep(700);
                resource.finishWriting(id);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Writer " + id + " was interrupted.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SharedResource resource = new SharedResource();

        Reader r1 = new Reader(1, resource);
        Reader r2 = new Reader(2, resource);
        Reader r3 = new Reader(3, resource);

        Writer w1 = new Writer(1, resource);
        Writer w2 = new Writer(2, resource);

        r1.start();
        r2.start();

        Thread.sleep(100);

        w1.start();
        r3.start();

        Thread.sleep(100);

        w2.start();

        r1.join();
        r2.join();
        r3.join();
        w1.join();
        w2.join();

        System.out.println("\nReaders-Writers execution completed.");
    }
}
