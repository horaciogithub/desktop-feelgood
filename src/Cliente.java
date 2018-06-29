
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Horacio
 */
public class Cliente extends javax.swing.JFrame {

    private String email;

    public Cliente() throws SQLException {
        initComponents();

        this.setLocationRelativeTo(null);//Centrar Ventana

        //Color barra de progreso
        UIManager.put("nimbusOrange", new Color(38, 139, 210));

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

        // ========================
        //   TABLA DE EJERCICIOS
        // ========================
        DefaultTableModel tabla = new DefaultTableModel();
        this.jtablaEjercicios.setModel(tabla);
        // Nombre de los campos
        tabla.addColumn("EJERCICIO");
        tabla.addColumn("SERIES");
        tabla.addColumn("REPETICIONES");
        tabla.addColumn("DESCANSO");

        String SQLEjercicios = "SELECT nombre_ejercicio,n_series,n_repeticiones,t_descanso "
                + " FROM cliente INNER JOIN ejercicio"
                + " ON cliente.id_tabla = ejercicio.id_tabla"
                + " AND cliente.email = '" + this.email + "'";

        Statement consulta = conexion.getConexion().createStatement();
        ResultSet listado = consulta.executeQuery(SQLEjercicios);

        // recorre los resultados y añade al objeto
        while (listado.next()) {
            String nombre = listado.getString("nombre_ejercicio");
            String series = listado.getString("n_series");
            String repeticiones = listado.getString("n_repeticiones");
            String descanso = listado.getString("t_descanso");

            Ejercicio ejercicios = new Ejercicio(nombre, series, repeticiones, descanso);

            String[] fila = {ejercicios.getNombre(), ejercicios.getSeries(), ejercicios.getRepeticiones(), ejercicios.getDescanso()};
            tabla.addRow(fila);
        }

        // ==================
        //   TABLA DE DIETAS
        // ===================
        DefaultTableModel tabla2 = new DefaultTableModel();
        this.jtablaDietas.setModel(tabla2);
        // Nombre de los campos
        tabla2.addColumn("PLATO");
        tabla2.addColumn("PROTEÍNAS");
        tabla2.addColumn("CARBOHIDRATOS");
        tabla2.addColumn("CALORÍAS");

        String SQLDietas = "SELECT nombre_plato,cant_proteinas,cant_carbohidratos,calorias "
                + " FROM cliente INNER JOIN platos"
                + " ON cliente.id_dieta = platos.id_dieta"
                + " AND cliente.email = '" + this.email + "'";

        Statement consulta2 = conexion.getConexion().createStatement();
        ResultSet listado2 = consulta2.executeQuery(SQLDietas);

        // recorre los resultados
        while (listado2.next()) {
            String nombre = listado2.getString("nombre_plato");
            String proteinas = listado2.getString("cant_proteinas");
            String carbohidratos = listado2.getString("cant_carbohidratos");
            String calorias = listado2.getString("calorias");

            Dieta dietas = new Dieta(nombre, proteinas, carbohidratos, calorias);

            String[] fila2 = {dietas.getNombre(), dietas.getProteinas(), dietas.getCarbohidratos(), dietas.getCalorias()};
            tabla2.addRow(fila2);
        }

        // ==================
        //   APARTADO AGUA
        // ==================
        String cantidadBebida = "SELECT n_vasos,hora"
                + " FROM vasos_agua"
                + " WHERE email = '" + this.email
                + "' AND id_agua = (SELECT MAX(id_agua)"
                + " FROM vasos_agua"
                + " WHERE email = '" + this.email + "')";

        String vasos = "";
        try {
            Statement consultaCantidad = conectar.createStatement();
            ResultSet cantidad = consultaCantidad.executeQuery(cantidadBebida);
            while (cantidad.next()) {
                vasos = cantidad.getString("n_vasos");
                jHora.setText(cantidad.getString("hora"));
                // ====================
                //   CANTIDAD DE AGUA
                // ====================
                switch (Integer.parseInt(vasos)) {
                    case 0:
                        jLabel7.setText("Has tomado 0ml");
                        jProgresoAgua.setValue(0);
                        break;
                    case 1:
                        jLabel7.setText("Has tomado 250ml");
                        jProgresoAgua.setValue(12);
                        break;
                    case 2:
                        jLabel7.setText("Has tomado 500ml");
                        jProgresoAgua.setValue(25);
                        break;
                    case 3:
                        jLabel7.setText("Has tomado 750ml");
                        jProgresoAgua.setValue(37);
                        break;
                    case 4:
                        jLabel7.setText("Has tomado 1000ml");
                        jProgresoAgua.setValue(50);
                        break;
                    case 5:
                        jLabel7.setText("Has tomado 1250ml");
                        jProgresoAgua.setValue(62);
                        break;
                    case 6:
                        jLabel7.setText("Has tomado 1500ml");
                        jProgresoAgua.setValue(75);
                        break;
                    case 7:
                        jLabel7.setText("Has tomado 1750ml");
                        jProgresoAgua.setValue(87);
                        break;
                    default:
                        jLabel7.setText("Objetivo cumplido 2Litros");
                        jProgresoAgua.setValue(100);

                }
            }
        } catch (SQLException ex) {
            System.out.println("No se ha seleccionado la cantidad");
        }

        conectar.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFoto = new javax.swing.JPanel();
        fotoPerfil = new javax.swing.JLabel();
        jlMensaje = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jAgregarFoto = new javax.swing.JButton();
        jEliminarCuenta = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaEjercicios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtablaDietas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jAñadirAgua = new javax.swing.JButton();
        jRestarAgua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jProgresoAgua = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jFotoLayout = new javax.swing.GroupLayout(jFoto);
        jFoto.setLayout(jFotoLayout);
        jFotoLayout.setHorizontalGroup(
            jFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        jFotoLayout.setVerticalGroup(
            jFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jlMensaje.setBackground(new java.awt.Color(51, 51, 51));
        jlMensaje.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jlMensaje.setForeground(new java.awt.Color(102, 102, 102));

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
        jAgregarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAgregarFotoMouseClicked(evt);
            }
        });
        jAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarFotoActionPerformed(evt);
            }
        });

        jEliminarCuenta.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jEliminarCuenta.setForeground(new java.awt.Color(204, 0, 51));
        jEliminarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-contact.png"))); // NOI18N
        jEliminarCuenta.setText("Eliminar Cuenta");
        jEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarCuentaActionPerformed(evt);
            }
        });

        jbImprimir.setBackground(new java.awt.Color(255, 255, 255));
        jbImprimir.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jbImprimir.setForeground(new java.awt.Color(41, 184, 115));
        jbImprimir.setText("Imprimir ");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jAgregarFoto)
                        .addGap(18, 18, 18)
                        .addComponent(jbImprimir))
                    .addComponent(jlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jEliminarCuenta, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jbSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEliminarCuenta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAgregarFoto)
                            .addComponent(jbImprimir))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/weightlifting.png"))); // NOI18N
        jLabel1.setText("TUS EJERCICIOS");

        jPanel3.setBackground(new java.awt.Color(41, 184, 115));
        jPanel3.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apple-black-silhouette-with-a-leaf.png"))); // NOI18N
        jLabel2.setText("TU DIETA");

        jPanel6.setBackground(new java.awt.Color(41, 184, 115));
        jPanel6.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtablaDietas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtablaDietas);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/beberAgua.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("CONTROLA EL AGUA QUE TOMAS");

        jPanel8.setBackground(new java.awt.Color(41, 184, 115));
        jPanel8.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jAñadirAgua.setBackground(new java.awt.Color(0, 153, 51));
        jAñadirAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus-black-symbol.png"))); // NOI18N
        jAñadirAgua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAñadirAguaMouseClicked(evt);
            }
        });
        jAñadirAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAñadirAguaActionPerformed(evt);
            }
        });

        jRestarAgua.setBackground(new java.awt.Color(102, 0, 0));
        jRestarAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        jRestarAgua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRestarAguaMouseClicked(evt);
            }
        });
        jRestarAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRestarAguaActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glass (1).png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/glass (1).png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Has tomado 500ml");

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("El último vaso ha sido a las: ");

        jHora.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jHora.setForeground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAñadirAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRestarAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgresoAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jAñadirAgua)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jRestarAgua))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgresoAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addContainerGap(93, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        VentanaLogin ventana = null;
        try {
            ventana = new VentanaLogin();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventana.setVisible(true);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jAñadirAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAñadirAguaActionPerformed
        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();

        String email = this.email;

        //Obtener hora actual
        Calendar calendario = new GregorianCalendar();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        String horaActual = hora + ":" + minutos + ":" + segundos;

        //Obtener fecha actual
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);

        String fechaActual = date.replace('/', '-');

        // Comprueba si hay registros
        String SQL = "SELECT fecha\n"
                + " FROM vasos_agua\n"
                + " WHERE email = '" + email + "' \n"
                + " AND id_agua = ( SELECT MAX(id_agua)\n"
                + " FROM vasos_agua\n"
                + " WHERE email = '" + email + "')";

        Statement consulta = null;
        String fecha = "";
        try {
            consulta = conexion.getConexion().createStatement();
            ResultSet listado = consulta.executeQuery(SQL);

            while (listado.next()) {
                fecha = listado.getString("fecha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        String inserta = "";
        if (!fecha.equals(fechaActual)) {

            inserta = "INSERT INTO vasos_agua(email,n_vasos,hora,fecha)"
                    + "VALUES('" + email + "'," + 1 + ",'" + horaActual + "','" + fechaActual + "')";
            try {
                consulta = conectar.createStatement();
                consulta.executeUpdate(inserta);

                jHora.setText(horaActual);
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (fecha.equals(fechaActual)) {
            String cantidadBebida = "SELECT n_vasos"
                    + " FROM vasos_agua"
                    + " WHERE email = '" + email
                    + "' AND id_agua = (SELECT MAX(id_agua)"
                    + " FROM vasos_agua"
                    + " WHERE email = '" + email + "')";

            String vasos = "";
            try {
                Statement consultaCantidad = conectar.createStatement();
                ResultSet cantidad = consultaCantidad.executeQuery(cantidadBebida);
                while (cantidad.next()) {
                    vasos = cantidad.getString("n_vasos");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Selecciona ultimo id 
            String idUser = "";

            String id = "SELECT MAX(id_agua) AS 'id'"
                    + " FROM vasos_agua"
                    + " WHERE email = '" + email + "'";

            try {
                consulta = conectar.createStatement();
                ResultSet idDB = consulta.executeQuery(id);
                while (idDB.next()) {
                    idUser = idDB.getString("id");
                }
            } catch (SQLException ex) {
                System.out.println("Id no seleccionado");
            }

            int cantidadTotal = Integer.parseInt(vasos) + 1;

            if (cantidadTotal <= 8) {
                String actualizar = "UPDATE vasos_agua"
                        + " SET n_vasos = '" + cantidadTotal + "'," + "hora = '" + horaActual + "'"
                        + " WHERE id_agua = '" + idUser + "'";

                try {
                    consulta = conectar.createStatement();
                    consulta.executeUpdate(actualizar);

                    jHora.setText(horaActual);

                    // ====================
                    //   CANTIDAD DE AGUA
                    // ====================
                    switch (cantidadTotal) {
                        case 0:
                            jLabel7.setText("Has tomado 0ml");
                            jProgresoAgua.setValue(0);
                            break;
                        case 1:
                            jLabel7.setText("Has tomado 250ml");
                            jProgresoAgua.setValue(12);
                            break;
                        case 2:
                            jLabel7.setText("Has tomado 500ml");
                            jProgresoAgua.setValue(25);
                            break;
                        case 3:
                            jLabel7.setText("Has tomado 750ml");
                            jProgresoAgua.setValue(37);
                            break;
                        case 4:
                            jLabel7.setText("Has tomado 1000ml");
                            jProgresoAgua.setValue(50);
                            break;
                        case 5:
                            jLabel7.setText("Has tomado 1250ml");
                            jProgresoAgua.setValue(62);
                            break;
                        case 6:
                            jLabel7.setText("Has tomado 1500ml");
                            jProgresoAgua.setValue(75);
                            break;
                        case 7:
                            jLabel7.setText("Has tomado 1750ml");
                            jProgresoAgua.setValue(87);
                            break;
                        default:
                            jLabel7.setText("Objetivo cumplido 2Litros");
                            jProgresoAgua.setValue(100);

                    }

                } catch (SQLException ex) {
                    System.out.println("No se ha actualizado");
                }
            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "No puede añadir mas cantidad.Objetivo cumplido!");
            }

        }

    }//GEN-LAST:event_jAñadirAguaActionPerformed

    private void jRestarAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRestarAguaActionPerformed
        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();
        Statement consulta = null;

        //Obtener hora actual
        Calendar calendario = new GregorianCalendar();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        String horaActual = hora + ":" + minutos + ":" + segundos;

        String email = this.email;

        String SQL = "SELECT id_agua,n_vasos"
                + " FROM vasos_agua"
                + " WHERE id_agua = (SELECT MAX(id_agua)"
                + " FROM vasos_agua"
                + " WHERE email = '" + email + "')";
        String idAgua = "";
        String nVasos = "";
        try {
            consulta = conectar.createStatement();
            ResultSet resultado = consulta.executeQuery(SQL);

            while (resultado.next()) {
                idAgua = resultado.getString("id_agua");
                nVasos = resultado.getString("n_vasos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        consulta = null;

        int cantidadTotal = Integer.parseInt(nVasos) - 1;

        if (Integer.parseInt(nVasos) >= 1) {
            String actualizar = "UPDATE vasos_agua"
                    + " SET n_vasos = '" + cantidadTotal + "',hora = '" + horaActual + "'"
                    + " WHERE id_agua = '" + idAgua + "'";

            try {
                consulta = conectar.createStatement();
                consulta.executeUpdate(actualizar);

                jHora.setText(horaActual);

                // ====================
                //   CANTIDAD DE AGUA
                // ====================
                switch (cantidadTotal) {
                    case 0:
                        jLabel7.setText("Has tomado 0ml");
                        jProgresoAgua.setValue(0);
                        break;
                    case 1:
                        jLabel7.setText("Has tomado 250ml");
                        jProgresoAgua.setValue(12);
                        break;
                    case 2:
                        jLabel7.setText("Has tomado 500ml");
                        jProgresoAgua.setValue(25);
                        break;
                    case 3:
                        jLabel7.setText("Has tomado 750ml");
                        jProgresoAgua.setValue(37);
                        break;
                    case 4:
                        jLabel7.setText("Has tomado 1000ml");
                        jProgresoAgua.setValue(50);
                        break;
                    case 5:
                        jLabel7.setText("Has tomado 1250ml");
                        jProgresoAgua.setValue(62);
                        break;
                    case 6:
                        jLabel7.setText("Has tomado 1500ml");
                        jProgresoAgua.setValue(75);
                        break;
                    case 7:
                        jLabel7.setText("Has tomado 1750ml");
                        jProgresoAgua.setValue(87);
                        break;
                    default:
                        jLabel7.setText("Objetivo cumplido 2Litros");
                        jProgresoAgua.setValue(100);

                }
            } catch (SQLException ex) {
                System.out.println(actualizar);
                System.out.println("No se ha actualizado");
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se puede eliminar mas vasos de agua");
        }

    }//GEN-LAST:event_jRestarAguaActionPerformed

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

        if (opcion == JOptionPane.NO_OPTION) {
            System.out.println("NO");
        }
    }//GEN-LAST:event_jEliminarCuentaActionPerformed

    private void jbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/analogico_1.wav"));
        sonido.play();
    }//GEN-LAST:event_jbSalirMouseClicked

    private void jRestarAguaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRestarAguaMouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/musical003.wav"));
        sonido.play();
    }//GEN-LAST:event_jRestarAguaMouseClicked

    private void jAñadirAguaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAñadirAguaMouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/vasoWATERglass.wav"));
        sonido.play();
    }//GEN-LAST:event_jAñadirAguaMouseClicked

    private void jAgregarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAgregarFotoMouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
    }//GEN-LAST:event_jAgregarFotoMouseClicked

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        Imprimir imprimir = new Imprimir();
        imprimir.setVisible(true);
    }//GEN-LAST:event_jbImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Cliente().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fotoPerfil;
    private javax.swing.JButton jAgregarFoto;
    private javax.swing.JButton jAñadirAgua;
    private javax.swing.JButton jEliminarCuenta;
    private javax.swing.JPanel jFoto;
    private javax.swing.JLabel jHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgresoAgua;
    private javax.swing.JButton jRestarAgua;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbSalir;
    public static javax.swing.JLabel jlMensaje;
    private javax.swing.JTable jtablaDietas;
    private javax.swing.JTable jtablaEjercicios;
    // End of variables declaration//GEN-END:variables
}
