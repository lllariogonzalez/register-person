package View;

import Controller.AppController;
import Model.Person;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class MostrarDatos extends javax.swing.JFrame {
    // Los datos se encuentran en memoria
    private DefaultTableModel modeloTabla;
    
    public MostrarDatos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        table = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        icon = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("Personas Registradas");

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.setViewportView(tablaPersonas);

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear.png"))); // NOI18N
        btnEliminar.setText("Eliminar registro seleccionado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(icon)
                .addGap(76, 76, 76)
                .addComponent(title)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(200, 200, 200))
            .addComponent(table, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(title)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarTabla();
    }//GEN-LAST:event_formComponentShown

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if(tablaPersonas.getRowCount() < 0 || tablaPersonas.getSelectedRow() == -1 ) {
            Window.showError("No hay registros seleccionados");
            return;
        }
        //
        Object selected = tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(),0);
        int index = Integer.parseInt(String.valueOf(selected));
        
        try{
            AppController.eliminarRegistro(index);
            Window.show("Registro eliminado correctamente");
            cargarTabla();
        }catch(Exception e){
            Window.showError("No se pudo eliminar el registro");
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    private void cargarTabla(){
        // si no está definido, definimos el modelo de tabla, y hacemos que no se pueda editar
        if(modeloTabla==null){
            modeloTabla = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
        }
        
        // establecemos los titulos de las columnas
        String[] titulos = {"id", "Nombre", "Apellido", "DNI", "Fecha de Nacimiento"};
        modeloTabla.setColumnIdentifiers(titulos);
        // limpiamos la tabla
        modeloTabla.setRowCount(0);
        // recuperamos los datos para mostrar
        List<Person> listaPersonas = AppController.mostrarDatos();
        if(listaPersonas!=null){
            for(int i = 0; i < listaPersonas.size(); i++){
                Object[] row = {
                    i,
                    listaPersonas.get(i).getNombre(),
                    listaPersonas.get(i).getApellido(), 
                    listaPersonas.get(i).getDni(), 
                    listaPersonas.get(i).getFechaNacimiento()
                }; 
                modeloTabla.addRow(row);
            }
        }
        tablaPersonas.setModel(modeloTabla);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel icon;
    private javax.swing.JTable tablaPersonas;
    private javax.swing.JScrollPane table;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
