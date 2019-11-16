package interface_prototype;


import businessLogic.Engine;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {

    public static String username = ""; //Se declara as� para enviar datos entre interfaces
    String password = "";
    private Engine e;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Bienvenido");
        setLocationRelativeTo(null);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        ImageIcon wallapper_logo = new ImageIcon("src/images/bienvenida.png");
        Icon icono_logo = new ImageIcon(wallapper_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
                jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
        this.repaint();
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

        jLabel_Logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jButton_Nuevo = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 270, 270));
       
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("o");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 379, 210, -1));
        
        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 280, 210, -1));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 320, 210, -1));

        jButton_Acceder.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Acceder.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        //jButton_Acceder.setHorizontalAlignment(javax.swing.JButton.CENTER);
        jButton_Acceder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 355, 150, -1));
        
        jButton_Nuevo.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Nuevo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Nuevo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Nuevo.setText("Crear nuevo usuario");
        //jButton_Acceder.setHorizontalAlignment(javax.swing.JButton.CENTER);
        jButton_Nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 395, 150, -1));

        jLabel_Footer.setText(" Creado por Grupo 7 ®");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>                        

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {                                                
        e = new Engine();
        username = txt_user.getText().trim();
        password = txt_password.getText().trim();
        try{
            if (!username.equals("") && !password.equals("")) {
                if(e.loginI(username, password)){
                    System.out.println(new Engine().getAdminState());
                    if(e.getAdminState()){
                        System.out.println("Se ha ingresado exitosamente Admin");
                        new Administrator().setVisible(true);
                        dispose();
                    }else{
                        System.out.println("Se ha ingresado exitosamente Cliente");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingresa datos correctos. Porfis");
            }
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error en el sistema intenta de nuevo");
        }
    }
     private void jButton_NuevoActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
             new Registry().setVisible(true);
             dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en el sistema intenta de nuevo");
        }
     }                                      

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_Acceder;
     private javax.swing.JButton jButton_Nuevo;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel  jLabel2;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration                   


	  public void init() {
			setLayout(null);	 
                        setBounds(0,0,350,450);
			setVisible(true);
			setResizable(false);
			setLocationRelativeTo(null);
		}

}
