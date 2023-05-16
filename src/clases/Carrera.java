package clases;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pistacarros.Podio;
import pistacarros.frmPista;

/**
 *
 * @author Zhunio
 */
public class Carrera implements Runnable {

   private ArrayList<Auto> puestos = new ArrayList<>();
   private ArrayList<Auto> participantes;
   private frmPista pista;
   private Cronometro cronometro;
   
   public Carrera(ArrayList<Auto> participantes, frmPista pista, Cronometro cronometro) {
       this.participantes = participantes;
       this.pista = pista;
       this.cronometro = cronometro;
   } 
   

    @Override
    public void run() {
        int aux = participantes.size();
        while(true) {      
            
            if (puestos.size() < aux) {
                for (int i = 0; i < participantes.size(); i++) {
                    if (!(participantes.get(i).isAlive())) {
                        puestos.add(participantes.get(i));
                        participantes.remove(i);         
                    }
                }
                            
            } else {
                //      cronometro.detenerCronometro();
                try {
                    sleep(1000);
                    pista.dispose();
                    new Podio(puestos).setVisible(true);
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
        }
        
    }
        
    
   
   
}
