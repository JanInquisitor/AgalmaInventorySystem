package org.agalma.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class Threads extends Thread {
    private String parameter;

    public Threads(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void run() {
        while (!"exit".equals(parameter)) {
            System.out.println((isDaemon() ? "daemon" : "  user") + " thread " + this.getName() + "(id=" + this.getId() + ") parameter: " + parameter);
            pauseOneSecond();
        }
        System.out.println((isDaemon() ? "daemon" : "  user") + " thread " + this.getName() + "(id=" + this.getId() + ") parameter: " + parameter);
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    private static void pauseOneSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runExtendedThreads() {
        Threads thr1 = new Threads("One");
        thr1.start();
        Threads thr2 = new Threads("Two");
        thr2.setDaemon(true);
        thr2.start();
        pauseOneSecond();
        thr1.setParameter("exit");
        pauseOneSecond();
        System.out.println("Main thread exists");
    }
}
