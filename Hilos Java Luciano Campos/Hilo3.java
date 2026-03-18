public class Hilo3 implements Runnable {
    private static int count = 0;
    private synchronized void incrementar(){    
        count++;
    }
    public int getCout(){
        return count;
    }
    private contador contador;
    public void tareaIncremento(contador contador){
        this.contador = contador;
    }
    @Override
    public void run() {
        for (int i = 0; i < 80; i++) {
            contador.incrementar();
        }
    }

    public static void main(String[] args) {
        System.out.println("Imprimiendo..." + count);
    }
}