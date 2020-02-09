package interface_prototype;

import businessLogic.Engine;
import data.Admin;
import data.Cliente;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interface_prototype.Registry;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
/**
 *
 * @author John_Riaño
 */
public class usersManager extends javax.swing.JFrame {
    
    String user;
    public static String user_update = "";
    DefaultTableModel model = new DefaultTableModel();
    Engine e = new Engine();
    /**
     * Creates new form GestionarUsuarios
     */
    @SuppressWarnings("unchecked")
    public usersManager() {
        initComponents();        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        user = Login.username;
        
        setSize(630, 330);
        setTitle("Usuarios registrados - Sesión de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
        jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
            
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Username");
            model.addColumn("ID_Pedido");
            model.addColumn("Estado Pedido");
            
            int i = 0; 
            int size = e.getDatabase().getAdminBase().size();
            Object[] f = new Object[size];
            jTable_usuarios = new JTable(model);
            jScrollPane1.setViewportView(jTable_usuarios);
            jTable_usuarios.setBounds(120, 22, 500, 500);
            for ( Cliente a : e.getDatabase().getClientBase()){
                System.out.println(String.valueOf(a.getId())+a.getName()+a.getUsername()+String.valueOf(a.getShoppingCart().getId())+a.getShoppingCart().getStatus());
                String[] at = {String.valueOf(a.getId()),a.getName(),a.getUsername(),String.valueOf(a.getShoppingCart().getId()),a.getShoppingCart().getStatus()}; //,,,String.valueOf(a.getShoppingCart().getId()),};
                f[i] = at;
                model.addRow(at);
                i++;
            }        
    }
     public void cerrar(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e){
                    //hace algo al oprimir cerrar
                    //confirmarCerrar();               
                    new Administrator().setVisible(true);
                    dispose();     
                }
            });
            this.setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/un.gif"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        cerrar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel_footer.setText(" Creado por Grupo 7 ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_usuarios;
    // End of variables declaration                   

}

