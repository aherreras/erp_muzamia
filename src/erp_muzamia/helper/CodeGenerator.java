/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.helper;

import erp_muzamia.dto.DetalleOperacion;
import erp_muzamia.dto.Operaciones;
import java.util.List;

/**
 *
 * @author User
 */
public class CodeGenerator {

    String strDateTime;
    List<DetalleOperacion> list;
    Operaciones operacion;
    
    public CodeGenerator(String strDateTime, List<DetalleOperacion> list, Operaciones operacion) {
        this.strDateTime = strDateTime;
        this.list = list;
        this.operacion = operacion;
    }
    
    public String boleta () {
        StringBuilder header = new StringBuilder();
        StringBuilder body = new StringBuilder();
        StringBuilder footer = new StringBuilder();

        header.append("\n".repeat(5))
                .append("   MORENO FELIX EDITH SOLEDAD   \n")
                .append(" ".repeat(12) + "MUZAMIA" + "\n")
                .append(" ".repeat(8) + "RUC 10712306390" + "\n")
                .append(" ".repeat(3) + "AV. ARNALDO MARQUEZ 1216," + "\n")
                .append(" ".repeat(3) + "JESUS MARIA, JESUS MARIA," + "\n")
                .append(" ".repeat(11) + "LIMA,LIMA" + "\n")
                .append(" Email: emorenofelix@gmail.com \n\n")
                .append("  BOLETA DE VENTA ELECTRONICA  \n\n")
                .append(" ".repeat(9) + "B001-00000023" + "\n\n")
                .append(" ".repeat(4) + "Fecha y hora de Emisión:" + "\n")
                .append(" ".repeat(6) + strDateTime + "\n\n")
                .append("-".repeat(32) + "\n");

        body.append("SERVICIO" + " ".repeat(5))
                .append("P.U." + " ")
                .append("CNT" + " ")
                .append("DESC" + " ")
                .append("TOTAL\n")                
                .append("-".repeat(32) + "\n");

        int n = 0;

        for (DetalleOperacion det : list) {
//            int len = det.getDope_s_p().length();
//            
//            body.append(det.getDope_s_p())
//                    .append(" ")
//                    .append(det.getDope_precio().toString())
//                    .append(" ")
//                    .append(det.getDope_cantidad().toString())
//                    .append(" ")
//                    .append(det.getDope_descuento().toString())
//                    .append(" ")
//                    .append(det.getDope_total().toString() + "\n");
        }

        footer.append("-".repeat(32) + "\n")
                .append("TOTAL A PAGAR")
                .append(" ".repeat(14))
                .append(operacion.getOper_monto() + "\n")
                .append("-".repeat(32))
                .append("\n".repeat(5));
        
        return header.toString() + body.toString() + footer.toString();
    }
}
