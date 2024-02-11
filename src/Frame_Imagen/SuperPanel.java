
package Frame_Imagen;

import java.awt.*;
import javax.swing.*;
public class SuperPanel extends javax.swing.JPanel {

    
    public SuperPanel() {
        initComponents();
        //Con esto editamos el tamaño del jpanel //donde tendremos la imagen del tablero
            this.setSize(750,750);
    }
    @Override
    public void paintComponent(Graphics g){
       Dimension tamano=getSize();
       ImageIcon fondo=new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Tablero.jpg")).getImage());
    g.drawImage(fondo.getImage(),0,0,tamano.width,tamano.height,null);
    //evitamos que se  redibuje el fondo predeterminado
    setOpaque(false);
    super.paintComponent(g);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
