package org.agalma.services.printing;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

public class PrintingUtils {

    public static void printingPageDialog() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.pageDialog(pj.defaultPage());
    }

}
