package clases;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import pistacarros.frmPista;

/**
 *
 * @author Zhunio
 */
public class Auto extends Thread{
    
    private JLabel vehiculo;
    private int posicion;
    private String tiempo;
    
    
    public Auto(JLabel vehiculo) {
        this.vehiculo = vehiculo;
        this.start();
    }

    @Override
    public void run() {
        setPosicion(0);
        while(true) {
            try {
                sleep((int) (Math.random() * 1000));
                setPosicion(getVehiculo().getLocation().x);
                
                if (getPosicion() < 1235) {
                    getVehiculo().setLocation(getVehiculo().getLocation().x + 40, getVehiculo().getLocation().y);
                    frmPista.pnlPista.repaint();
                } else {
                    break;
                }
            }catch(Exception e) {
                System.out.println("e = " + e);
            }
        }
    }

    /**
     * @return the vehiculo
     */
    public JLabel getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(JLabel vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
}
