package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analyze {
    public void unavailable(String source, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
                String start = null;
                String x;
                while ((x = reader.readLine()) != null) {
                    if ((x.startsWith("400") || x.startsWith("500")) && start == null) {
                        start = x.split(" ")[1];
                    }
                    if ((x.startsWith("200") || x.startsWith("300")) && start != null) {
                        out.print(start);
                        out.print(" - ");
                        out.println(x.split(" ")[1]);
                        start = null;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
