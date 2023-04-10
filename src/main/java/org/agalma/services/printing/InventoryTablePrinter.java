package org.agalma.services.printing;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InventoryTablePrinter implements Printable {

    private String filePath;
    private String[][] inventoryTable;
    private final int LINES_PER_PAGE = 26;

    public InventoryTablePrinter(String filePath) {
        this.filePath = filePath;
    }

    public InventoryTablePrinter(String[][] inventoryTable) {
        this.inventoryTable = inventoryTable;
    }


    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int numPages = calculateNumPages(); // calculate the total number of pages to print

        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        if (filePath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                int y = 100;
                while ((line = reader.readLine()) != null) {
                    g2d.drawString(line, 100, y);
                    y += 20;
                }
                reader.close();
            } catch (IOException ex) {
                // Handle the exception
            }
        } else if (inventoryTable != null) {
            int x = 100;
            int y = 100;
            for (int i = 0; i < inventoryTable.length; i++) {
                for (int j = 0; j < inventoryTable[i].length; j++) {
                    g2d.drawString(inventoryTable[i][j], x, y);
                    x += 100;
                }
                y += 20;
                x = 100;
            }
        }

        return Printable.PAGE_EXISTS;
    }

    private int calculateNumPages() {
        return 0;
    }


    public void print() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                // Handle the exception
            }
        }
    }
}
