/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolis;


public class Tarjeta {
    private boolean suerte;
    String Mensaje;
    int dinero;
    public Tarjeta(){
        this.suerte=suerte;
        this.Mensaje=Mensaje;
        this.dinero=dinero;
    }
    public Tarjeta(boolean suerte,String Mensaje, int dinero){
        this.suerte=suerte;
        this.Mensaje=Mensaje;
        this.dinero=dinero;
    }
    

    public boolean getSuerte() {
        return suerte;
    }

    public void setSuerte(boolean suerte) {
        this.suerte = suerte;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    
}
