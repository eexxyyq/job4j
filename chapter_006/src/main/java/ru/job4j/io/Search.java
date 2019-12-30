package ru.job4j.io;

import java.io.File;
import java.util.*;

public class Search {
    List<File> files(String parent, List<String> exist) {
        List<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File path = new File(parent);
        queue.add(path);
        while (queue.size() > 0) {
            File[] fileList = queue.poll().listFiles();
            assert fileList != null;
            for (File f : fileList) {
                if (f.isDirectory()) {
                    queue.add(f);
                } else {
                    for (String s : exist) {
                        if (f.getName().endsWith("." + s)) {
                            result.add(f);
                        }
                    }
                }
            }
        }
        return result;
    }
}