package ru.job4j.oracle.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ConsoleIO implements InputOutput {
    private BufferedReader reader;
    private PrintStream stream;

    public ConsoleIO(BufferedReader reader, PrintStream stream) {
        this.reader = reader;
        this.stream = stream;
    }

    @Override
    public String read() {
        String result = "";
        try {
            result = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void println(String msg) {
        this.stream.println(msg);
    }

    @Override
    public void print(String msg) {
        this.stream.print(msg);
    }
}
