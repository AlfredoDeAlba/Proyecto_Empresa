/*
 * Universidad Politecnica de San Luis Potosi
 * Programacion III Java
 *  Programacion Orientada a objetos
 */
package proyecto_final;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.io.FileNotFoundException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.Connection;
/**
 *
 * @author 177847
 */
public class Principal extends javax.swing.JFrame {
    private final Connection con;
    private ImageIcon foto;
    private Icon fondo;
    private final CreaPDF PDF;
    private final GeneracionExcel Excel;
    /**    
     * Creates new form Principal
     */
    public Principal(Connection con) {
        this.PDF=new CreaPDF(con);
        this.con=con;
        this.Excel=new GeneracionExcel(con); 
        
        initComponents();
        foto=new ImageIcon(getClass().getResource("/imagenes/OIP.png"));
        fondo=new ImageIcon(foto.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(),Image.SCALE_DEFAULT));
        lbFoto.setIcon(fondo);
        this.setTitle("Correspondencia Griega");
        this.setResizable(false);
        
    }
    public void verificar(String NumeroEmp) throws Excepciones{
        
        if(NumeroEmp.equals("")){
                throw new Excepciones(1);
            }else if((NumeroEmp.matches("[a-zA-Z]+"))){
                throw new Excepciones(2);
                
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        btnSalir1 = new javax.swing.JButton();
        lbFoto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAgregarEmpleado = new javax.swing.JMenuItem();
        btnEditarEmpleado = new javax.swing.JMenuItem();
        btnEliminarEmpleado = new javax.swing.JMenuItem();
        btnBuscaID = new javax.swing.JMenuItem();
        AsignarPaquetes = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        btnVerListaP = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnExcel = new javax.swing.JMenuItem();
        btnEmpleadosG = new javax.swing.JMenuItem();
        PDFEsp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSalir1.setText("Salir");
        btnSalir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalir1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(559, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir1)
                .addGap(20, 20, 20))
        );

        jMenu1.setText("Empleado");

        btnAgregarEmpleado.setText("Agregar Empleado");
        btnAgregarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarEmpleadoMouseClicked(evt);
            }
        });
        btnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(btnAgregarEmpleado);

        btnEditarEmpleado.setText("Editar Empleado");
        btnEditarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarEmpleadoMouseClicked(evt);
            }
        });
        btnEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(btnEditarEmpleado);

        btnEliminarEmpleado.setText("Eliminar Empleado");
        btnEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseClicked(evt);
            }
        });
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(btnEliminarEmpleado);

        btnBuscaID.setText("Ver Lista de Empleado");
        btnBuscaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaIDActionPerformed(evt);
            }
        });
        jMenu1.add(btnBuscaID);

        AsignarPaquetes.setText("Asignar Paquetes a Empleados");
        AsignarPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarPaquetesActionPerformed(evt);
            }
        });
        jMenu1.add(AsignarPaquetes);

        jMenuItem5.setText("Eliminar Empleado de envios");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Editar Empleado De Paquete");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        btnVerListaP.setText("Ver lista de empleado con Paquetes");
        btnVerListaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerListaPActionPerformed(evt);
            }
        });
        jMenu1.add(btnVerListaP);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Generar");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        btnExcel.setText("Excel-Generales");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jMenu2.add(btnExcel);

        btnEmpleadosG.setText("PDF-Empleado Generales");
        btnEmpleadosG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpleadosGMouseClicked(evt);
            }
        });
        btnEmpleadosG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosGActionPerformed(evt);
            }
        });
        jMenu2.add(btnEmpleadosG);

        PDFEsp.setText("PDF-Empleado Especifico");
        PDFEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFEspActionPerformed(evt);
            }
        });
        jMenu2.add(PDFEsp);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir1MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Que tenga buen dia");
        System.exit(0);
        
    }//GEN-LAST:event_btnSalir1MouseClicked

    private void btnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformed
        // TODO add your handling code here:
        new AgregarEmpleado(con).setVisible(true);
        
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformed

    private void btnEditarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarEmpleadoMouseClicked

    private void btnEliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEmpleadoMouseClicked

    private void btnAgregarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpleadoMouseClicked

    private void btnEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoActionPerformed
        // TODO add your handling code here:
        new EditarEmpleado(con).setVisible(true);
    }//GEN-LAST:event_btnEditarEmpleadoActionPerformed

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        new EliminarEmpleado(con).setVisible(true);
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void btnBuscaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaIDActionPerformed
        // TODO add your handling code here:
        new ListaDeEmpleados(con).setVisible(true);
    }//GEN-LAST:event_btnBuscaIDActionPerformed

    private void btnEmpleadosGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosGActionPerformed
        
        // TODO add your handling code here:
        PDF.crearPDFGenerales();
    }//GEN-LAST:event_btnEmpleadosGActionPerformed

    private void AsignarPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarPaquetesActionPerformed
        // TODO add your handling code here:}
        new AsignarEmpleado(con).setVisible(true);
    }//GEN-LAST:event_AsignarPaquetesActionPerformed

    private void btnEmpleadosGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosGMouseClicked
        // TODO add your handl
        
    }//GEN-LAST:event_btnEmpleadosGMouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void PDFEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFEspActionPerformed
        // TODO add your handling code here:
        String NumeroEmp;
        NumeroEmp=JOptionPane.showInputDialog("deme el numero de Empleado")+"";
        try{
            verificar(NumeroEmp);
            PDF.PDFindividuales(NumeroEmp);
        }catch(Excepciones err){
            err.getLocalizeMessage();
        }
    }//GEN-LAST:event_PDFEspActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new EliminarAsignacionPac(con).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        new EditarAsignacionPac(con).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnVerListaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerListaPActionPerformed
        // TODO add your handling code here:
        new ConsultaEstado(con).setVisible(true);
    }//GEN-LAST:event_btnVerListaPActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // TODO add your han
        Excel.Arranque();
    }//GEN-LAST:event_btnExcelActionPerformed
   
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AsignarPaquetes;
    private javax.swing.JMenuItem PDFEsp;
    private javax.swing.JMenuItem btnAgregarEmpleado;
    private javax.swing.JMenuItem btnBuscaID;
    private javax.swing.JMenuItem btnEditarEmpleado;
    private javax.swing.JMenuItem btnEliminarEmpleado;
    private javax.swing.JMenuItem btnEmpleadosG;
    private javax.swing.JMenuItem btnExcel;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JMenuItem btnVerListaP;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFoto;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends javax.swing.JPanel{
        private java.awt.Image imagen;
        @Override
        public void paint(java.awt.Graphics g){
            imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/Portada.jpg")).getImage();
            
            g.drawImage(imagen, 0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

}