/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_prototype;

import businessLogic.Engine;
import data.Producto;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author John_Riaño
 */
public class Inventario extends javax.swing.JFrame {
    private ArrayList<JLabel> stock;
    int index;
    /**
     * Creates new form Inventario
     */
    public Inventario() {
        
        initComponents();
       // getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, -1));
        //stock = new ArrayList<>();
        try{
            for(Producto c : new Engine().getDatabase().getInventoryBase()) {
                add(c);
            }
        }catch(Exception e){
            System.out.println(e);
        }   
          
    }
    public void add(Producto c){
        JLabel label = new JLabel("label"+index);
        /* label.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                new viewStock().setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ///hrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

         });
         */
        panel.add(label);
        //stock.add(label);
        try{
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource(c.getUrlImagen())));
        }catch(Exception e){
            System.out.println(e+"img");
        }
        label.setText(c.getNombreProducto()+c.getDescripcion());
        
        index++;
        panel.updateUI();
    }
    private void initComponents() {
        cerrar();
        this.setExtendedState(MAXIMIZED_BOTH);
        setTitle("Catalogo");        
        this.setLocationRelativeTo(null);
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new java.awt.GridLayout(0, 4,15,15));
        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    
    public void cerrar(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e){
                    //hace algo al oprimir cerrar
                    confirmarCerrar();
                }
            });
            this.setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void confirmarCerrar(){
       int v = JOptionPane.showConfirmDialog(null, "Estas seguro?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(v == JOptionPane.YES_OPTION){
           //JOptionPane.showMessageDialog(null, "Adios","",JOptionPane.INFORMATION_MESSAGE);
           new Login().setVisible(true);
           dispose();
       }
    }
    private void initDialog(){         
        dialog = new JDialog(this,"Descripcion");   
        dialog.setSize(500,500);
        //setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));//es como un borde del dialog
        panel.setBounds(0, 0, 200, 200);
        //dialog.setContentPane(panel);
        JLabel des = new JLabel();
        des.setBounds(new Rectangle(50, 50, 0, 0));
        des.setText("dsgsggg");
        //pack();
       // des.setRequestFocusEnabled(false);  
        panel.add(des);      
       // this.getContentPane().add(des, null);
        add(des);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        dialog.setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private JDialog dialog;
    // End of variables declaration//GEN-END:variables

/*    private static class MouseListenerImpl implements MouseListener {

        public MouseListenerImpl() {
        }
    }*/
}