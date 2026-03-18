public class Hilo8 {
    public static final Object recurso1 = new Object();
    public static final Object recurso2 = new Object();
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            synchronized (recurso1) {
                System.out.println();
            }
        });
    }
}
