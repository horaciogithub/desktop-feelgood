
import java.applet.AudioClip;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Horacio Ramírez
 */
public class VentanaAdministrador extends javax.swing.JFrame {

    private String email;

    public VentanaAdministrador() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.email = VentanaLogin.jtEmail.getText();

        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();

        //Mostar usuarios
        String SQL = "SELECT email,nombre,apellidos,fecha_nacimiento,tipo"
                + " FROM usuario_registrado"
                + " WHERE email <>'"+this.email+"'";

        DefaultTableModel tablaUsuarios = new DefaultTableModel();
        this.jTablaUsuarios.setModel(tablaUsuarios);

        // Nombre de los campos
        tablaUsuarios.addColumn("EMAIL");
        tablaUsuarios.addColumn("NOMBRE");
        tablaUsuarios.addColumn("APELLIDOS");
        tablaUsuarios.addColumn("FECHA DE NACIMIENTO");
        tablaUsuarios.addColumn("TIPO USUARIO");

        Statement consulta = conexion.getConexion().createStatement();
        ResultSet listado = consulta.executeQuery(SQL);
        while (listado.next()) {
            String email = listado.getString("email");
            String nombre = listado.getString("nombre");
            String apellidos = listado.getString("apellidos");
            String fechaNacimiento = listado.getString("fecha_nacimiento");
            String tipo = listado.getString("tipo");

            UsuarioGenerico usuario = new UsuarioGenerico(email, nombre, apellidos, fechaNacimiento, tipo);
            String[] fila = {usuario.getEmail(), usuario.getNombre(), usuario.getApellidos(), usuario.getFechaNacimiento(), usuario.getTipo()};
            tablaUsuarios.addRow(fila);

            // Inserta valores al combobox
            jcUsuarios.addItem(listado.getString("email"));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jcUsuarios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaUsuarios = new javax.swing.JTable();
        jbEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(41, 184, 115));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMINISTRAR USUARIOS");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(41, 184, 115));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reply.png"))); // NOI18N
        jButton2.setText("Volver");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jcUsuarios.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N

        jTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaUsuarios.setEditingColumn(1);
        jTablaUsuarios.setEditingRow(1);
        jTablaUsuarios.setEnabled(false);
        jScrollPane1.setViewportView(jTablaUsuarios);

        jbEliminar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-contact.png"))); // NOI18N
        jbEliminar.setText("Eliminar usuario");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jcUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEliminar)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int opcion = JOptionPane.YES_NO_OPTION;
        getToolkit().beep();
        opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro/a?", "WARNING", opcion);

        if (opcion == JOptionPane.YES_OPTION) {
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            Statement consulta = null;

            String emailUsuario = jcUsuarios.getSelectedItem().toString();

            //Elimina este usuario
            String borrar = "DELETE FROM usuario_registrado WHERE email = '" + emailUsuario + "'";

            try {
                consulta = conexion.getConexion().createStatement();
                consulta.executeUpdate(borrar);
                consulta.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Mostar usuarios
            String SQL = "SELECT email,nombre,apellidos,fecha_nacimiento,tipo"
                    + " FROM usuario_registrado"
                    + " WHERE email <>'"+this.email+"'";

            DefaultTableModel tablaUsuarios = new DefaultTableModel();
            this.jTablaUsuarios.setModel(tablaUsuarios);

            // Nombre de los campos
            tablaUsuarios.addColumn("EMAIL");
            tablaUsuarios.addColumn("NOMBRE");
            tablaUsuarios.addColumn("APELLIDOS");
            tablaUsuarios.addColumn("FECHA DE NACIMIENTO");
            tablaUsuarios.addColumn("TIPO USUARIO");

            try {
                consulta = conexion.getConexion().createStatement();
                ResultSet listado = consulta.executeQuery(SQL);

                jcUsuarios.removeAllItems();
                while (listado.next()) {
                    String email = listado.getString("email");
                    String nombre = listado.getString("nombre");
                    String apellidos = listado.getString("apellidos");
                    String fechaNacimiento = listado.getString("fecha_nacimiento");
                    String tipo = listado.getString("tipo");

                    UsuarioGenerico usuario = new UsuarioGenerico(email, nombre, apellidos, fechaNacimiento, tipo);
                    String[] fila = {usuario.getEmail(), usuario.getNombre(), usuario.getApellidos(), usuario.getFechaNacimiento(), usuario.getTipo()};
                    tablaUsuarios.addRow(fila);

                    // Inserta valores al combobox
                    jcUsuarios.addItem(listado.getString("email"));
                }
                consulta.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (opcion == JOptionPane.NO_OPTION) {
            System.out.println("NO");
        }


    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/analogico_1.wav"));
        sonido.play();
    }//GEN-LAST:event_jButton2MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaAdministrador().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaUsuarios;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JComboBox<String> jcUsuarios;
    // End of variables declaration//GEN-END:variables
}
