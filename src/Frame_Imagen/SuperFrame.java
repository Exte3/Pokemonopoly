
package Frame_Imagen;

import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import monopolis.*;


public class SuperFrame extends javax.swing.JFrame {
    String sum="";
    int a=0, b=1, c=2, d=3, e=4,f=5;
    //Comprar.setVisible(false);
    public void VerPlayers(){
        
        jLabel4.setText("El jugador Actual es: "+Monopolis.jugadores.get(Monopolis.turno).getNombre());
        for(int i=0;i<Monopolis.nPlayers;i++){
    sum=sum+"Jugador: "+Monopolis.jugadores.get(i).getNombre()+" Posición: "+Monopolis.jugadores.get(i).getPosicion()+" Dinero: "+Monopolis.jugadores.get(i).getCoins()+"\n";  
        }
        Info1.setText(sum);  
        if(Monopolis.nPlayers==6){
            Info1.setText("Jugador: "+Monopolis.jugadores.get(a).getNombre()+" Posición: "+Monopolis.jugadores.get(a).getPosicion()+" Dinero: "+Monopolis.jugadores.get(a).getCoins());
            Info2.setText("Jugador: "+Monopolis.jugadores.get(b).getNombre()+" Posición: "+Monopolis.jugadores.get(b).getPosicion()+" Dinero: "+Monopolis.jugadores.get(b).getCoins());
            Info3.setText("Jugador: "+Monopolis.jugadores.get(c).getNombre()+" Posición: "+Monopolis.jugadores.get(c).getPosicion()+" Dinero: "+Monopolis.jugadores.get(c).getCoins());
            Info4.setText("Jugador: "+Monopolis.jugadores.get(d).getNombre()+" Posición: "+Monopolis.jugadores.get(d).getPosicion()+" Dinero: "+Monopolis.jugadores.get(d).getCoins());
            Info5.setText("Jugador: "+Monopolis.jugadores.get(e).getNombre()+" Posición: "+Monopolis.jugadores.get(e).getPosicion()+" Dinero: "+Monopolis.jugadores.get(e).getCoins());
            Info6.setText("Jugador: "+Monopolis.jugadores.get(f).getNombre()+" Posición: "+Monopolis.jugadores.get(f).getPosicion()+" Dinero: "+Monopolis.jugadores.get(f).getCoins());
        }else if(Monopolis.nPlayers==5){
            Info1.setText("Jugador: "+Monopolis.jugadores.get(a).getNombre()+" Posición: "+Monopolis.jugadores.get(a).getPosicion()+" Dinero: "+Monopolis.jugadores.get(a).getCoins());
            Info2.setText("Jugador: "+Monopolis.jugadores.get(b).getNombre()+" Posición: "+Monopolis.jugadores.get(b).getPosicion()+" Dinero: "+Monopolis.jugadores.get(b).getCoins());
            Info3.setText("Jugador: "+Monopolis.jugadores.get(c).getNombre()+" Posición: "+Monopolis.jugadores.get(c).getPosicion()+" Dinero: "+Monopolis.jugadores.get(c).getCoins());
            Info4.setText("Jugador: "+Monopolis.jugadores.get(d).getNombre()+" Posición: "+Monopolis.jugadores.get(d).getPosicion()+" Dinero: "+Monopolis.jugadores.get(d).getCoins());
            Info5.setText("Jugador: "+Monopolis.jugadores.get(e).getNombre()+" Posición: "+Monopolis.jugadores.get(e).getPosicion()+" Dinero: "+Monopolis.jugadores.get(e).getCoins());
         
        }  
        else if(Monopolis.nPlayers==4){
            Info1.setText("Jugador: "+Monopolis.jugadores.get(a).getNombre()+" Posición: "+Monopolis.jugadores.get(a).getPosicion()+" Dinero: "+Monopolis.jugadores.get(a).getCoins());
            Info2.setText("Jugador: "+Monopolis.jugadores.get(b).getNombre()+" Posición: "+Monopolis.jugadores.get(b).getPosicion()+" Dinero: "+Monopolis.jugadores.get(b).getCoins());
            Info3.setText("Jugador: "+Monopolis.jugadores.get(c).getNombre()+" Posición: "+Monopolis.jugadores.get(c).getPosicion()+" Dinero: "+Monopolis.jugadores.get(c).getCoins());
            Info4.setText("Jugador: "+Monopolis.jugadores.get(d).getNombre()+" Posición: "+Monopolis.jugadores.get(d).getPosicion()+" Dinero: "+Monopolis.jugadores.get(d).getCoins());
          }
        else if(Monopolis.nPlayers==3){
            Info1.setText("Jugador: "+Monopolis.jugadores.get(a).getNombre()+" Posición: "+Monopolis.jugadores.get(a).getPosicion()+" Dinero: "+Monopolis.jugadores.get(a).getCoins());
            Info2.setText("Jugador: "+Monopolis.jugadores.get(b).getNombre()+" Posición: "+Monopolis.jugadores.get(b).getPosicion()+" Dinero: "+Monopolis.jugadores.get(b).getCoins());
            Info3.setText("Jugador: "+Monopolis.jugadores.get(c).getNombre()+" Posición: "+Monopolis.jugadores.get(c).getPosicion()+" Dinero: "+Monopolis.jugadores.get(c).getCoins());
           }
        else if(Monopolis.nPlayers==2){
            Info1.setText("Jugador: "+Monopolis.jugadores.get(a).getNombre()+" Posición: "+Monopolis.jugadores.get(a).getPosicion()+" Dinero: "+Monopolis.jugadores.get(a).getCoins());
            Info2.setText("Jugador: "+Monopolis.jugadores.get(b).getNombre()+" Posición: "+Monopolis.jugadores.get(b).getPosicion()+" Dinero: "+Monopolis.jugadores.get(b).getCoins());
          }
    }
    public void MoverLabel(JLabel j){
            JOptionPane.showMessageDialog(null,"Con el mouse en la posición presione enter");
            Point p= MouseInfo.getPointerInfo().getLocation();
           j.setLocation(p);
        }
    public void MagicPower(Jugador j){
     int contador=0;
     int pac=0;
     boolean mov = j.getMov();//obtenemos si se puede mover o no
         int movD1=Monopolis.Dado();
            int movD2=Monopolis.Dado();
            if(mov==true){
           
          
                
                String mov1=""+movD1;
                System.out.println(mov1);
                MovDados1.setText(mov1);//Mostramos el valor del dado1
                
                String mov2=""+movD2;
                MovDados2.setText(mov2);//mostramos el valor del dado2
                int res=movD1+movD2;
                Total.setText(""+res);
               
                int posActual=j.getPosicion();//Modificamos la posición de los jugadores (label) en el juego
                
               // System.out.println("Tamaño array jugadores=n jugadores "+Monopolis.jugadores.size());
                
                if(posActual+res>39){
                    posActual=posActual+res-39;
                    int v=j.getCoins();//obtenemos el dinero actual
                    j.setCoins(v+100);//le sumamos 100 porque pasó por el banco
                    j.setPosicion(posActual);
                    VerPlayers();
                    //modificamos la posicion actual del jugador
                    //Comienza el algoritmo que permite al jugador seleccionar opciones
                    //compra...venta.../Pagar renta/eventos especiales carcel
                    monopolis.Monopolis.EventoCasilla(j);
                    if(movD1==movD2){
                        j.setMov(true);
                    MagicPower(j); 
                    contador++;
                      if(contador==3){
                          j.setMov(false);
                          j.setCondena(3);
                          j.setPosicion(10);}
                         }
                }else{
                     posActual=posActual+res;
                    j.setPosicion(posActual);
                    VerPlayers();
                    monopolis.Monopolis.EventoCasilla(j);
                     if(movD1==movD2){
                    MagicPower(j); 
                    contador++;
                      if(contador==3){
                          j.setMov(false);
                          j.setCondena(3);
                          j.setPosicion(10);}
                         }
                //considerar en qué casilla está situado el jugador
            
             }
         }//fin del if mayor
        else{//lanzar dado 3 veces si salen dobles avanza (salir de la carcel)
            if(movD1==movD2){
                        j.setMov(true);
                        j.setCondena(0);
                        JOptionPane.showMessageDialog(null,"Tus Pokemon estan en perfecto estado");
            }
            else if(j.getCondena()==0){
             j.setMov(true);
             JOptionPane.showMessageDialog(null,"Tus Pokemon estan en perfecto estado");
             String mov1=""+movD1;
                System.out.println(mov1);
                MovDados1.setText(mov1);//Mostramos el valor del dado1
                
                String mov2=""+movD2;
                MovDados2.setText(mov2);//mostramos el valor del dado2
                int res=movD1+movD2;
                Total.setText(""+res);
               
                int posActual=j.getPosicion();//Modificamos la posición de los jugadores (label) en el juego
                
               // System.out.println("Tamaño array jugadores=n jugadores "+Monopolis.jugadores.size());
                
                if(posActual+res>39){
                    posActual=posActual+res-39;
                    int v=j.getCoins();//obtenemos el dinero actual
                    j.setCoins(v+100);//le sumamos 100 porque pasó por el banco
                    j.setPosicion(posActual);
                    VerPlayers();
                    //modificamos la posicion actual del jugador
                    //Comienza el algoritmo que permite al jugador seleccionar opciones
                    //compra...venta.../Pagar renta/eventos especiales carcel
                    monopolis.Monopolis.EventoCasilla(j);
                    if(movD1==movD2){
                        j.setMov(true);
                    MagicPower(j); 
                    contador++;
                      if(contador==3){
                          j.setMov(false);
                          j.setCondena(3);
                          j.setPosicion(10);}
                         }
                }
            }
            else{
                int cos=j.getCondena();
                j.setCondena(cos-1);
            }
        }
    }
    public static void SetterCompra(String s){
       jLabel3.setText(s);
    } 
    public static void visibilidad(boolean a){
        Comprar.setVisible(a);
    
    }
    
    public SuperFrame() {
        initComponents();
        SuperPanel sp=new SuperPanel();
        this.add(sp,BorderLayout.CENTER);//instancia de super panel
        this.pack();
        this.Comprar.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        Dados = new javax.swing.JButton();
        MovDados1 = new javax.swing.JLabel();
        MovDados2 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        J1 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        F1 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        F4 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        F2 = new javax.swing.JLabel();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        F3 = new javax.swing.JLabel();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        F5 = new javax.swing.JLabel();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        F6 = new javax.swing.JLabel();
        Info1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Comprar = new javax.swing.JButton();
        Info2 = new javax.swing.JTextField();
        Info3 = new javax.swing.JTextField();
        Info4 = new javax.swing.JTextField();
        Info5 = new javax.swing.JTextField();
        Info6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        Dados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dados1.jpg"))); // NOI18N
        Dados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DadosActionPerformed(evt);
            }
        });

        MovDados1.setText("D1");

        MovDados2.setText("D2");

        Total.setText("Total");

        jLabel1.setText("+");

        jLabel2.setText("=");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dados)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MovDados1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(MovDados2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dados, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MovDados2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MovDados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Total)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        J1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pokeball2.jpg"))); // NOI18N
        J1.setText("Jugadores");

        jInternalFrame2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jInternalFrame2.setVisible(true);

        F1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P1.png"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addComponent(F1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(F1)
        );

        jInternalFrame3.setVisible(true);

        F4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P4.jpg"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(F4))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(F4)
        );

        jInternalFrame4.setVisible(true);

        F2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P2.jpg"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(F2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(F2)
        );

        jInternalFrame5.setVisible(true);

        F3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P3.png"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addComponent(F3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(F3)
        );

        jInternalFrame6.setVisible(true);

        F5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P5.jpg"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(F5))
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(F5)
        );

        jInternalFrame7.setVisible(true);

        F6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P6.png"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame7Layout = new javax.swing.GroupLayout(jInternalFrame7.getContentPane());
        jInternalFrame7.getContentPane().setLayout(jInternalFrame7Layout);
        jInternalFrame7Layout.setHorizontalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame7Layout.createSequentialGroup()
                .addComponent(F6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame7Layout.setVerticalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(F6)
        );

        Info1.setText("Info1");
        Info1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Info1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Compra Aquí la Propiedad");

        Comprar.setText("Comprar");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });

        Info2.setText("Info2");

        Info3.setText("Info3");

        Info4.setText("Info4");
        Info4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Info4ActionPerformed(evt);
            }
        });

        Info5.setText("Info5");

        Info6.setText("Info6");
        Info6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Info6ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pika.jpg"))); // NOI18N
        jLabel4.setText("Jug actual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(J1)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jInternalFrame5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jInternalFrame6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jInternalFrame7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(Comprar)))
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(396, 396, 396)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Info3)
                            .addComponent(Info2)
                            .addComponent(Info1)
                            .addComponent(Info4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Info5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Info6, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(344, 344, 344))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(J1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Info1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Info2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Info3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Info4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Info5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Info6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Comprar)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jInternalFrame3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jInternalFrame4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jInternalFrame6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jInternalFrame7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DadosActionPerformed
        Jugador j=monopolis.Monopolis.jugadores.get(Monopolis.turno);
         int money=j.getCoins();
         if(money<0){
         //eliminamos al jugador
             if(monopolis.Monopolis.nPlayers==1){
             JOptionPane.showMessageDialog(null,"El juego ha terminado");
             }else{
                 for(int i=0;i<Monopolis.nPlayers;i++){
                     if(Monopolis.jugadores.get(i).getCoins()<0){
                     Monopolis.jugadores.remove(i);
                    String delete= Monopolis.jugadores.get(i).getNombre();
                    for(int z=0;z<40;z++){
                        if(Monopolis.proBanco.get(z).getPropietario().compareTo(delete)==0){
                            Monopolis.proBanco.get(z).setPropietario("Banco");
                        }
                    }
                     }
                 }
             }
         }
         else{
        MagicPower(j);//lanza dado y realiza las operaciones para el jugador actual
        Monopolis.InfoJug();//para ver cómo está el status de los jugadores
         }
    }//GEN-LAST:event_DadosActionPerformed

    private void Info1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Info1ActionPerformed

    }//GEN-LAST:event_Info1ActionPerformed


    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
       
       int actual=Monopolis.turno;
       int money=Monopolis.jugadores.get(actual).getCoins();
       int pos=Monopolis.jugadores.get(actual).getPosicion();
       String name=Monopolis.jugadores.get(actual).getNombre();
             
       int valor=Monopolis.proBanco.get(pos).getPrecio();
       int compra=money-valor;
     
      
       Monopolis.jugadores.get(actual).setCoins(compra);//el jugador compró la propiedad
       Monopolis.proBanco.get(pos).setPropietario(name);
       JOptionPane.showMessageDialog(null,"Propiedad comprada con éxito $(^^)$");
       
    }//GEN-LAST:event_ComprarActionPerformed

    private void Info6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Info6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Info6ActionPerformed

    private void Info4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Info4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Info4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton Comprar;
    private javax.swing.JButton Dados;
    private javax.swing.JLabel F1;
    private javax.swing.JLabel F2;
    private javax.swing.JLabel F3;
    private javax.swing.JLabel F4;
    private javax.swing.JLabel F5;
    private javax.swing.JLabel F6;
    private javax.swing.JTextField Info1;
    private javax.swing.JTextField Info2;
    private javax.swing.JTextField Info3;
    private javax.swing.JTextField Info4;
    private javax.swing.JTextField Info5;
    private javax.swing.JTextField Info6;
    private javax.swing.JLabel J1;
    private javax.swing.JLabel MovDados1;
    private javax.swing.JLabel MovDados2;
    private javax.swing.JLabel Total;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
