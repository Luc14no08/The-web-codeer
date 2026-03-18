import java.util.List;
import  javax.swing.SwingWorker;
public class Hilo10 {
    public static void main(String[] args) {
        SwingWorker<String, Integer> worker = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                for (int i = 0; i <= 100; i += 10) {
                    Thread.sleep(5000);
                    publish(i);
                    setProgress(i);
                }
                return "Finalizado";
            }
        
            @Override
            protected void process(List<Integer> chunks) {
                int progreso = chunks.get(chunks.size() - 1);
                labelProgreso.setText("Progreso: " + progreso + "%");
            }
        
            @Override
            protected void done() {
                try {
                    labelProgreso.setText("Estado: " + get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static class labelProgreso {

        private static void setText(String string) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public labelProgreso() {
        }
    }
}
