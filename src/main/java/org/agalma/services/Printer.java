package org.agalma.services;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Printer implements Printable {

    private String[][] inventoryTable;

    public Printer(String[][] inventoryTable) {
        this.inventoryTable = inventoryTable;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

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

        return Printable.PAGE_EXISTS;
    }

    public void printInventoryTable() {
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

