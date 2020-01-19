package ru.job4j.archiver;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {
    public List<File> seekBy(String root, String exist) {
        List<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        File path = new File(root);
        queue.add(path);
        while (queue.size() > 0) {
            File[] fileList = queue.poll().listFiles();
            assert fileList != null;
            for (File f : fileList) {
                if (f.isDirectory() && f.canRead() && f.canWrite()) {
                    result.add(f);
                    queue.add(f);
                } else {
                    result.addAll(checkExts(exist, f));
                }
            }
        }
        return result;
    }

    private List<File> checkExts(String exist, File f) {
        List<File> res = new ArrayList<>();
        if (!f.getName().endsWith("." + exist)) {
            res.add(f);
        }
        return res;
    }

    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Archive archive = new Archive();
        List<File> sources = archive.seekBy("./", ".xml");
        File target = new File("../ziparch.zip");
        archive.pack(sources, target);
    }

}
