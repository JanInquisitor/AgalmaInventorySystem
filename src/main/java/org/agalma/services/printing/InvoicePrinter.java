package org.agalma.services.printing;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// @TODO: Implement this class
public class InvoicePrinter implements Printable {

    private String filePath;

    private String[][] invoiceTable;

    // This is method is used for both reference and for being the actual print method for invoices.
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int numPages = calculateNumPages(); // calculate the total number of pages to print
        if (pageIndex >= numPages) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // adjust the position of the graphics object based on the current page index
        int y = 100 + (pageIndex * 800); // move down 800 pixels for each additional page
        if (filePath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                    g2d.drawString(line, 100, y);
                    y += 20;
                    // check if we've reached the end of the current page
                    if (y >= 1000) { // assuming 1000 is the height of a page
                        break;
                    }
                }
                reader.close();
            } catch (IOException ex) {
                // Handle the exception
            }
        } else if (invoiceTable != null) {
            int x = 100;
            for (int i = 0; i < invoiceTable.length; i++) {
                for (int j = 0; j < invoiceTable[i].length; j++) {
                    g2d.drawString(invoiceTable[i][j], x, y);
                    x += 100;
                }
                y += 20;
                x = 100;
                // check if we've reached the end of the current page
                if (y >= 1000) { // assuming 1000 is the height of a page
                    break;
                }
            }
        }

        return PAGE_EXISTS;
    }

    private int calculateNumPages() {
        return 0;
    }


    public int print2(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int numPages = calculateNumPages(); // calculate the total number of pages to print

        if (pageIndex > numPages) {
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
        } else if (invoiceTable != null) {
            int x = 100;
            int y = 100;
            for (int i = 0; i < invoiceTable.length; i++) {
                for (int j = 0; j < invoiceTable[i].length; j++) {
                    g2d.drawString(invoiceTable[i][j], x, y);
                    x += 100;
                }
                y += 20;
                x = 100;
            }
        }

        return Printable.PAGE_EXISTS;
    }

}
