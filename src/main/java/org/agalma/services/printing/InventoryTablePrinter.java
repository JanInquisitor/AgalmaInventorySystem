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
    private int[] pageBreaks;
    String[] textLines;


    public InventoryTablePrinter(String filePath) {
        this.filePath = filePath;
    }

    public InventoryTablePrinter(String[][] inventoryTable) {
        this.inventoryTable = inventoryTable;
    }

    private void initTextLines() {
        if (textLines == null) {
            int numLines = 200;
            textLines = new String[numLines];
            for (int i = 0; i < numLines; i++) {
                textLines[i] = "This is line number " + i;
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null) {
            initTextLines();
            int linesPerPage = (int) (pageFormat.getImageableHeight() / lineHeight);
            int numBreaks = (textLines.length - 1) / linesPerPage;
            pageBreaks = new int[numBreaks];
            for (int b = 0; b < numBreaks; b++) {
                pageBreaks[b] = (b + 1) * linesPerPage;
            }
        }

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        if (filePath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                int y = 100;
                int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
                int end = (pageIndex == pageBreaks.length)
                        ? textLines.length : pageBreaks[pageIndex];


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

    private int calculateHeightOfLine() {
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
