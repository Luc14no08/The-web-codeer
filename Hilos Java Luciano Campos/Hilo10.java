import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hilo10 extends JFrame {
    private JButton btnIniciar;
    private JProgressBar progressBar;
    private JLabel lblEstado;

    public Hilo10() {
        setTitle("SwingWorker con Progreso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        
        btnIniciar = new JButton("Iniciar proceso");
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarTarea();
            }
        });
        
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        
        lblEstado = new JLabel("Listo para iniciar");
        
        JPanel norte = new JPanel(new FlowLayout());
        norte.add(btnIniciar);
        
        JPanel centro = new JPanel(new BorderLayout());
        centro.add(lblEstado, BorderLayout.NORTH);
        centro.add(progressBar, BorderLayout.CENTER);
        
        panel.add(norte, BorderLayout.NORTH);
        panel.add(centro, BorderLayout.CENTER);
        add(panel);
    }

    private void iniciarTarea() {
        btnIniciar.setEnabled(false);
        progressBar.setValue(0);
        progressBar.setVisible(true);
        lblEstado.setText("Procesando...");
        
        TareaLarga tarea = new TareaLarga(progressBar, lblEstado, btnIniciar);
        tarea.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Hilo10().setVisible(true);
        });
    }
}

class TareaLarga extends SwingWorker<Void, Integer> {
    private JProgressBar progressBar;
    private JLabel lblEstado;
    private JButton btnIniciar;

    public TareaLarga(JProgressBar progressBar, JLabel lblEstado, JButton btnIniciar) {
        this.progressBar = progressBar;
        this.lblEstado = lblEstado;
        this.btnIniciar = btnIniciar;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int i = 0; i <= 100; i += 10) {
            Thread.sleep(5000);
            publish(i);
        }
        return null;
    }

    @Override
    protected void process(java.util.List<Integer> chunks) {
        int ultimoValor = chunks.get(chunks.size() - 1);
        progressBar.setValue(ultimoValor);
        lblEstado.setText("Progreso: " + ultimoValor + "%");
    }

    @Override
    protected void done() {
        progressBar.setVisible(false);
        lblEstado.setText("¡Proceso completado!");
        btnIniciar.setEnabled(true);
    }
}