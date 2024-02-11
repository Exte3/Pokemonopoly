
package monopolis;


import Frame_Imagen.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Datos.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Monopolis {
    public static ArrayList<Propiedades> proBanco=new ArrayList();
    public static ArrayList<Jugador> jugadores=new ArrayList();
    public static int turno=0;
    public static int nPlayers;
    public static Tarjeta suerte[]=new Tarjeta[10];//de la posició 0 a la 9
    public static Tarjeta comunidad[]=new Tarjeta[10];
    public static String FILE_NAME="Propiedades.txt";
    public static String FILE_NAME1="Suerte.txt";
    public static String FILE_NAME2="Comunidad.txt";
    public static boolean go=false;//Tenemos las tarjeta el juego
    //-.Funciones.-//
    public static int Dado(){
        int dado1=(int) (Math.random()*6+1);// numeros del 1 al seis
        return dado1;
    }//random de tirar un dado
    public static Tarjeta random(Tarjeta tar[]){
        int random=(int)(Math.random()*9+0);//numeros del 0 al 9 posiciones del arreglo
         return tar[random];
    }
  
    public static  void Lectura() throws IOException{
    try{
           FileReader fr=new FileReader(FILE_NAME);
           BufferedReader br=new BufferedReader(fr);
           String line=br.readLine();
           //lectura de archivo
           while(line!=null){
            String nombre=line;
            String dueno=br.readLine();
            int precio=Integer.parseInt(br.readLine());
            int renta=Integer.parseInt(br.readLine());
            int pos=Integer.parseInt(br.readLine());
            String tar=br.readLine();
            boolean tarj;
            if(tar.compareTo("true")==0){
                tarj = true;}
                else{
                tarj = false;
                }
            proBanco.add(new Propiedades(nombre, dueno, precio,renta,pos,tarj));
           /*System.out.println("nombre "+nombre);
           System.out.println("dueño "+dueno);
           System.out.println("precio "+precio);
           System.out.println("renta "+renta);
           System.out.println("poscicion "+pos);
           System.out.println("tarjeta"+tarj);*/
           line=br.readLine();//leimos de nuevo la información de otra propiedad
               
           } 
          fr.close();
          br.close();
       
       }
       catch(FileNotFoundException fnfe){
           JOptionPane.showMessageDialog(null,"No se encontró archivo"+FILE_NAME);

               }
    }
    public static  void Lectura_Tar(String FILENAME) throws IOException{
    try{
           FileReader fr=new FileReader(FILENAME);
           BufferedReader br=new BufferedReader(fr);
           String line=br.readLine();
           //lectura de archivo
           while(line!=null){
               int contador=0;
               String tar=line;
               boolean tarj;
               String texto=br.readLine();
               int plata=Integer.parseInt(br.readLine());
                if(tar.compareTo("true")==0){
                tarj = true;
                suerte[contador]=new Tarjeta(tarj,texto,plata);
                    }
                else{
                tarj = false;
                comunidad[contador]=new Tarjeta(tarj,texto,plata);
                }  
            
            
            
            
            
           System.out.println("tarjeta "+tar);
           System.out.println("texto "+texto);
           System.out.println("plata "+plata);    
           line=br.readLine();//leimos de nuevo la información de otra propiedad
               
           } 
          fr.close();
          br.close();
       
       }
       catch(FileNotFoundException fnfe){
           JOptionPane.showMessageDialog(null,"No se encontró archivo"+FILE_NAME);

               }
    }
    public static void InfoJug(){
     for(int i=0;i<nPlayers;i++){
      System.out.println(" J "+jugadores.get(i).getNombre()+" Dinero "+jugadores.get(i).getCoins()+"Posicion "+jugadores.get(i).getPosicion()+"Play "+jugadores.get(i).getPlay()+"Condena "+jugadores.get(i).getCondena());
            }
    }
    public static void Go(SuperFrame tablero){
       tablero=new SuperFrame();
       tablero.setVisible(true);
   }//inicializa frame
    public static void EventoCasilla(Jugador j){
        //j.getPro();
        int pos=j.getPosicion();//posición jugador
        String jug=j.getNombre();//nombre jugador
        //Tenemos el nombre de quien le pertenece la Propiedad
        String nombrePro=proBanco.get(pos).getPropietario();
        //pos=0 ya esta definido en magic power (super frame)
        if(pos==30||pos==2||pos==7||pos==17||pos==22||pos==33||pos==36){
            //Suerte
             Frame_Imagen.SuperFrame.visibilidad(false);
            if(pos==2||pos==17||pos==33){
                Tarjeta suer=random(suerte);
                JOptionPane.showMessageDialog(null,suer.getMensaje());
                if(turno<nPlayers){
                 turno++;
                    }else{
                    turno=0;
                 }
                //Crear un método que permita:
                //Se muestre lo que diga la tarjeta y sumar el dinero
            }
            //comunidad cobran plata (pierdes)
            if(pos==7||pos==22||pos==36){
                Tarjeta comu=random(comunidad);
                //Análogo al anterior sólo que debemos restar (dinero)
                JOptionPane.showMessageDialog(null,comu.getMensaje());
                if(turno<nPlayers){
                turno++;
                }else{
                turno=0;
                }
            }
            //Cárcel
            if(pos==30){
                j.setPosicion(10);
                j.setCondena(3);
                j.setMov(false);
                JOptionPane.showMessageDialog(null,"Tus Pokemon han sido debilitados, Espera 3 turnos a que se recuperen o saca un doble");
                if(turno<nPlayers){
                 turno++;
                }else{
                turno=0;
                 }
            }
            
            
            
        }
        else{//para comprar
          
            String name=proBanco.get(pos).getNombrePro();
          int pre=proBanco.get(pos).getPrecio();  
           int renta=proBanco.get(pos).getRenta();
            int money=j.getCoins();
            String asd=proBanco.get(pos).getPropietario();//sabemos a quien le pertenece
        
            if(nombrePro.compareTo("Comprar")==0){
         if(money>pre){
          String s="Desea comprar la propiedad "+name+ " al precio de $"+pre;
          Frame_Imagen.SuperFrame.SetterCompra(s);
          Frame_Imagen.SuperFrame.visibilidad(true);
         }
         else{
          Frame_Imagen.SuperFrame.visibilidad(false);
          }
           if(turno<nPlayers){
               turno++;
           }else{
           turno=0;
           }
        }
          else if(nombrePro.compareTo("Banco")==0){
           String s="La Propiedad es el banco";
           Frame_Imagen.SuperFrame.visibilidad(false);
           Frame_Imagen.SuperFrame.SetterCompra(s);
            if(turno<nPlayers){
               turno++;
           }else{
           turno=0;}
        }
        else if(nombrePro.compareTo(jug)==0){
           String s="La Propiedad es suya";
           Frame_Imagen.SuperFrame.visibilidad(false);
           Frame_Imagen.SuperFrame.SetterCompra(s);
            if(turno<nPlayers){
               turno++;
           }else{
           turno=0;}
        }
        else{//cobrar renta a quien caiga
           
            j.setCoins(money-renta);//cobrar y ahora pagar
            JOptionPane.showMessageDialog(null,"Debe pagar: $"+renta+" al jugador :" +asd);
            
            //ahora buscamos quién es el jugador y luego le llenamos el bolsillo
         
          if(money>pre){
          Frame_Imagen.SuperFrame.visibilidad(true); 
          String s="Desea comprar la propiedad "+name+ " al precio de $"+pre+ " al jugador: " +asd;
         
          
          Frame_Imagen.SuperFrame.SetterCompra(s);
          JOptionPane.showMessageDialog(null,"¿Desea vender su propiedad?");
          
          for(int i=0;i<jugadores.size();i++){
                if(asd.compareTo(jugadores.get(i).getNombre())==0){
                     int asd1=jugadores.get(i).getCoins();
                     jugadores.get(i).setCoins(asd1+renta);
                }
                
            
            }
          
          }
          else{
          Frame_Imagen.SuperFrame.visibilidad(false);
          }
            for(int i=0;i<jugadores.size();i++){
                if(asd.compareTo(jugadores.get(i).getNombre())==0){
                     int asd1=jugadores.get(i).getCoins();
                     jugadores.get(i).setCoins(asd1+renta);
                }
            
            }
            if(turno<nPlayers){
               turno++;
           }else{
           turno=0;
           }
        }
     }//fin else grande
       
    }
   
    public static void main(String[] args) {
        
        Inicio ini=new Inicio();
        ini.setVisible(true);
        while(ini.isVisible()==true){
            Jugador banco=new Jugador("Banco",10000000,0,false,false,0);//tiene todas las propiedades
            
            //Jugador j=
            for(int i=0;i<nPlayers;i++){
                String num="Jugador"+i;
                jugadores.add(new Jugador(num,1500,0,true,true,0));
                }
        }
        //Cambiar los nombres
        go=true;
        SuperFrame tablero=new SuperFrame();
        
        tablero.setVisible(go);
        
        }
        
      
        
        
         
        
        //mofificar nombres...
        
        //sería inciializada la base de datos
        
        //Datos.Conexion.ConsultaConRetorno();
        //conex.ConsultaSinRetorno();
     }
    
    
