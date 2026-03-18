import java.util.concurrent.*;
public class Hilo7 implements Callable<Integer>{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // Crear Callable que calcula la suma
        Callable<Integer> tareaSuma = () -> {
            int suma = 0;
            for (int i = 1; i <= 100; i++) {
                suma += i;
            }
            System.out.println("Hilo calculador: Suma calculada = " + suma);
            return suma;
        };
        
        try {
            // Enviar tarea y obtener Future
            Future<Integer> futureResultado = executor.submit(tareaSuma);
            
            // Esperar y obtener resultado
            Integer resultado = futureResultado.get();
            System.out.println("Resultado recibido = " + resultado);
            
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'call'");
    }
}