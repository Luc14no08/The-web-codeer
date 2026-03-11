public class Hilo3 implements Runnable {
    @Override
    public void run() {
        System.out.println("1 2 3 4 5");
        System.out.println("A B C D E");
    }

    public static void main(String[] args) {
        Hilo3 hilo3 = new Hilo3();
        Thread thread1 = new Thread(hilo3);
        Thread thread2 = new Thread(hilo3);
        thread1.start();
        thread2.start();
    }
}
