package ec.edu.espe.managmentsystem.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JTable;

public class Printer implements Printable {

    private JTable table;

    public Printer(JTable table) {
        this.table = table;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Imprimir el contenido de la tabla
            table.print(graphics2d);

            return Printable.PAGE_EXISTS;
        } else {
            return Printable.NO_SUCH_PAGE;
        }
    }

    public void imprimir() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                // Manejar la excepción de impresión
                ex.printStackTrace();
            }
        }
    }
}
