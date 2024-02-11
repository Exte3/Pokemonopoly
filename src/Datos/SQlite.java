
package Datos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SQlite {

    public static Connection con;
    public static void ConexionBD(){
    
        String ruta="jiji.db";
        try{
        
            Class.forName("org.sqlite.JDBC");
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos 1");
        }
        try{
        
            con=DriverManager.getConnection("jdbc:sqlite:"+ruta);
            JOptionPane.showMessageDialog(null,"Base de Datos creada exitosamente");
        }catch(Exception d){
        
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos 2");
        }
        
    }
    
    public static void consultaSinRetorno(){
    
        try{
        
            java.sql.Statement stat= con.createStatement();
            String consulta="create table if not exists Prueba (Nombre varchar(20) primary key, Apellido varchar(20) not null, Rut int not null, Telefono int not null )";
            stat.executeUpdate(consulta);
            stat.close();
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"PROBLEMAS CON LA CONSULTASINRETORNO");
        }
    }
    //consultaConRetorno() te lee los datos de la tabla y te los imprime por pantalla
    public static void consultaConRetorno(){
    
        try{
        
            java.sql.Statement stat=con.createStatement();
            String consulta="select*from Prueba";
            ResultSet rs= stat.executeQuery(consulta);
            while(rs.next()){
            System.out.print(rs.getString("Nombre")+" "+rs.getString("Apellido")+" "+rs.getInt("Rut")+" "+rs.getInt("Telefono")+"\n");
            
            }
            rs.close();
            stat.close();
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"PROBLEMAS CON LA CONSULTACONRETORNO");
        }   
    }
            public static void Agregar(){
            
                try{
                java.sql.Statement stat=con.createStatement();
                ArrayList x=new ArrayList();
                
                String consulta="INSERT INTO Prueba (Nombre , Apellido , Rut , Telefono  ) VALUES ('asfadf',\"illo\",18,221)";//Así se agregan los datos a la tabla
                stat.executeUpdate(consulta);
                stat.close();    
                }catch(Exception k){
                
                    JOptionPane.showMessageDialog(null,"PROBLEMAS AL AGREGAR");
                }
            }
    
   public static void main (String args[]){
   
       ConexionBD();
       consultaSinRetorno();
       Agregar();
       consultaConRetorno();
       //al correr elprogramapor segunda vez te da error al agregar, porque los datos que agregas ya existen. Solo cambias los datos para agregar nuevos
   }
}
