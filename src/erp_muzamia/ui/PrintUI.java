/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package erp_muzamia.ui;

import erp_muzamia.dto.DetalleOperacion;
import erp_muzamia.dto.Operaciones;
import erp_muzamia.helper.CodeGenerator;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLWriter;

/**
 *
 * @author User
 */
public class PrintUI extends javax.swing.JFrame {

    Operaciones operacion;
    List<DetalleOperacion> list;

    /**
     * Creates new form PrintUI
     */
    public PrintUI() {
        initComponents();
    }

    public PrintUI(Operaciones operacion, List<DetalleOperacion> list) {
        initComponents();
        this.operacion = operacion;
        this.list = list;
        printDetalle();
    }

    public String lstVenta() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>")
                .append("<tr>")
                .append("<td colspan=7>")
                .append("-".repeat(80))
                .append("</td>")
                .append("</tr>");

        sb.append("<tr>")
                .append("<td>")
                .append("N°")
                .append("</td>")
                .append("<td>")
                .append("DESC")
                .append("</td>")
                .append("<td>")
                .append("P.U.")
                .append("</td>")
                .append("<td>")
                .append("CNT")
                .append("</td>")
                .append("<td>")
                .append("SUBTOT")
                .append("</td>")
                .append("<td>")
                .append("DESC")
                .append("</td>")
                .append("<td>")
                .append("TOTAL")
                .append("</td>")
                .append("</tr>");

        for (DetalleOperacion det : list) {
            sb.append("<tr>")
                    .append("<td>")
                    .append(det.getDope_id())
                    .append("</td>")
                    .append("<td>")
//                    .append(det.getDope_s_p())
                    .append("</td>")
                    .append("<td>")
                    .append("S/. " + det.getDope_precio())
                    .append("</td>")
                    .append("<td>")
                    .append(det.getDope_cantidad())
                    .append("</td>")
                    .append("<td>")
                    .append("S/. " + det.getDope_subtotal())
                    .append("</td>")
                    .append("<td>")
                    .append("S/. " + det.getDope_descuento())
                    .append("</td>")
                    .append("<td>")
                    .append("S/. " + det.getDope_total())
                    .append("</td>")
                    .append("</tr>");
        }

        sb.append("<tr>")
                .append("<td colspan=7>")
                .append("-".repeat(80))
                .append("</td>")
                .append("</tr>");

        sb.append("<tr>")
                .append("<td colspan=6>")
                .append("TOTAL A PAGAR")
                .append("</td>")
                .append("<td>")
                .append("S/. " + operacion.getOper_monto())
                .append("</td>")
                .append("</tr>");

        sb.append("<tr>")
                .append("<td colspan=7>")
                .append("-".repeat(80))
                .append("</td>")
                .append("</tr>")
                .append("</table>");

        return sb.toString();
    }

    public void printDetalle() {
        StringBuilder msg = new StringBuilder();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = classLoader.getResource("erp_muzamia/ui/imgs/Logo.jpg").getPath();

        msg.append("<center>")
                .append("<tr>")
                .append("<td>")
                .append("<center><img src='file:" + path + "' width='180' height='180'/></center>")
                .append("</td>")
                .append("</tr>")
                .append("<tr>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append("<center>MORENO FELIX EDITH SOLEDAD</center>")
                .append("</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append("<center>MUZAMIA</center>")
                .append("</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append("<center>RUC 10712306390</center>")
                .append("</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append("<center>AV. ARNALDO MARQUEZ 1216,</center>")
                .append("</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append("<center>JESÚS MARÍA, JESÚS MARÍA, LIMA</center>")
                .append("</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append("<center>LIMA</center>")
                .append("</td>")
                .append("</tr>")
                // email
                .append("<tr>")
                .append("<td>")
                .append("<center>Email: emorenofelix@gmail.com</center>")
                .append("</td>")
                .append("</tr>")
                // datos boleta
                .append("<tr>")
                .append("<td>")
                .append("<center><h3>BOLETA DE VENTA ELECTRONICA</h3></center>")
                .append("</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>")
                .append("<center><h3>B001-00000023</h3></center>")
                .append("</td>")
                .append("</tr>")
                // ********* fecha de emisión
                .append("<tr>")
                .append("<td>")
                .append("<center>Fecha y hora Emisión: 2023-04-25 09:17:30</center>")
                .append("</td>")
                .append("</tr>");

        // ********* detalle
        msg.append("<tr>")
                .append("<td><center>");

        msg.append(lstVenta());

        msg.append("</center></td>")
                .append("</tr>");

        // ********* dni
        msg.append("<tr>")
                .append("<td colspan=7>")
                .append("SON: ")
                .append("</td>")
                .append("</tr>")
                .append("</center>");

        jepBoleta.setContentType("text/html");
        jepBoleta.setText(msg.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jepBoleta = new javax.swing.JEditorPane();
        jbImprimir = new javax.swing.JButton();
        jbTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOLETA");

        jepBoleta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane4.setViewportView(jepBoleta);

        jbImprimir.setBackground(new java.awt.Color(0, 0, 255));
        jbImprimir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbImprimir.setForeground(new java.awt.Color(240, 240, 240));
        jbImprimir.setText("Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jbTerminar.setBackground(new java.awt.Color(102, 0, 102));
        jbTerminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbTerminar.setText("Terminar");
        jbTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private PrintService findPrintService(String printerName, PrintService[] services) {
        for (PrintService service : services) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }
        return null;
    }

    protected double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected double toPPI(double inch) {
        return inch * 72d;
    }

    Double bHeight = 0.0;

    public PageFormat getPageFormat(PrinterJob pj) {
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double bodyHeight = bHeight;
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height = cm_to_pp(1));

        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);

        return pf;
    }

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        CodeGenerator cg = new CodeGenerator("12-10-2024", list, operacion);
        

//        MessageFormat header = new MessageFormat("Muzamia");
//        MessageFormat footer = new MessageFormat("Page");
//        
//        PrinterJob job = PrinterJob.getPrinterJob();
//        Printable painter = jepBoleta.getPrintable(header, footer);
//        job.setPrintable(painter);
//        boolean ok = job.printDialog();
//
//        if (ok) {
//            try {
//                job.print();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        

//        PrinterJob pj = PrinterJob.getPrinterJob();
//        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
//
//        try {
//            pj.print();
//        } catch (PrinterException e) {
//            e.printStackTrace();
//        }

        DocFlavor docFormat = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc document = new SimpleDoc(cg.boleta(), docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        DocPrintJob printJob = defaultPrintService.createPrintJob();
        try {
            printJob.print(document, attributeSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            jepBoleta.print(header, footer);
//        } catch (PrinterException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jbTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTerminarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbTerminarActionPerformed

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
            java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbTerminar;
    private javax.swing.JEditorPane jepBoleta;
    // End of variables declaration//GEN-END:variables
}
