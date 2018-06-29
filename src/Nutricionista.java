
import java.applet.AudioClip;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Horacio Ramírez
 */
public class Nutricionista extends javax.swing.JFrame {

    private String email;
    private AudioClip sonido;

    public Nutricionista() throws SQLException {
        initComponents();

        this.email = VentanaLogin.jtEmail.getText();

        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();
        Statement consultaFoto = null;

        // =========================
        //   CARGAR FOTO DE PERFIL
        // =========================
        String buscarFoto = "SELECT foto "
                + " FROM usuario_registrado"
                + " WHERE email = '" + this.email + "'";

        consultaFoto = conectar.createStatement();
        ResultSet resultado = consultaFoto.executeQuery(buscarFoto);
        String rutaModificada = "";

        while (resultado.next()) {
            rutaModificada = resultado.getString("foto");
        }

        String ruta = rutaModificada.replace('*', '\\');

        ImageIcon foto = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(fotoPerfil.getWidth(), fotoPerfil.getHeight(), Image.SCALE_DEFAULT));
        this.fotoPerfil.setIcon(foto);

        // Inicia combo box email
        String SQL = "SELECT email"
                + " FROM cliente"
                + " WHERE id_dieta IS null";

        Statement consulta = conexion.getConexion().createStatement();
        ResultSet listado = consulta.executeQuery(SQL);

        if (listado.next()) {
            conectar.close();

            conectar = conexion.conectar();
            consulta = conexion.getConexion().createStatement();
            listado = consulta.executeQuery(SQL);
            while (listado.next()) {
                jcEmail.addItem(listado.getString("email"));
            }
        } else {
            jcEmail.setVisible(false);
            jbAsignar.setVisible(false);
            jlUsuario.setVisible(false);
            jlDieta.setVisible(false);
            jcDieta.setVisible(false);
        }
        conectar.close();

        //Tabla ejercicios vacía
        DefaultTableModel tabla = new DefaultTableModel();
        this.jtablaEjercicios.setModel(tabla);

        //Tabla usuarios vacía
        DefaultTableModel tabla2 = new DefaultTableModel();
        this.jtablaUsuarios.setModel(tabla2);
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlMensaje = new javax.swing.JLabel();
        jFrame = new javax.swing.JPanel();
        fotoPerfil = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jAgregarFoto = new javax.swing.JButton();
        jEliminarCuenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTipoDieta = new javax.swing.JComboBox<>();
        jbBuscarDietas = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaEjercicios = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtPesoMin = new javax.swing.JTextField();
        jtPesoMax = new javax.swing.JTextField();
        jtAlturaMin = new javax.swing.JTextField();
        jtAlturaMax = new javax.swing.JTextField();
        jLimpiar = new javax.swing.JButton();
        jbuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtablaUsuarios = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jcDieta = new javax.swing.JComboBox<>();
        jlUsuario = new javax.swing.JLabel();
        jcEmail = new javax.swing.JComboBox<>();
        jlDieta = new javax.swing.JLabel();
        jbAsignar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlMensaje.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jlMensaje.setForeground(new java.awt.Color(102, 102, 102));

        jFrame.setBackground(new java.awt.Color(204, 204, 204));
        jFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jFrameLayout = new javax.swing.GroupLayout(jFrame);
        jFrame.setLayout(jFrameLayout);
        jFrameLayout.setHorizontalGroup(
            jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jFrameLayout.setVerticalGroup(
            jFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jbSalir.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(204, 0, 51));
        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalirMouseClicked(evt);
            }
        });
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jAgregarFoto.setBackground(new java.awt.Color(255, 255, 255));
        jAgregarFoto.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jAgregarFoto.setForeground(new java.awt.Color(41, 184, 115));
        jAgregarFoto.setText("Agregar foto");
        jAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarFotoActionPerformed(evt);
            }
        });

        jEliminarCuenta.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jEliminarCuenta.setForeground(new java.awt.Color(204, 0, 51));
        jEliminarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-contact.png"))); // NOI18N
        jEliminarCuenta.setText("Eliminar cuenta");
        jEliminarCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEliminarCuentaMouseClicked(evt);
            }
        });
        jEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAgregarFoto)
                    .addComponent(jlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jEliminarCuenta)
                    .addComponent(jbSalir))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEliminarCuenta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jAgregarFoto)))
                .addContainerGap(9, Short.MAX_VALUE))
            .addComponent(jFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setText("BUSCAR DIETAS");

        jTipoDieta.setBackground(new java.awt.Color(41, 184, 115));
        jTipoDieta.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jTipoDieta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hipercalórica", "Hipocalórica" }));
        jTipoDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTipoDietaActionPerformed(evt);
            }
        });

        jbBuscarDietas.setBackground(new java.awt.Color(41, 184, 115));
        jbBuscarDietas.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jbBuscarDietas.setText("Buscar");
        jbBuscarDietas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBuscarDietasMouseClicked(evt);
            }
        });
        jbBuscarDietas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarDietasActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));

        jTipo.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N

        jtablaEjercicios.setFont(new java.awt.Font("Nirmala UI", 0, 11)); // NOI18N
        jtablaEjercicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtablaEjercicios);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(41, 184, 115));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/users-group.png"))); // NOI18N
        jLabel4.setText("USUARIOS");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel5.setText("PESO");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel6.setText("ALTURA");

        jtPesoMin.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtPesoMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesoMinActionPerformed(evt);
            }
        });
        jtPesoMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPesoMinKeyPressed(evt);
            }
        });

        jtPesoMax.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtPesoMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPesoMaxKeyPressed(evt);
            }
        });

        jtAlturaMin.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtAlturaMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtAlturaMinActionPerformed(evt);
            }
        });
        jtAlturaMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtAlturaMinKeyPressed(evt);
            }
        });

        jtAlturaMax.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtAlturaMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtAlturaMaxKeyPressed(evt);
            }
        });

        jLimpiar.setBackground(new java.awt.Color(41, 184, 115));
        jLimpiar.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLimpiar.setText("Borrar");
        jLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLimpiarMouseClicked(evt);
            }
        });
        jLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimpiarActionPerformed(evt);
            }
        });

        jbuscar.setBackground(new java.awt.Color(41, 184, 115));
        jbuscar.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jbuscar.setText("Buscar");
        jbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbuscarMouseClicked(evt);
            }
        });
        jbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLabel7.setText("DESDE");

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLabel8.setText("HASTA");

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLabel9.setText("DESDE");

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jLabel10.setText("HASTA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbuscar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jtAlturaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtAlturaMax))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jtPesoMin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtPesoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(23, 23, 23))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPesoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPesoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtAlturaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtAlturaMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLimpiar)
                    .addComponent(jbuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtablaUsuarios);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jcDieta.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jcDieta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hipercalórica", "Hipocalórica" }));

        jlUsuario.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jlUsuario.setText("USUARIO: ");

        jcEmail.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jcEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEmailActionPerformed(evt);
            }
        });

        jlDieta.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jlDieta.setText("TIPO DE DIETAS: ");

        jbAsignar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jbAsignar.setText("Asignar");
        jbAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAsignarMouseClicked(evt);
            }
        });
        jbAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jlUsuario))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlDieta)
                            .addComponent(jcDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbAsignar)
                .addGap(71, 71, 71))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlDieta)
                .addGap(18, 18, 18)
                .addComponent(jcDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlUsuario)
                .addGap(18, 18, 18)
                .addComponent(jcEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jbAsignar)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(432, 432, 432))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(183, 183, 183))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(693, 693, 693)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jTipoDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarDietas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTipoDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscarDietas)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean comprobarPesoMin() {
        if (!isNumeric(jtPesoMin.getText()) || Float.parseFloat(jtPesoMin.getText()) < 20.0f) {
            return false;
        } else {
            return true;
        }
    }

    private boolean comprobarPesoMax() {
        if ((!isNumeric(jtPesoMax.getText()) || Float.parseFloat(jtPesoMax.getText()) <= 20.0f || Float.parseFloat(jtPesoMax.getText()) > 250.0f)
                || (Float.parseFloat(jtPesoMax.getText()) <= Float.parseFloat(jtPesoMin.getText()))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean comprobarAlturaMin() {
        if (!isNumeric(jtAlturaMin.getText()) || Float.parseFloat(jtAlturaMin.getText()) < 1.0f) {
            return false;
        } else {
            return true;
        }
    }

    private boolean comprobarAlturaMax() {
        if ((!isNumeric(jtAlturaMax.getText()) || Float.parseFloat(jtAlturaMax.getText()) <= 1.0f || Float.parseFloat(jtAlturaMax.getText()) > 2.50f)
                || (Float.parseFloat(jtAlturaMax.getText()) <= Float.parseFloat(jtAlturaMin.getText()))) {
            return false;
        } else {
            return true;
        }
    }

    private void jbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuscarActionPerformed

        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();

        String SQL = "";

        // HEADER DE LA TABLA DE USUARIOS
        DefaultTableModel tablaUsuarios = new DefaultTableModel();
        this.jtablaUsuarios.setModel(tablaUsuarios);

        if ((jtPesoMin.getText().length() != 0 && jtPesoMax.getText().length() != 0)
                && (jtAlturaMin.getText().length() != 0 && jtAlturaMax.getText().length() != 0)) {

            String mensajeError = "";

            // RANGO DE PESOS
            float pesoMin = 0.0f;
            if (comprobarPesoMin()) {
                pesoMin = Float.parseFloat(jtPesoMin.getText());
            } else {
                mensajeError = "Peso mínimo incorrecto";
            }

            float pesoMax = 0.0f;
            if (comprobarPesoMax()) {
                pesoMax = Float.parseFloat(jtPesoMax.getText());
            } else {
                mensajeError += "\n" + "Peso máximo incorrecto";
            }

            // RANGO DE ALTURAS
            float alturaMin = 0.0f;
            if (comprobarAlturaMin()) {
                alturaMin = Float.parseFloat(jtAlturaMin.getText());
            } else {
                mensajeError += "\n" + "Altura mínima incorrecta";
            }
            float alturaMax = 0.0f;
            if (comprobarAlturaMax()) {
                alturaMax = Float.parseFloat(jtAlturaMax.getText());
            } else {
                mensajeError += "\n" + "Altura máxima incorrecta";
            }

            if (!mensajeError.equals("")) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, mensajeError);
            }

            SQL = "SELECT email,sexo,edad,estatura,peso "
                    + " FROM cliente"
                    + " WHERE peso  BETWEEN " + pesoMin + " AND " + pesoMax
                    + " AND estatura BETWEEN " + alturaMin + " AND " + alturaMax;

        } else if (jtPesoMin.getText().length() != 0 && jtPesoMax.getText().length() != 0) {

            String mensajeError = "";

            // RANGO DE PESOS
            float pesoMin = 0.0f;
            if (comprobarPesoMin()) {
                pesoMin = Float.parseFloat(jtPesoMin.getText());
            } else {
                mensajeError = "Peso mínimo incorrecto";
            }

            float pesoMax = 0.0f;
            if (comprobarPesoMax()) {
                pesoMax = Float.parseFloat(jtPesoMax.getText());
            } else {
                mensajeError += "\n" + "Peso máximo incorrecto";
            }

            if (!mensajeError.equals("")) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, mensajeError);
            }

            SQL = "SELECT email,sexo,edad,estatura,peso "
                    + " FROM cliente "
                    + " WHERE peso  BETWEEN " + pesoMin + " AND " + pesoMax;

        } else if (jtAlturaMin.getText().length() != 0 && jtAlturaMax.getText().length() != 0) {
            String mensajeError = "";

            // RANGO DE ALTURAS
            float alturaMin = 0.0f;
            if (comprobarAlturaMin()) {
                alturaMin = Float.parseFloat(jtAlturaMin.getText());
            } else {
                mensajeError += "\n" + "Altura mínima incorrecta";
            }
            float alturaMax = 0.0f;
            if (comprobarAlturaMax()) {
                alturaMax = Float.parseFloat(jtAlturaMax.getText());
            } else {
                mensajeError += "\n" + "Altura máxima incorrecta";
            }

            if (!mensajeError.equals("")) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, mensajeError);
            }

            SQL = "SELECT email,sexo,edad,estatura,peso "
                    + " FROM cliente WHERE estatura  BETWEEN " + alturaMin + " AND " + alturaMax;

        } else {

            SQL = "SELECT email,sexo,edad,estatura,peso "
                    + " FROM cliente";

        }

        try {

            if (!SQL.equals("")) {
                Statement consulta = conexion.getConexion().createStatement();
                ResultSet listado = consulta.executeQuery(SQL);

                // Nombre de los campos
                tablaUsuarios.addColumn("EMAIL");
                tablaUsuarios.addColumn("SEXO");
                tablaUsuarios.addColumn("EDAD");
                tablaUsuarios.addColumn("ALTURA");
                tablaUsuarios.addColumn("PESO");
                tablaUsuarios.addColumn("IMC");

                // recorre los resultados
                while (listado.next()) {
                    String email = listado.getString("email");
                    String sexo = listado.getString("sexo");
                    String edad = listado.getString("edad");
                    String estatura = listado.getString("estatura");
                    String peso = listado.getString("peso");

                    //Calcular IMC
                    float IMC = (float) (Float.parseFloat(peso) / Math.pow(Float.parseFloat(estatura), 2));

                    Usuario usuario = new Usuario(email, sexo, edad, estatura, peso, "" + IMC);

                    String[] fila = {usuario.getEmail(), usuario.getSexo(), usuario.getEdad(), usuario.getAltura(), usuario.getPeso(), usuario.getImc()};
                    tablaUsuarios.addRow(fila);
                }

            } else {
                System.out.println("No se ha podido realizar la consulta");
            }

        } catch (SQLException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbuscarActionPerformed

    private void jtAlturaMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAlturaMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAlturaMinActionPerformed

    private void jtPesoMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesoMinActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jtPesoMinActionPerformed

    private void jbBuscarDietasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDietasActionPerformed

        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();

        // HEADER DE LA TABLA DE DIETAS
        DefaultTableModel tabla = new DefaultTableModel();
        this.jtablaEjercicios.setModel(tabla);

        String tipo = jTipoDieta.getSelectedItem().toString();

        //Header tipo de ejercicios
        jTipo.setText("DIETAS " + tipo.toUpperCase() + "S");

        String SQL = " SELECT nombre_plato,cant_proteinas,cant_carbohidratos,calorias  "
                + " FROM tabla_dieta T1,platos T2 "
                + " WHERE T1.id_dieta = T2.id_dieta AND T1.tipo_dieta = '" + tipo + "'";
        try {
            Statement consulta = conexion.getConexion().createStatement();
            ResultSet listado = consulta.executeQuery(SQL);

            // Nombre de los campos
            tabla.addColumn("PLATO");
            tabla.addColumn("PROTEÍNAS");
            tabla.addColumn("CARBOHIDRATOS");
            tabla.addColumn("CALORÍAS");

            // recorre los resultados y añade al objeto
            while (listado.next()) {
                String nombre = listado.getString("nombre_plato");
                String proteinas = listado.getString("cant_proteinas");
                String carbohidratos = listado.getString("cant_carbohidratos");
                String calorias = listado.getString("calorias");

                Dieta dieta = new Dieta(nombre, proteinas, carbohidratos, calorias);

                String[] fila = {dieta.getNombre(), dieta.getProteinas(), dieta.getCarbohidratos(), dieta.getCalorias()};
                tabla.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbBuscarDietasActionPerformed

    private void jTipoDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTipoDietaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTipoDietaActionPerformed

    private void jbAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAsignarActionPerformed
        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();

        int cantUsuarios = jcEmail.getItemCount();

        if (cantUsuarios > 0) {
            String email = jcEmail.getSelectedItem().toString();
            String dieta = jcDieta.getSelectedItem().toString();

            String IDDieta = "SELECT  id_dieta"
                    + " FROM tabla_dieta"
                    + " WHERE tipo_dieta = '" + dieta + "'";

            try {
                Statement consulta = conexion.getConexion().createStatement();
                ResultSet id = consulta.executeQuery(IDDieta);

                int IDTabla = 0;
                while (id.next()) {
                    IDTabla = Integer.parseInt(id.getString("id_dieta"));
                }
                consulta.close();

                String asignar = " UPDATE cliente SET id_dieta = " + IDTabla + ""
                        + " WHERE email = '" + email + "'";

                try {
                    consulta = conexion.getConexion().createStatement();
                    consulta.executeUpdate(asignar);
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Dieta asignada");
                    jcEmail.removeItem(email);
                } catch (SQLException ex) {
                    System.out.println("No asignado");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Entrenador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Lo sentimos, todos los usuarios tienen dietas asignadas");
            jcEmail.setVisible(false);
            jbAsignar.setVisible(false);
            jlUsuario.setVisible(false);
            jlDieta.setVisible(false);
            jcDieta.setVisible(false);
        }

    }//GEN-LAST:event_jbAsignarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        VentanaLogin ventana = null;
        try {
            ventana = new VentanaLogin();
        } catch (SQLException ex) {
            Logger.getLogger(Entrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventana.setVisible(true);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimpiarActionPerformed
        jtPesoMin.setText("");
        jtPesoMax.setText("");
        jtAlturaMin.setText("");
        jtAlturaMax.setText("");
    }//GEN-LAST:event_jLimpiarActionPerformed

    private void jcEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmailActionPerformed

    }//GEN-LAST:event_jcEmailActionPerformed

    private void jAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarFotoActionPerformed
        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();
        Statement consulta = null;

        JFileChooser fileChooser = new JFileChooser();

        int seleccion = fileChooser.showOpenDialog(jAgregarFoto);
        String ruta = "";
        // Si aceptar la opción
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File foto = fileChooser.getSelectedFile();
            ruta = foto.getAbsolutePath();
        }

        String extension = ruta.substring(ruta.length() - 3).toLowerCase();
        if (extension.equals("jpg") || extension.equals("png")) {

            //Carga la imagen en el Jlabel
            ImageIcon foto = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(fotoPerfil.getWidth(), fotoPerfil.getHeight(), Image.SCALE_DEFAULT));
            this.fotoPerfil.setIcon(foto);

            String rutaModificada = "";
            if (ruta.contains("\\")) {
                rutaModificada = ruta.replace('\\', '*');
            }

            String modificarPerfil = "UPDATE usuario_registrado SET foto = '" + rutaModificada + "'"
                    + " WHERE email = '" + this.email + "'";

            try {
                consulta = conectar.createStatement();
                consulta.executeUpdate(modificarPerfil);
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Imagen de perfil actualizada");
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Formato no soportado. Por favor suba imágenes con extensión jpg o png");
        }
    }//GEN-LAST:event_jAgregarFotoActionPerformed

    private void jEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarCuentaActionPerformed
        getToolkit().beep();
        int opcion = JOptionPane.YES_NO_OPTION;
        opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro/a?", "WARNING", opcion);
        if (opcion == JOptionPane.YES_OPTION) {
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();

            String delete = "DELETE FROM usuario_registrado"
                    + " WHERE email = '" + this.email + "'";

            Statement consulta;
            try {
                consulta = conectar.createStatement();
                consulta.executeUpdate(delete);
                conectar.close();
            } catch (SQLException ex) {
                Logger.getLogger(Nutricionista.class.getName()).log(Level.SEVERE, null, ex);
            }

            VentanaLogin principal;
            try {
                principal = new VentanaLogin();
                principal.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Nutricionista.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.setVisible(false);
        }
    }//GEN-LAST:event_jEliminarCuentaActionPerformed

    private void jbBuscarDietasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscarDietasMouseClicked
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
    }//GEN-LAST:event_jbBuscarDietasMouseClicked

    private void jLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLimpiarMouseClicked
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
    }//GEN-LAST:event_jLimpiarMouseClicked

    private void jbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbuscarMouseClicked
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
    }//GEN-LAST:event_jbuscarMouseClicked

    private void jbAsignarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAsignarMouseClicked
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
    }//GEN-LAST:event_jbAsignarMouseClicked

    private void jbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseClicked
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/analogico_1.wav"));
        sonido.play();
    }//GEN-LAST:event_jbSalirMouseClicked

    private void jEliminarCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEliminarCuentaMouseClicked

    }//GEN-LAST:event_jEliminarCuentaMouseClicked

    private void jtPesoMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesoMinKeyPressed
        if (jtPesoMin.getText().length() >= 7) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cantidad de dígitos superada. "
                    + " Por favor introduce el peso con el siguiente formato" + "\n"
                    + " Ejemplo: 70.200");
        }

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres alfabéticos no permitidos. "
                    + "Por favor, introduzca dígitos");
        }
    }//GEN-LAST:event_jtPesoMinKeyPressed

    private void jtPesoMaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesoMaxKeyPressed
        if (jtPesoMax.getText().length() >= 7) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cantidad de dígitos superada. "
                    + " Por favor introduce el peso con el siguiente formato" + "\n"
                    + " Ejemplo: 70.200");
        }

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres alfabéticos no permitidos. "
                    + "Por favor, introduzca dígitos");
        }
    }//GEN-LAST:event_jtPesoMaxKeyPressed

    private void jtAlturaMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtAlturaMinKeyPressed
        if (jtAlturaMin.getText().length() >= 4) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cantidad de dígitos superada. "
                    + " Por favor introduce la altura con el siguiente formato" + "\n"
                    + " Ejemplo: 1.78");

        }

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres alfabéticos no permitidos. "
                    + "Por favor, introduzca dígitos");
        }
    }//GEN-LAST:event_jtAlturaMinKeyPressed

    private void jtAlturaMaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtAlturaMaxKeyPressed
        if (jtAlturaMax.getText().length() >= 4) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cantidad de dígitos superada. "
                    + " Por favor introduce la altura con el siguiente formato" + "\n"
                    + " Ejemplo: 1.78");

        }

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres alfabéticos no permitidos. "
                    + "Por favor, introduzca dígitos");
        }
    }//GEN-LAST:event_jtAlturaMaxKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Entrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Entrenador().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Entrenador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fotoPerfil;
    private javax.swing.JButton jAgregarFoto;
    private javax.swing.JButton jEliminarCuenta;
    private javax.swing.JPanel jFrame;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jTipo;
    private javax.swing.JComboBox<String> jTipoDieta;
    private javax.swing.JButton jbAsignar;
    private javax.swing.JButton jbBuscarDietas;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbuscar;
    private javax.swing.JComboBox<String> jcDieta;
    private javax.swing.JComboBox<String> jcEmail;
    private javax.swing.JLabel jlDieta;
    public static javax.swing.JLabel jlMensaje;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTextField jtAlturaMax;
    private javax.swing.JTextField jtAlturaMin;
    private javax.swing.JTextField jtPesoMax;
    private javax.swing.JTextField jtPesoMin;
    private javax.swing.JTable jtablaEjercicios;
    private javax.swing.JTable jtablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
