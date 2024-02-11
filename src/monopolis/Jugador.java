
package monopolis;


public class Jugador {
    private String nombre;
    private int coins=1500;
    private int posicion; 
    private boolean play;//si está jugando
    private boolean mov;//si se puede mover
    private int condena;//contador de la carcel
    
    public Jugador(){
        this.nombre=nombre;
        this.coins=coins;
        this.posicion=posicion;
        this.play=play;
        this.mov=mov;
        this.condena=condena;
    }
    public Jugador(String nombre,int coins,int pos,boolean play,boolean mov,int con){
        this.nombre=nombre;
        this.coins=coins;
        this.posicion=pos;
        this.play=play;
        this.mov=mov;
        this.condena=con;
    }

    public int getCondena() {
        return condena;
    }

    public void setCondena(int condena) {
        this.condena = condena;
    }
    
    public boolean getMov() {
        return mov;
    }

    public void setMov(boolean mov) {
        this.mov = mov;
    }
    
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public boolean getPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    
}
