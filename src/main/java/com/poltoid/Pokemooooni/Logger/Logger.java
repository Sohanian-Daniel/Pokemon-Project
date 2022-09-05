package com.poltoid.Pokemooooni.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    boolean toFile = false;
    private File file;
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if(instance == null) instance = new Logger();
        return instance;
    }

    public void logToFile(String pathname) {
        toFile = true;
        file = new File(pathname);
    }

    public void logToStdOut() {
        toFile = false;
    }

    public void log(String s) {
        if(toFile) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(s + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println(s);
    }
}
