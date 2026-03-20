public class Hilo8 {
    static final Object recurso1 = new Object();
    static final Object recurso2 = new Object();
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            synchronized (recurso1) {
                System.out.println("Hilo 1: bloqueó el recurso 1");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (recurso2) {
                    System.out.println("Hilo 1: bloqueó el recurso 2");
                }
            }
        });
        Thread hilo2 = new Thread(() -> {
            synchronized (recurso2) {
                System.out.println("Hilo 2: bloqueó el recurso 2");
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (recurso1) {
                    System.out.println("Hilo 2: bloqueó el recurso 1");
                }
            }
        });
        hilo1.start();
        hilo2.start();
        System.out.println("Ha ocurrido un deadlock, favor de esperar mientras se soluciona el problema");
        class solucion {
            Thread hilo1 = new Thread(() ->{
                synchronized (recurso1) {
                    System.out.println("Hilo 1: Adquirió el recurso 1");
                    try { Thread.sleep(100); } catch (Exception e) {}
                    synchronized (recurso2) {
                        System.out.println("Hilo 1: Adquirió el recurso 2");
                    }
                }
            });
            Thread hilo2 = new Thread(() ->{
                synchronized (recurso1) {
                    System.out.println("Hilo 2: Adquirió el recurso 1");
                    try { Thread.sleep(100); } catch (Exception e) {}
                    synchronized (recurso2) {
                        System.out.println("Hilo 2: Adquirió el recurso 2");
                    }
                }
            });
        }
        hilo1.start();
        hilo2.start();
        System.out.println("Deadlock solucionado con éxito");
    }
}