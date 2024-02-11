
package monopolis;

public class Propiedad {

    private String nombrePro;
    private String propietario;
    private int precio;
    private int renta;
    private int posicion;
    private boolean tarjeta;

    public boolean getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Propiedad() {
        this.nombrePro = nombrePro;
        this.propietario = propietario;
        this.precio = precio;
        this.renta = renta;
        this.posicion = posicion;
        this.tarjeta = tarjeta;
    }

    public Propiedad(String n, String p, int pre, int r, int pos, boolean tar) {
        this.nombrePro = n;
        this.propietario = p;
        this.precio = pre;
        this.renta = r;
        this.posicion = pos;
        this.tarjeta = tar;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

}
