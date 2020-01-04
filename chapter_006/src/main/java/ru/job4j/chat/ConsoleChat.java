package ru.job4j.chat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    public void chat() throws IOException {
        List<String> phrases = getPhrases();
        File log = new File(".\\chapter_006\\data\\logger.txt");
        List<String> logger = new ArrayList<>();
        boolean chat = true;
        boolean stop = false;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (chat) {
                String str = reader.readLine();
                logger.add("Пользователь ввел: \n");
                logger.add(str);
                logger.add("\n");
                if (str.equals("stop")) {
                    System.out.println("Chat on stop \n");
                    logger.add(" Chat on stop \n");
                    stop = true;
                } else if (str.equals("exit")) {
                    System.out.println("Bye! \n");
                    logger.add(" Bye! \n");
                    chat = false;
                } else if (str.equals("continue")) {
                    System.out.println("Chat is available again! \n");
                    logger.add("Chat is available again! \n");
                    stop = false;
                } else if (!stop) {
                    String answer = answer(phrases);
                    System.out.println(answer + "\n");
                    logger.add(answer);
                    logger.add("\n");
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

    private List<String> getPhrases() throws IOException {
        List<String> listPhrases = new ArrayList<>();
        String phrases = ".\\chapter_006\\data\\phrases.txt";
        BufferedReader br = new BufferedReader(new FileReader(phrases));
        while (br.ready()) {
            listPhrases.add(br.readLine());
        }
        return listPhrases;
    }

    private String answer(List<String> phrases) {
       return phrases.get((int) (Math.random() * phrases.size()));
    }
}
