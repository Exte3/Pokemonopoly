
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion{
    Connection con;
    String ruta="/Datos/baseDatos.db";
    public void Conectar (Connection con){
        try{
            Class.forName("org.sqlite.JDBC");
            
        }
        catch(ClassNotFoundException ex){
        JOptionPane.showMessageDialog(null,"No es posible conectar con 'org.sqlite.JDBC'");
        }
        
        try{
            con=DriverManager.getConnection("jdbc: sqlite"+ruta);
            JOptionPane.showMessageDialog(null,"Conectado con la BD");   
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"No es posible conectar con la BD");
        }
    }
    public void ConsultaSinRetorno(){
        try{
            Statement stat=con.createStatement();
            String consulta="create table if not exist "
                    + "Jugadores(id_jugador String primary key,"
                    +"Puntaje int not null, "
                    +"Dinero in not null, "
                    +"fono int not null);";
            stat.executeUpdate(consulta);
            stat.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Problemas con la consulta sin retorno");
        } 
    }
    public void ConsultaConRetorno(){
        try{
            Statement stat=con.createStatement();
            String consulta="select*from persona;";
            ResultSet rs=stat.executeQuery(consulta);//le los datos
            while(rs.next()){
                JOptionPane.showMessageDialog(null,rs.getString("id_persona")+" "+rs.getString("nombre")+" "+rs.getString("fono"));
            }
            rs.close();
            stat.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Problemas con la consulta de retorno");
        }
        //para agregar datos a la base
        //resulset rs=stat.executeUptade()
        //rs.add("insert into jugador y agregar)
       
    }
}
    


