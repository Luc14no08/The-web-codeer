public class Hilo1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("Hilo 1: " + i);
        }
    }

    public static void main(String[] args) {
        Hilo1 hilo1 = new Hilo1();
        hilo1.start();
    }
}