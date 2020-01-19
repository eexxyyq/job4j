package ru.job4j.chat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ConsoleChat {
    private Map<String, Supplier<Boolean>> acts = new HashMap<>();
    private List<String> phrases = getPhrases();
    private File log = new File("./chapter_006/data/logger.txt");
    private List<String> logger = new ArrayList<>();
    private boolean chat = true;
    private boolean stop = false;

    public ConsoleChat() {
        this.acts.put("exit", this::exitMethod);
        this.acts.put("stop", this::stopMethod);
    }

    public void chat() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (chat) {
                String str = reader.readLine();
                loggerInit(str);
                if (!this.stop) {
                    acts.getOrDefault(str, this::answerMethod).get();
                } else if (str.equals("continue")) {
                    continueMethod();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(log), StandardCharsets.UTF_8))) {
            logger.forEach(string -> {
                try {
                    out.write(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<String> getPhrases() {
        List<String> listPhrases = new ArrayList<>();
        String phrases = "./chapter_006/data/phrases.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(phrases))) {
            while (br.ready()) {
                listPhrases.add(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPhrases;
    }

    private String getAnswer(List<String> phrases) {
        return phrases.get((int) (Math.random() * phrases.size()));
    }

    private void loggerInit(String str) {
        toLogger("Пользователь ввел: " + str);
    }

    private boolean stopMethod() {
        String stop = "Chat is stopped!";
        System.out.println(stop);
        toLogger("Ответ: " + stop);
        this.stop = true;
        return true;
    }

    private boolean exitMethod() {
        String bye = "Bye!";
        System.out.println(bye);
        toLogger("Ответ: " + bye);
        toLogger("chat isn't run");
        this.chat = false;
        return true;
    }

    private void continueMethod() {
        String str = "Chat is available again!";
        System.out.println(str);
        toLogger("Ответ: " + str);
        stop = false;
    }

    private boolean answerMethod() {
        String answer = getAnswer(phrases);
        System.out.println(answer);
        toLogger("Ответ: " + answer);
        return true;
    }

    private void toLogger(String log) {
        this.logger.add(log);
        this.logger.add(System.lineSeparator());
    }

}
