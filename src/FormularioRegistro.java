
import java.applet.AudioClip;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Horacio Ramírez
 */
public class FormularioRegistro extends javax.swing.JFrame {

    private Conexion conexion;
    private VentanaLogin ventanaPrincipal;
    private AudioClip sonido;

    public FormularioRegistro() {
        initComponents();
        this.jFormularioCliente.setVisible(false);
        this.conexion = new Conexion();
        this.setLocationRelativeTo(null);//Centrar Ventana
    }

    // ===============
    //  VALIDACIONES
    // ===============
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher validar = pattern.matcher(email);

        if (validar.find() == true) {
            return true;
        }
        return false;
    }

    private boolean validarContraseña(String contraseña) {

        int cantMay = 0;
        int cantMin = 0;
        int cantNum = 0;

        if (contraseña.length() > 8) {
            for (int i = 0; i < contraseña.length(); i++) {
                char clave = contraseña.charAt(i);
                String contValor = String.valueOf(clave);

                if (contValor.matches("[A-Z]")) {
                    cantMay++;
                }
                if (contValor.matches("[a-z]")) {
                    cantMin++;
                }

                if (contValor.matches("[0-9]")) {
                    cantNum++;
                }
            }

            if (cantMay < 2 && cantMin < 3 && cantNum < 1) {
                return false;
            } else {
                return true;
            }

        } else {

            return false;
        }
    }

    private static boolean relleno(String campo) {
        if (campo.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean validarFecha(String fecha) {
        if (fecha.length() == 10) {
            for (int i = 0; i < fecha.length(); i++) {
                if (fecha.charAt(2) != '/' && fecha.charAt(5) != '/') {
                    return false;
                }
            }
            String[] datos = fecha.split("/");
            String dia = datos[0];
            String mes = datos[1];
            String año = datos[2];

            if (!isNumeric(dia) || Integer.parseInt(dia) <= 0 || Integer.parseInt(dia) > 31) {
                return false;
            }
            if (!isNumeric(mes) || Integer.parseInt(mes) <= 0 || Integer.parseInt(mes) > 12) {
                return false;
            }
            if (!isNumeric(año) || Integer.parseInt(año) < 1960 || Integer.parseInt(año) > 2018) {
                return false;
            }

        } else {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbVolver = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtApellidos = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcTipo = new javax.swing.JComboBox<>();
        jLimpiar = new javax.swing.JButton();
        jEnviar = new javax.swing.JButton();
        jtContraseña = new javax.swing.JPasswordField();
        jtRepiteContraseña = new javax.swing.JPasswordField();
        jFormularioCliente = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jrHombre = new javax.swing.JRadioButton();
        jrMujer = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jtAltura = new javax.swing.JTextField();
        jtPeso = new javax.swing.JTextField();
        jError7 = new javax.swing.JLabel();
        jError8 = new javax.swing.JLabel();
        jError4 = new javax.swing.JLabel();
        jError5 = new javax.swing.JLabel();
        jError2 = new javax.swing.JLabel();
        jError1 = new javax.swing.JLabel();
        jError3 = new javax.swing.JLabel();
        jError6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(41, 184, 115));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Introduce tus datos");

        jbVolver.setBackground(new java.awt.Color(255, 255, 255));
        jbVolver.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jbVolver.setForeground(new java.awt.Color(41, 184, 115));
        jbVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reply.png"))); // NOI18N
        jbVolver.setText("Volver");
        jbVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVolverMouseClicked(evt);
            }
        });
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbVolver)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jbVolver))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel3.setText("APELLIDOS: ");

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel4.setText("EMAIL: ");

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel5.setText("CONTRASEÑA:");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel6.setText("REPITE CONTRASEÑA:");

        jtNombre.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtApellidos.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellidosKeyTyped(evt);
            }
        });

        jtEmail.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmailActionPerformed(evt);
            }
        });
        jtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEmailKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel7.setText("FECHA DE NACIMIENTO:");

        jtFecha.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtFechaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel8.setText("REGISTRARSE COMO");

        jcTipo.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jcTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nutricionista", "entrenador", "cliente" }));
        jcTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTipoActionPerformed(evt);
            }
        });

        jLimpiar.setBackground(new java.awt.Color(41, 184, 115));
        jLimpiar.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLimpiar.setText("Borrar");
        jLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimpiarActionPerformed(evt);
            }
        });

        jEnviar.setBackground(new java.awt.Color(41, 184, 115));
        jEnviar.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jEnviar.setText("Enviar");
        jEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEnviarActionPerformed(evt);
            }
        });

        jtContraseña.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtContraseñaActionPerformed(evt);
            }
        });
        jtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtContraseñaKeyTyped(evt);
            }
        });

        jtRepiteContraseña.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jtRepiteContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtRepiteContraseñaActionPerformed(evt);
            }
        });
        jtRepiteContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtRepiteContraseñaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel9.setText("SEXO");

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel11.setText("ALTURA:");

        GrupoSexo.add(jrHombre);
        jrHombre.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jrHombre.setText("Hombre");

        GrupoSexo.add(jrMujer);
        jrMujer.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jrMujer.setText("Mujer");

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel10.setText("PESO:");

        jtAltura.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtAlturaKeyTyped(evt);
            }
        });

        jtPeso.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPesoKeyTyped(evt);
            }
        });

        jError7.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError7.setForeground(new java.awt.Color(255, 0, 51));

        jError8.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError8.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jFormularioClienteLayout = new javax.swing.GroupLayout(jFormularioCliente);
        jFormularioCliente.setLayout(jFormularioClienteLayout);
        jFormularioClienteLayout.setHorizontalGroup(
            jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFormularioClienteLayout.createSequentialGroup()
                .addGroup(jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jFormularioClienteLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(39, 39, 39)
                        .addGroup(jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrMujer)
                            .addComponent(jrHombre)))
                    .addGroup(jFormularioClienteLayout.createSequentialGroup()
                        .addGroup(jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(jtAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                    .addComponent(jError7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addComponent(jError8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFormularioClienteLayout.setVerticalGroup(
            jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFormularioClienteLayout.createSequentialGroup()
                .addGroup(jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFormularioClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jrHombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrMujer))
                    .addGroup(jFormularioClienteLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)))
                .addGap(14, 14, 14)
                .addGroup(jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jError7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFormularioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jError8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jError4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError4.setForeground(new java.awt.Color(204, 0, 0));

        jError5.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError5.setForeground(new java.awt.Color(204, 0, 51));

        jError2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError2.setForeground(new java.awt.Color(204, 0, 51));

        jError1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError1.setForeground(new java.awt.Color(204, 0, 51));

        jError3.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError3.setForeground(new java.awt.Color(204, 0, 51));

        jError6.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jError6.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(107, 107, 107)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jError2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jError1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addComponent(jLimpiar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jEnviar))
                                    .addComponent(jLabel8)
                                    .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jFormularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 11, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jError5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jError4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtRepiteContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jError3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jError6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jError1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jError2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jError3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jError4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtRepiteContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jError5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jError6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jFormularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLimpiar)
                            .addComponent(jEnviar))
                        .addGap(0, 80, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed

    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEmailActionPerformed

    private void registrarUsuario(Connection conectar, String email, String contraseña,
            String nombre, String apellidos, String fechaNacimiento, String tipo) {

        String SQL = "INSERT INTO usuario_registrado VALUES('" + email + "','" + contraseña + "','" + nombre + "','" + apellidos + "','" + fechaNacimiento + "','" + tipo + "','')";
        System.out.println(SQL);
        try {
            Statement consulta = conectar.createStatement();
            consulta.executeUpdate(SQL);
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente");
        } catch (SQLException ex) {
            Logger.getLogger(FormularioRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarEntrenador(Connection conectar, String email) {
        String idEntrenador = "";
        String SQLId = "SELECT MAX(id_entrenador) AS 'lastId' FROM entrenador ";
        try {
            Statement resultado = conectar.createStatement();
            ResultSet id = resultado.executeQuery(SQLId);
            while (id.next()) {
                idEntrenador = id.getString("lastId");

            }
        } catch (SQLException ex) {
            System.out.println("id no seleccionado");
        }

        int id = 0;
        if (idEntrenador != null) {
            id = Integer.parseInt(idEntrenador) + 1;
        }

        // Inserta en tabla entrenador
        String SQLEntrenador = "INSERT INTO entrenador VALUES(" + id + ",'" + email + "')";

        try {
            Statement insertar = conectar.createStatement();
            insertar.executeUpdate(SQLEntrenador);

        } catch (SQLException ex) {
            System.out.println("No inserta en entrenador");
        }
        this.setVisible(false);
        try {
            this.ventanaPrincipal = new VentanaLogin();
            this.ventanaPrincipal.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void insertarNutricionista(Connection conectar, String email) {
        String idNutricionista = "";
        // Selecciona último id
        String SQLId = "SELECT MAX(id_nutricionista) AS 'lastId' FROM nutricionista ";
        try {
            Statement resultado = conectar.createStatement();
            ResultSet id = resultado.executeQuery(SQLId);
            while (id.next()) {
                idNutricionista = id.getString("lastId");

            }
        } catch (SQLException ex) {
            System.out.println("id no seleccionado");
        }
        int id = 0;
        if (idNutricionista != null) {
            id = Integer.parseInt(idNutricionista) + 1;
        }

        // Inserta en tabla nutricionista
        String SQLNutricionista = "INSERT INTO nutricionista VALUES(" + id + ",'" + email + "')";

        try {
            Statement insertar = conectar.createStatement();
            insertar.executeUpdate(SQLNutricionista);

        } catch (SQLException ex) {
            System.out.println("No inserta en nutricionista");
        }

        this.setVisible(false);
        try {
            this.ventanaPrincipal = new VentanaLogin();
            this.ventanaPrincipal.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarCliente(Connection conectar, String email, String[] extraerFecha, String altura, String peso) {

        if (!altura.isEmpty() && !peso.isEmpty()) {
            String sexo = "";

            if (jrHombre.isSelected()) {
                sexo = "hombre";
            } else {
                sexo = "mujer";
            }
            // =================
            //   CALCULAR EDAD
            // =================

            //Obtener fecha actual
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            String date = dtf.format(localDate);
            String[] fechaActual = date.split("/");

            int añoNacimiento = Integer.parseInt(extraerFecha[2]);
            int mesNacimiento = Integer.parseInt(extraerFecha[1]);
            int diaNacimiento = Integer.parseInt(extraerFecha[0]);

            int añoActual = Integer.parseInt(fechaActual[0]);
            int mesActual = Integer.parseInt(fechaActual[1]);
            int diaActual = Integer.parseInt(fechaActual[2]);

            int edad = añoActual - añoNacimiento;

            if (mesNacimiento > mesActual) {
                edad--;
            } else if ((mesNacimiento == mesActual) && (diaNacimiento < diaActual)) {
                edad--;
            }

            // Inserta en tabla cliente
            String SQLCliente = "INSERT INTO cliente(email,sexo,edad,estatura,peso) VALUES('" + email + "','" + sexo + "'," + edad + "," + altura + "," + peso + ")";

            try {
                Statement insertar = conectar.createStatement();
                insertar.executeUpdate(SQLCliente);

            } catch (SQLException ex) {
                System.out.println("No inserta en cliente");
            }
            this.setVisible(false);
            try {
                this.ventanaPrincipal = new VentanaLogin();
                this.ventanaPrincipal.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormularioRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void jEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEnviarActionPerformed
       
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
        
        // Recopila los datos
        String nombre = jtNombre.getText();
        if (nombre.isEmpty()) {
            jError1.setText("*Campo vacío");
        } else {
            jError1.setText("");
        }

        String apellidos = jtApellidos.getText();
        if (apellidos.isEmpty()) {
            jError2.setText("*Campo vacío");
        } else {
            jError2.setText("");
        }

        String email = jtEmail.getText();
        if (email.isEmpty()) {
            jError3.setText("*Campo vacío");
        } else {
            if (!validarEmail(email)) {
                jError3.setText("*Email no válido");
            } else {
                jError3.setText("");
            }
        }

        char[] contraseñaInput = jtContraseña.getPassword();
        String contraseña = "";
        for (int i = 0; i < contraseñaInput.length; i++) {
            contraseña += "" + contraseñaInput[i];
        }

        if (contraseña.equals("")) {
            jError4.setText("*Campo vacío");
        } else {
            jError4.setText("");
        }

        if (!validarContraseña(contraseña)) {
            jError4.setText("*Contraseña débil");
        } else {
            jError4.setText("");
        }

        char[] contraseñaRepiteInput = jtRepiteContraseña.getPassword();
        String contraseñaRepetida = "";
        for (int i = 0; i < contraseñaRepiteInput.length; i++) {
            contraseñaRepetida += "" + contraseñaRepiteInput[i];
        }

        if (contraseñaRepetida.equals("")) {
            jError5.setText("*Campo vacío");
        } else {
            jError5.setText("");
        }

        String fecha = jtFecha.getText();
        if (!fecha.isEmpty()) {
            jError6.setText("");
            if (validarContraseña(contraseña)) {
                if (validarFecha(fecha)) {
                    String tipo = jcTipo.getSelectedItem().toString();

                    if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()
                            && validarEmail(email) && !contraseña.isEmpty() && !fecha.isEmpty()
                            && validarFecha(fecha)) {

                        //Formatea fecha
                        String[] extraerFecha = fecha.split("/");
                        String fechaNacimiento = extraerFecha[2] + "-" + extraerFecha[1] + "-" + extraerFecha[0];

                        if (!contraseña.equals(contraseñaRepetida)) {
                            jError5.setText("Las contraseñas no coinciden");

                        } else {

                            if (validarEmail(email)) {
                                Connection conectar = this.conexion.conectar();

                                if (tipo.equals("entrenador")) {
                                    registrarUsuario(conectar, email, contraseña, nombre, apellidos, fechaNacimiento, tipo);
                                    insertarEntrenador(conectar, email);

                                } else if (tipo.equals("nutricionista")) {
                                    registrarUsuario(conectar, email, contraseña, nombre, apellidos, fechaNacimiento, tipo);
                                    insertarNutricionista(conectar, email);

                                } else {
                                    String altura = jtAltura.getText();
                                    String peso = jtPeso.getText();

                                    if (!relleno(altura) && !relleno(peso)) {
                                        jError7.setText("*Campo vacío");
                                        jError8.setText("*Campo vacío");
                                    } else {
                                        jError7.setText("");
                                        jError8.setText("");

                                        if (relleno(altura)) {
                                            jError7.setText("");
                                            if (Float.parseFloat(altura) > 0.99f
                                                    && Float.parseFloat(altura) <= 2.50f) {
                                                if (relleno(peso)) {
                                                    jError8.setText("");

                                                    if (Float.parseFloat(peso) > 19.99f
                                                            && Float.parseFloat(peso) <= 200.00f) {
                                                        registrarUsuario(conectar, email, contraseña, nombre, apellidos, fechaNacimiento, tipo);
                                                        insertarCliente(conectar, email, extraerFecha, altura, peso);
                                                    } else {
                                                        getToolkit().beep();
                                                        JOptionPane.showMessageDialog(null, "El peso debe estar comprendido entre 20.000 y 200.000 Kgs");
                                                    }

                                                } else {
                                                    jError8.setText("*Campo vacío");
                                                }
                                            } else {
                                                getToolkit().beep();
                                                JOptionPane.showMessageDialog(null, "La altura debe estar comprendida entre 1.00 y 2.50 metros");
                                            }

                                        } else {
                                            jError7.setText("*Campo vacío");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
                    }
                } else {
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Introduzca la fecha siguiendo el siguiente formato: DD/MM/AAAA");
                }

            } else {
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Contraseña débil, introduzca caracteres en mayúsculas, minúsculas y números");
            }
        } else {
            jError6.setText("*Campo vacío");
        }


    }//GEN-LAST:event_jEnviarActionPerformed

    private void jcTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTipoActionPerformed
        // TODO add your handling code here:
        if (jcTipo.getSelectedItem().toString().equals("cliente")) {
            this.jFormularioCliente.setVisible(true);
        }

        if (jcTipo.getSelectedItem().toString().equals("nutricionista")) {
            this.jFormularioCliente.setVisible(false);
        }

        if (jcTipo.getSelectedItem().toString().equals("entrenador")) {
            this.jFormularioCliente.setVisible(false);
        }
    }//GEN-LAST:event_jcTipoActionPerformed

    private void jtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtContraseñaActionPerformed

    private void jtRepiteContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtRepiteContraseñaActionPerformed
        // TODO add your handling code here:
        if (!(jtContraseña.toString().equals(jtRepiteContraseña.toString()))) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
    }//GEN-LAST:event_jtRepiteContraseñaActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        VentanaLogin ventana = null;
        try {
            ventana = new VentanaLogin();
        } catch (SQLException ex) {
            Logger.getLogger(FormularioRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventana.setVisible(true);
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        int numCaracteres = 20;
        if (jtNombre.getText().length() >= numCaracteres) {
            evt.consume();
            jError1.setText("Máximo 20 caracteres");
        } else {
            jError1.setText("");
        }
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidosKeyTyped
        int numCaracteres = 70;
        if (jtApellidos.getText().length() >= numCaracteres) {
            evt.consume();
            jError2.setText("Máximo 70 caracteres");
        } else {
            jError2.setText("");
        }
    }//GEN-LAST:event_jtApellidosKeyTyped

    private void jtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmailKeyTyped
        int numCaracteres = 40;
        if (jtEmail.getText().length() >= numCaracteres) {
            evt.consume();
            jError3.setText("Máximo 40 caracteres");
        } else {
            jError3.setText("");
        }
    }//GEN-LAST:event_jtEmailKeyTyped

    private void jtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtContraseñaKeyTyped

        if (jtContraseña.getSelectionEnd() >= 255) {
            evt.consume();
            jError4.setText("Máximo 255 caracteres");
        } else {
            jError4.setText("");
        }
    }//GEN-LAST:event_jtContraseñaKeyTyped

    private void jtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFechaKeyTyped
        int numCaracteres = 10;
        String[] fecha = jtFecha.getText().toString().split("/");
        if (jtFecha.getText().length() >= numCaracteres) {
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Tamaño demasiado grande para la fecha");
        }
    }//GEN-LAST:event_jtFechaKeyTyped

    private void jtRepiteContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtRepiteContraseñaKeyTyped
        if (jtRepiteContraseña.getSelectionEnd() >= 255) {
            evt.consume();
            jError5.setText("Máximo 255 caracteres");
        } else {
            jError5.setText("");
        }

    }//GEN-LAST:event_jtRepiteContraseñaKeyTyped

    private void jtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtAlturaKeyTyped

        if (jtAltura.getText().length() >= 4) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cantidad de dígitos superada. "
                    + " Por favor introduce tu altura con el siguiente formato" + "\n"
                    + " Ejemplo: 1.78");

        }

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres alfabéticos no permitidos. "
                    + "Por favor, introduzca dígitos");
        }
    }//GEN-LAST:event_jtAlturaKeyTyped

    private void jtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesoKeyTyped
        if (jtPeso.getText().length() >= 7) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cantidad de dígitos superada. "
                    + " Por favor introduce tu peso con el siguiente formato" + "\n"
                    + " Ejemplo: 70.200");
        }

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Caracteres alfabéticos no permitidos. "
                    + "Por favor, introduzca dígitos");
        }
    }//GEN-LAST:event_jtPesoKeyTyped

    private void jbVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVolverMouseClicked
        
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/analogico_1.wav"));
        sonido.play();
    }//GEN-LAST:event_jbVolverMouseClicked

    private void jLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimpiarActionPerformed
       
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();

        jError1.setText("");
        jError2.setText("");
        jError3.setText("");
        jError4.setText("");
        jError5.setText("");
        jError6.setText("");
        jError7.setText("");
        jError8.setText("");
        jtNombre.setText("");
        jtApellidos.setText("");
        jtEmail.setText("");
        jtContraseña.setText("");
        jtRepiteContraseña.setText("");
        jtAltura.setText("");
        jtPeso.setText("");
    }//GEN-LAST:event_jLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoSexo;
    private javax.swing.JButton jEnviar;
    private javax.swing.JLabel jError1;
    private javax.swing.JLabel jError2;
    private javax.swing.JLabel jError3;
    private javax.swing.JLabel jError4;
    private javax.swing.JLabel jError5;
    private javax.swing.JLabel jError6;
    private javax.swing.JLabel jError7;
    private javax.swing.JLabel jError8;
    private javax.swing.JPanel jFormularioCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox<String> jcTipo;
    private javax.swing.JRadioButton jrHombre;
    private javax.swing.JRadioButton jrMujer;
    private javax.swing.JTextField jtAltura;
    private javax.swing.JTextField jtApellidos;
    private javax.swing.JPasswordField jtContraseña;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPeso;
    private javax.swing.JPasswordField jtRepiteContraseña;
    // End of variables declaration//GEN-END:variables
}
