
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.applet.AudioClip;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Horacio
 */
public class Imprimir extends javax.swing.JFrame {

    private String email;

    public Imprimir() {
        initComponents();
        this.setLocationRelativeTo(null);//Centrar Ventana
        this.email = VentanaLogin.jtEmail.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jHTML = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel1.setText("IMPRIMIR EN PDF:");

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel2.setText("IMPRIMIR EN HTML:");

        jButton1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jHTML.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jHTML.setText("Imprimir");
        jHTML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHTMLMouseClicked(evt);
            }
        });
        jHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHTMLActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(41, 184, 115));

        jVolver.setBackground(new java.awt.Color(255, 255, 255));
        jVolver.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jVolver.setForeground(new java.awt.Color(41, 184, 115));
        jVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reply.png"))); // NOI18N
        jVolver.setText("Volver");
        jVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVolverMouseClicked(evt);
            }
        });
        jVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jVolver)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jHTML)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jHTML)
                .addContainerGap(41, Short.MAX_VALUE))
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

    private String[][] tablaEjercicios() throws SQLException {
        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();

        String SQLEjercicios = "SELECT nombre_ejercicio,n_series,n_repeticiones,t_descanso "
                + " FROM cliente INNER JOIN ejercicio"
                + " ON cliente.id_tabla = ejercicio.id_tabla"
                + " AND cliente.email = '" + this.email + "'";

        Statement consulta;
        String[][] matriz = null;

        try {
            consulta = conexion.getConexion().createStatement();
            ResultSet columnas1 = consulta.executeQuery(SQLEjercicios);

            int cantEjer = 0;
            while (columnas1.next()) {
                cantEjer++;
            }
            matriz = new String[cantEjer][4];
            consulta.close();

        } catch (SQLException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            consulta = conexion.getConexion().createStatement();
            ResultSet listado = consulta.executeQuery(SQLEjercicios);

            int i = 0;
            while (listado.next()) {
                matriz[i][0] = listado.getString("nombre_ejercicio");
                matriz[i][1] = listado.getString("n_series");
                matriz[i][2] = listado.getString("n_repeticiones");
                matriz[i][3] = listado.getString("t_descanso");

                i++;
            }
            consulta.close();

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return matriz;
    }

    private String[][] tablaDieta() throws SQLException {
        Conexion conexion = new Conexion();
        Connection conectar = conexion.conectar();

        String SQLDietas = "SELECT nombre_plato,cant_proteinas,cant_carbohidratos,calorias "
                + " FROM cliente INNER JOIN platos"
                + " ON cliente.id_dieta = platos.id_dieta"
                + " AND cliente.email = '" + this.email + "'";

        Statement consulta;
        String[][] matriz = null;

        try {
            consulta = conexion.getConexion().createStatement();
            ResultSet columnas = consulta.executeQuery(SQLDietas);

            int cantDiet = 0;
            while (columnas.next()) {
                cantDiet++;
            }
            matriz = new String[cantDiet][4];
            consulta.close();

        } catch (SQLException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            consulta = conexion.getConexion().createStatement();
            ResultSet listado = consulta.executeQuery(SQLDietas);

            int i = 0;
            while (listado.next()) {
                matriz[i][0] = listado.getString("nombre_plato");
                matriz[i][1] = listado.getString("cant_proteinas");
                matriz[i][2] = listado.getString("cant_carbohidratos");
                matriz[i][3] = listado.getString("calorias");
                i++;
            }
            consulta.close();

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matriz;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser chooser = new JFileChooser();
        int opcion = chooser.showSaveDialog(this);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String ruta = file.getAbsolutePath();

            try {
                FileOutputStream archivo = new FileOutputStream(ruta + ".pdf");
                Document documento = new Document();

                //Font fuente = new Font("Nirmala UI", Font.BOLD, 22);
                Paragraph parrafo = new Paragraph("TABLA DE EJERCICIOS", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, Font.BOLD, BaseColor.WHITE));
                parrafo.setIndentationLeft(20);
                PdfPCell encabezado = new PdfPCell(parrafo);
                encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
                encabezado.setBackgroundColor(new BaseColor(41, 184, 115));
                encabezado.setPadding(20);

                Paragraph parrafo2 = new Paragraph("TABLA DE DIETA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, Font.BOLD, BaseColor.WHITE));
                PdfPCell encabezado2 = new PdfPCell(parrafo2);
                encabezado2.setHorizontalAlignment(Element.ALIGN_CENTER);
                encabezado2.setBackgroundColor(new BaseColor(41, 184, 115));
                encabezado2.setPadding(20);

                PdfWriter writer = PdfWriter.getInstance(documento, archivo);
                documento.open();

                //Tabla
                PdfPTable tabla = new PdfPTable(4);
                tabla.setWidthPercentage(100);
                encabezado.setColspan(4);

                PdfPCell ejercicio = new PdfPCell(new Phrase("EJERCICIO"));
                ejercicio.setPadding(10);
                ejercicio.setBackgroundColor(new BaseColor(220, 220, 220));
                ejercicio.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell series = new PdfPCell(new Phrase("SERIES"));
                series.setPadding(10);
                series.setBackgroundColor(new BaseColor(220, 220, 220));
                series.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell repeticiones = new PdfPCell(new Phrase("REPETICIONES"));
                repeticiones.setPadding(10);
                repeticiones.setBackgroundColor(new BaseColor(220, 220, 220));
                repeticiones.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell tiempo = new PdfPCell(new Phrase("DESCANSO"));
                tiempo.setPadding(10);
                tiempo.setBackgroundColor(new BaseColor(220, 220, 220));
                tiempo.setHorizontalAlignment(Element.ALIGN_CENTER);

                tabla.addCell(encabezado);
                tabla.addCell(ejercicio);
                tabla.addCell(series);
                tabla.addCell(repeticiones);
                tabla.addCell(tiempo);

                String[][] matriz = null;
                try {
                    matriz = tablaEjercicios();
                } catch (SQLException ex) {
                    Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int j = 0; j < matriz.length; j++) {
                    for (int k = 0; k < matriz[0].length; k++) {
                        PdfPCell dato = new PdfPCell(new Phrase(matriz[j][k]));
                        dato.setPadding(10);
                        dato.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(dato);
                    }

                }

                documento.add(tabla);
                Paragraph espacio = new Paragraph("\n");
                documento.add(espacio);
                documento.add(espacio);

                PdfPTable tabla2 = new PdfPTable(4);
                tabla2.setWidthPercentage(100);
                encabezado2.setColspan(4);

                PdfPCell plato = new PdfPCell(new Phrase("NOMBRE PLATO"));
                plato.setPadding(10);
                plato.setBackgroundColor(new BaseColor(220, 220, 220));
                plato.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell proteinas = new PdfPCell(new Phrase("PROTEÍNAS"));
                proteinas.setPadding(10);
                proteinas.setBackgroundColor(new BaseColor(220, 220, 220));
                proteinas.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell carbohidratos = new PdfPCell(new Phrase("CARBOHIDRATOS"));
                carbohidratos.setPadding(10);
                carbohidratos.setBackgroundColor(new BaseColor(220, 220, 220));
                carbohidratos.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell calorias = new PdfPCell(new Phrase("CALORÍAS"));
                calorias.setPadding(10);
                calorias.setBackgroundColor(new BaseColor(220, 220, 220));
                calorias.setHorizontalAlignment(Element.ALIGN_CENTER);

                tabla2.addCell(encabezado2);
                tabla2.addCell(plato);
                tabla2.addCell(proteinas);
                tabla2.addCell(carbohidratos);
                tabla2.addCell(calorias);

                String[][] matriz2 = null;
                try {
                    matriz2 = tablaDieta();
                } catch (SQLException ex) {
                    Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int j = 0; j < matriz2.length; j++) {
                    for (int k = 0; k < matriz2[0].length; k++) {
                        PdfPCell dato = new PdfPCell(new Phrase(matriz2[j][k]));
                        dato.setPadding(10);
                        dato.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla2.addCell(dato);
                    }
                }
                documento.add(tabla2);
                documento.close();

            } catch (DocumentException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Archivo PDF creado");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVolverMouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/analogico_1.wav"));
        sonido.play();
    }//GEN-LAST:event_jVolverMouseClicked

    private void jVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jVolverActionPerformed

    private void jHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHTMLActionPerformed
        JFileChooser chooser = new JFileChooser();
        int opcion = chooser.showSaveDialog(this);

        String[][] ejercicios = null;
        String[][] dieta = null;
        try {
            ejercicios = tablaEjercicios();
            dieta = tablaDieta();
        } catch (SQLException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (opcion == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String ruta = file.getAbsolutePath();
            file.mkdir();

            String nombreFicheroCSS = "";
            try {
                File rutaCSS = new File(ruta + "\\styles.css");
                BufferedWriter ficheroCSS = new BufferedWriter(new FileWriter(rutaCSS, false));
                nombreFicheroCSS = rutaCSS.getName();
                ficheroCSS.write("body{background-color:rgb(255,255,255);font-family: 'Roboto', sans-serif;}");
                ficheroCSS.write("header{background-color:#20925b;padding:35px;20px;30px;30px}");
                ficheroCSS.write("h1{font-size:35px;text-align:center;color:white}");
                ficheroCSS.write("section{margin-top:50px}");
                ficheroCSS.write("h2{text-align:center;font-size:35px;color:rgb(120,120,120)}");
                ficheroCSS.write(".underline{\n"
                        + "	width: 20%;\n"
                        + "	border-width: 3px;\n"
                        + "	border-color: #20925b\n"
                        + "}");
                ficheroCSS.write("table{background-color:rgb(255,255,255);\n"
                        + "     margin: 0 auto;\n"
                        + "	border-style:solid;\n"
                        + "	border-width: 1px;\n"
                        + "	border-bottom-width: 1px;\n"
                        + "	border-color:rgb(200,200,200);\n"
                        + "	border-collapse: collapse;\n"
                        + "	font-family: 'Lato', sans-serif;\n"
                        + "	width: 100%;}");
                ficheroCSS.write(".tableHeading{\n"
                        + "	background-color: #29B873;\n"
                        + "	color: white;\n"
                        + "	font-size: 20px;\n"
                        + "	font-weight: bold;\n"
                        + "}");
                ficheroCSS.write("td{padding:15px;\n"
                        + "	border-bottom:solid;\n"
                        + "	border-bottom-width: 1px;\n"
                        + "	border-color:rgb(200,200,200);\n"
                        + "	font-size: 19px;}");
                ficheroCSS.write("table tr:nth-child(even){background-color: #f2f2f2;}");
                ficheroCSS.write("td:nth-child(1){\n"
                        + "	background-color: #29B873;\n"
                        + "	color:rgb(255,255,255);\n"
                        + "}");
                ficheroCSS.write("td:nth-child(2){\n"
                        + "	text-align: center;\n"
                        + "}");
                ficheroCSS.write("td:nth-child(3){\n"
                        + "	text-align: center;\n"
                        + "}");
                ficheroCSS.close();
            } catch (IOException ex) {
                Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                BufferedWriter fichero = new BufferedWriter(new FileWriter(ruta + "\\feelgood.html", false));
                fichero.write("<html>");
                fichero.write("<head>");
                fichero.write("<title>FeelGood</title>");
                fichero.write("<meta author = 'Horacio Ramírez'>");
                fichero.write("<link rel='stylesheet' type='text/css' href='" + nombreFicheroCSS + "'");
                fichero.write("<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">");
                fichero.write("</head>");
                fichero.write("<header class='header'>");
                fichero.write("<div>");
                fichero.write("<h1> ESTAS SON TUS TAREAS PARA ESTA SEMANA</h1>");
                fichero.write("</div>");
                fichero.write("</header>");
                fichero.write("<body>");

                fichero.write("<section>");
                fichero.write("<h2>EJERCICIOS</h2>");
                fichero.write("<hr class='uderline'>");
                fichero.write("<table>");
                fichero.write("<tr class='row'>");
                fichero.write("<td class='tableHeading'> NOMBRE </td>");
                fichero.write("<td class='tableHeading'> SERIES </td>");
                fichero.write("<td class='tableHeading'> REPETICIONES </td>");
                fichero.write("<td class='tableHeading'> DESCANDO </td>");
                fichero.write("</tr>");
                fichero.write("<tr>");

                for (int i = 0; i < ejercicios.length; i++) {
                    for (int j = 0; j < ejercicios[0].length; j++) {
                        fichero.write("<td>");
                        fichero.write(ejercicios[i][j]);
                        fichero.write("</td>");
                    }
                    fichero.write("</tr>");
                }

                fichero.write("</table>");
                fichero.write("</section>");
                fichero.write("<section>");
                fichero.write("<h2>DIETA</h2>");
                fichero.write("<hr class='uderline'>");
                fichero.write("<table>");
                fichero.write("<tr class='row'>");
                fichero.write("<td class='tableHeading'> PLATO </td>");
                fichero.write("<td class='tableHeading'> PROTEÍNAS </td>");
                fichero.write("<td class='tableHeading'> CARBOHIDRATOS </td>");
                fichero.write("<td class='tableHeading'> CALORÍAS </td>");
                fichero.write("</tr>");
                fichero.write("<tr>");

                for (int i = 0; i < dieta.length; i++) {
                    for (int j = 0; j < dieta[0].length; j++) {
                        fichero.write("<td>");
                        fichero.write(dieta[i][j]);
                        fichero.write("</td>");
                    }
                    fichero.write("</tr>");
                }

                fichero.write("</table>");
                fichero.write("</section>");
                fichero.write("</body>");
                fichero.write("</html>");
                fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
            }
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Archivo HTML creado");
        }
    }//GEN-LAST:event_jHTMLActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jHTMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHTMLMouseClicked
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/btnSound.wav"));
        sonido.play();
    }//GEN-LAST:event_jHTMLMouseClicked

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
            java.util.logging.Logger.getLogger(Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Imprimir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jHTML;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jVolver;
    // End of variables declaration//GEN-END:variables
}
