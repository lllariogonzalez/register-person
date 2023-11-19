package View;

import Controller.AppController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CargaDatos extends javax.swing.JFrame {


    public CargaDatos() {
        initComponents();
        agregarListeners();
        validarFormulario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        apellido = new javax.swing.JLabel();
        dni = new javax.swing.JLabel();
        nacimiento = new javax.swing.JLabel();
        strNombre = new javax.swing.JTextField();
        strApellido = new javax.swing.JTextField();
        strDNI = new javax.swing.JTextField();
        strNacimiento = new javax.swing.JTextField();
        infoNombre = new javax.swing.JLabel();
        infoApellido = new javax.swing.JLabel();
        infoDNI = new javax.swing.JLabel();
        infoNacimiento = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        bg.setMaximumSize(new java.awt.Dimension(423, 386));

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("Carga de Datos");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombre.setText("Nombre:");
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 15, 99, -1));

        apellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        apellido.setText("Apellido:");
        jPanel2.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, 99, -1));

        dni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dni.setText("DNI:");
        jPanel2.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 104, 99, -1));

        nacimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nacimiento.setText("Nacimiento:");
        jPanel2.add(nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 150, -1, -1));

        strNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strNombreActionPerformed(evt);
            }
        });
        jPanel2.add(strNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 15, 153, -1));
        strNombre.getAccessibleContext().setAccessibleName("txtNombre");

        strApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strApellidoActionPerformed(evt);
            }
        });
        jPanel2.add(strApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 59, 153, -1));

        strDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strDNIActionPerformed(evt);
            }
        });
        jPanel2.add(strDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 104, 153, -1));

        strNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strNacimientoActionPerformed(evt);
            }
        });
        jPanel2.add(strNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 150, 153, -1));

        infoNombre.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        infoNombre.setForeground(new java.awt.Color(153, 153, 153));
        infoNombre.setText("No puede estar vacío");
        jPanel2.add(infoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 126, -1));

        infoApellido.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        infoApellido.setForeground(new java.awt.Color(153, 153, 153));
        infoApellido.setText("No puede estar vacío");
        jPanel2.add(infoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 126, -1));

        infoDNI.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        infoDNI.setForeground(new java.awt.Color(153, 153, 153));
        infoDNI.setText("Debe tener 8 dígitos");
        jPanel2.add(infoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 126, -1));

        infoNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        infoNacimiento.setForeground(new java.awt.Color(153, 153, 153));
        infoNacimiento.setText("Formato dd/mm/yyyy");
        jPanel2.add(infoNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 153, -1));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(title)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icon))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(title)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void strNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strNombreActionPerformed
        validarFormulario();
    }//GEN-LAST:event_strNombreActionPerformed

    private void strApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strApellidoActionPerformed
        validarFormulario();
    }//GEN-LAST:event_strApellidoActionPerformed

    private void strDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strDNIActionPerformed
        validarFormulario();
    }//GEN-LAST:event_strDNIActionPerformed

    private void strNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strNacimientoActionPerformed
        validarFormulario();
    }//GEN-LAST:event_strNacimientoActionPerformed
    
    // agregamos escuchadores de eventos para validar el formulario
    private void agregarListeners() {
        
        strNacimiento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnGuardar.doClick(); // Simula hacer clic en el botón "Guardar"
                }
            }
        });
   
        strNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarFormulario();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarFormulario();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarFormulario();
            }
        });

        strApellido.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarFormulario();
                infoApellido.setText("No puede estar vacío");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarFormulario();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarFormulario();
            }
        });

        strDNI.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarFormulario();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarFormulario();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarFormulario();
            }
        });

        strNacimiento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarFormulario();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarFormulario();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarFormulario();
            }
        });
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarFormulario()) {
            String nombre = strNombre.getText();
            String apellido = strApellido.getText();
            String dni = strDNI.getText();
            String fechaNacimiento = strNacimiento.getText();
            // creamos la Persona y la agregamos al Registro
            // si el formulario está validado, es decir los datos son correctos
            try {
                AppController.registrar(nombre, apellido, dni, fechaNacimiento);
                Window.show("Persona agregada al registro correctamente.");
                cleanForm();
            } catch (Exception e) {
                Window.showError("Error al registrar, intente nuevamente");
            }
        } else {
            Window.show("Por favor, complete todos los campos correctamente");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void cleanForm(){
        strNombre.setText("");
        strApellido.setText("");
        strDNI.setText("");
        strNacimiento.setText("");
    }
    
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cleanForm();
        validarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private boolean validarFormulario() {
        String nombre = strNombre.getText();
        String apellido = strApellido.getText();
        String dni = strDNI.getText();
        String fechaNacimiento = strNacimiento.getText();

        boolean formularioValido = AppController.validarDatos(nombre, apellido, dni, fechaNacimiento);
        
        btnGuardar.setEnabled(formularioValido); // Habilitar o deshabilitar el botón de guardar

        return formularioValido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel dni;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel infoApellido;
    private javax.swing.JLabel infoDNI;
    private javax.swing.JLabel infoNacimiento;
    private javax.swing.JLabel infoNombre;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nacimiento;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField strApellido;
    private javax.swing.JTextField strDNI;
    private javax.swing.JTextField strNacimiento;
    private javax.swing.JTextField strNombre;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
