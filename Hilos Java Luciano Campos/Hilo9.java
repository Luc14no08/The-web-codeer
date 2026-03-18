public class Hilo9 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            System.out.println("Estado actual de la descarga " + i + "%");
        }
    }
    public static void main(String[] args) {
        Hilo9 hilo9 = new Hilo9();
        Hilo9 hilo9_2 = new Hilo9();
        Hilo9 hilo9_3 = new Hilo9();
        hilo9.start();
        hilo9_2.start();
        hilo9_3.start();
    }
}