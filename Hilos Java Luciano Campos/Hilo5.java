public class Hilo5 {
    public static void main(String[] args) {
        class Buffer {
            private int dato;
            private boolean disponible = false;
            public synchronized void producir(int valor) throws InterruptedException {
                while (disponible) {
                    wait();
                }
                dato = valor;
                disponible = true;
                notify();
            }
            public synchronized int consumir() throws InterruptedException {
                while (!disponible) {
                    wait();
                }
                disponible = false;
                notify();
                return dato;
            }
        }
    }
}