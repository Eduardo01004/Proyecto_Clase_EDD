/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Cubo.Nodo;
import Cubo.Nodo_EjeZ;
import Lista_Simple.Nodo_Simple;
import Metodos.Metodos_Funciones;
import Metodos.Singleton;
import Pila.NodoPila;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
/**
 *
 * @author Eduardo
 */
public class Factura extends javax.swing.JFrame {

    /**
     * Creates new form Factura
     */
    byte[] imagen;
    File archivo;
    double total =0;
    double suma = 0;
    Metodos_Funciones gestion = new Metodos_Funciones();
    Singleton single;
    public Factura() {
        initComponents();
        setLocationRelativeTo(null);
        Cargar_Users();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CB_cliente = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_imagen = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturas");

        jPanel1.setBackground(new java.awt.Color(249, 105, 14));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturas");

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");

        jButton1.setBackground(new java.awt.Color(77, 19, 209));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Facturar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lbl_imagen);

        jButton2.setBackground(new java.awt.Color(217, 30, 24));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(CB_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 124, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CB_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Nodo_EjeZ aux = single.fecha.Buscar(Metodos.Singleton.getDate());
        if (aux != null){
            Nodo temp =aux.matriz.Buscar(CB_cliente.getSelectedItem().toString(),Metodos.Singleton.getCliente());
            if (temp != null){
                temp.pila.Graficar(CB_cliente.getSelectedItem().toString(),Metodos.Singleton.getCliente());
                archivo = new File("Factura.png");
                imagen = gestion.Imagen(archivo);
                lbl_imagen.setIcon(new ImageIcon(imagen));
                Generar_Factura(CB_cliente.getSelectedItem().toString(),Metodos.Singleton.getCliente());
                JOptionPane.showMessageDialog(null, "Factura Realizada con Exito");
            }else{
                JOptionPane.showMessageDialog(null, "Ese usuario no ha realizado ventas");
            }
        }else{
            JOptionPane.showMessageDialog(null, "La Fecha no existe");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void Cargar_Users(){
        Nodo_Simple aux = single.users.primero;
        while (aux != null){
            CB_cliente.addItem(aux.getUser());
            aux = aux.getSiguiente();
        }
    }
    
    
    public void Generar_Factura(String usuario,String Cliente){
        try{
            double as =0;
            total = 0;
            Document documento= new Document(PageSize.A4,35,30,50,50);
            FileOutputStream fileoutputstream= new FileOutputStream(Cliente+"Factura.pdf");
            PdfWriter.getInstance(documento,fileoutputstream);
            documento.open();
            BufferedReader br = null;
            //Font para titulos
            Font fonTitulos=FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Font.BOLD,BaseColor.BLACK);
            Font Tituloprin=FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Font.BOLD,BaseColor.BLACK);

            //Crear Tabla
            PdfPTable pdftable= new PdfPTable(4);

            //Titulo Principañ
            Paragraph paragraph= new Paragraph();
            paragraph.add(new Phrase("Factura",Tituloprin));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            pdftable.addCell(new Paragraph("Productos",fonTitulos));
            pdftable.addCell(new Paragraph("Cantidad",fonTitulos));
            pdftable.addCell(new Paragraph("Precio",fonTitulos));
            pdftable.addCell(new Paragraph("Total",fonTitulos));

            //Obtener datos
            Nodo_EjeZ aux = single.fecha.Buscar(Metodos.Singleton.getDate());
        if (aux != null){
            Nodo temp =aux.matriz.Buscar(CB_cliente.getSelectedItem().toString(),Metodos.Singleton.getCliente());
            if (temp != null){
                NodoPila a = temp.pila.primero;
                while(a != null){
                    suma = a.getCantidad()*a.getPrecio();
                    total=total+suma;
                    pdftable.addCell(a.getProducto());
                    pdftable.addCell(String.valueOf(a.getCantidad()) );
                    pdftable.addCell(String.valueOf(a.getPrecio()) );
                    pdftable.addCell(String.valueOf(total) );
                    a = a.getSiguiente();
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Ese usuario no ha realizado ventas");
            }
        }else{
            JOptionPane.showMessageDialog(null, "La Fecha no existe");
        }   
            paragraph.add(new Phrase("Realizado por : "+usuario,Tituloprin));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase("Comprado por : "+Cliente,Tituloprin));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase("Total: "+total,Tituloprin));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            documento.add(paragraph);
            documento.add(pdftable);
            
            documento.close();
            File file= new File(Cliente+"Factura.pdf");
            Desktop.getDesktop().open(file);
            }catch(Exception a){}
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_imagen;
    // End of variables declaration//GEN-END:variables
}
