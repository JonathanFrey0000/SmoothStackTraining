package Week_1.Week1_day4;

/**
 * @author  Jonathan Frey
 * Producer Consumer example
 */
public class producerConsumerExample {

    public static class PC {

        int[] buffer = new int[1];

        public void produce() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    while (buffer[0] == 1) wait();

                    System.out.println("Produced value " + 1);
                    buffer[0] = 1;
                    notify();

                    Thread.sleep(1000);
                }
            }
        }
        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    while (buffer[0] == 0) wait();

                    System.out.println("Consumed value " + 1);
                    buffer[0] = 0;
                    notify();

                    Thread.sleep(1000);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        final PC pc = new PC();

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }


}