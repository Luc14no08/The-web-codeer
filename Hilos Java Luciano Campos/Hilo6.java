import java.util.concurrent.*;
public class Hilo6 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable tarea1 = () -> {
            System.out.println(Thread.currentThread().getName() + "está iniciando la tarea 1");
        };
        Runnable tarea2 = () -> {
            System.out.println(Thread.currentThread().getName() + "está iniciando la tarea 2");
        };
        Runnable tarea3 = () -> {
            System.out.println(Thread.currentThread().getName() + "está iniciando la tarea 3");
        };
        Runnable tarea4 = () -> {
            System.out.println(Thread.currentThread().getName() + "está iniciando la tarea 4");
        };
        Runnable tarea5 = () -> {
            System.out.println(Thread.currentThread().getName() + "está iniciando la tarea 5");
        };
        executor.execute(tarea1);
        executor.execute(tarea2);
        executor.execute(tarea3);
        executor.execute(tarea4);
        executor.execute(tarea5);
        executor.shutdown();
    }
}