package clases;

import java.awt.List;
import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import pistacarros.frmPista;

/**
 *
 * @author Zhunio
 */
public class Cronometro{

    private JLabel cronometro;
    private long segundos;
    private long minutos;
    private long horas;
    private Thread cronometroThread;
    
    public Cronometro(JLabel cronometro) {
        this.cronometro = cronometro;
        
    }
    
    public void Iniciar() {
        cronometroThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            while (!Thread.currentThread().isInterrupted()) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
                long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) % 60;
                long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) % 60;

                String tiempo = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                SwingUtilities.invokeLater(() -> {
                    // Actualizar el JLabel con el tiempo transcurrido
                    cronometro.setText(tiempo);
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        cronometroThread.start();
    }

    public void detenerCronometro() {
        if (cronometroThread != null) {
            cronometroThread.interrupt();
        }
    }

 
    @Override
    public String toString() {
        return horas + " : " +  minutos + " :" + segundos ;
    }
    
}
