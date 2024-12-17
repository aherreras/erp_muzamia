/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp_muzamia.ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 *
 * @author User
 */
public class BillPrintable implements Printable {

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int result = NO_SUCH_PAGE;

        if (pageIndex == 0) {

            Graphics2D g2d = (Graphics2D) graphics;
            double width = pageFormat.getImageableWidth();
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            try {
                int y = 20;
                int yShift = 10;

                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawString("-".repeat(32), 12, y);
                y += yShift;
                g2d.drawString(" ".repeat(13) + "Prueba" + " ".repeat(13), 12, y);
                y += yShift;
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = PAGE_EXISTS;
        }
        return result;
    }
}
