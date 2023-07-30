package org.agalma.services.printing;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;


// @TODO: Implement this class
public class StringPrintable implements Printable {

    private String text;

    public StringPrintable(String text) {
        this.text = text;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex != 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        Font font = new Font("Serif", Font.PLAIN, 12);
        graphics2D.setFont(font);

        graphics2D.drawString(text, 0, 0);

        return PAGE_EXISTS;
    }
}
