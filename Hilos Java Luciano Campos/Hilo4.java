public class Hilo4 extends Thread{
    @Override
    public void run() {
        for (int i = 50; i > -1; i--) {
            System.out.println("Saldo restante: " + i);
        }
    }
    public static void main(String[] args) {
        Hilo4 hilo4 = new Hilo4();
        Hilo4 hilo4_2 = new Hilo4();
        Hilo4 hilo4_3 = new Hilo4();
        Hilo4 hilo4_4 = new Hilo4();
        Hilo4 hilo4_5 = new Hilo4();
        hilo4.start();
        hilo4_2.start();
        hilo4_3.start();
        hilo4_4.start();
        hilo4_5.start();
    }
}
