package ru.job4j.oracle.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    private BufferedWriter writer;

    public LogWriter(String logFilePath) {
        File logFile = new File(logFilePath);
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            this.writer = new BufferedWriter(new FileWriter(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String msg) {
        try {
            writer.write(msg);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
