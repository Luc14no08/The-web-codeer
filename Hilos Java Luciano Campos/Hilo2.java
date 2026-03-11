public class Hilo2 extends Thread {
    @Override
    public void run() {
        System.out.println("1 2 3 4 5");
        System.out.println("A B C D E");
    }
    
    public static void main(String[] args) {
        Hilo2 hilo2 = new Hilo2();
        Hilo2 hilo2_2 = new Hilo2();
        hilo2.start();
        hilo2_2.start();
    }
}