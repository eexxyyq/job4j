package ru.job4j.archiver;

public class Args {
    private String directory;
    private String exclude;
    private String output;

    public Args(String directory, String exclude, String output) {
        this.directory = directory;
        this.exclude = exclude;
        this.output = output;
    }
}
