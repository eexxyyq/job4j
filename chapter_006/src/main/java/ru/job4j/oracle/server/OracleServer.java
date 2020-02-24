package ru.job4j.oracle.server;

import ru.job4j.oracle.tools.LogWriter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class OracleServer {
    private final static String EXIT = "bye!";
    private final static String HELLO = "hello!";
    private final static String WISDOM = "share";
    private final static Random RN = new Random();
    private final int port = 5050;
    private final StringBuilder log = new StringBuilder();
    private List<String> messages;
    private String chatFileName;
    private String logFileName;
    private DataInputStream input;
    private DataOutputStream output;

    public OracleServer(String chatFileName, String logFileName) {
        this.chatFileName = chatFileName;
        this.logFileName = logFileName;
    }

    public boolean init() {
        boolean result;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Оракл ожидает гостя...");
            this.messages = Files.readAllLines(Paths.get(this.chatFileName), StandardCharsets.UTF_8);
            Socket socket = serverSocket.accept();
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            result = true;
            System.out.println("Гость пришел...");
        } catch (IOException ioe) {
            result = false;
            System.out.println("Что-то пошло не так...");
            ioe.printStackTrace();
        }
        return result;
    }

    public void exchange() {
        String received;
        String send;
        String separator = System.getProperty("line.separator");
        try {
            do {
                received = this.input.readUTF();
                log.append(String.format("user: %s%s", received, separator));
                if (received.equalsIgnoreCase(HELLO)) {
                    send = "Приветствую тебя мой друг, я Оракл.";
                    log.append(String.format("oracle: %s%s", send, separator));
                    output.writeUTF(String.format("oracle: %s", send));
                } else if (received.contains(WISDOM)) {
                    send = messages.get(RN.nextInt(messages.size()));
                    log.append(String.format("oracle: %s%s", send, separator));
                    output.writeUTF(String.format("oracle: %s", send));
                } else if (!received.equalsIgnoreCase(EXIT)) {
                    send = "Я не понимаю тебя, друг мой, возможно нам стоит попрощаться.";
                    log.append(String.format("oracle: %s%s", send, separator));
                    output.writeUTF(String.format("oracle: %s", send));
                }
            } while (!EXIT.equalsIgnoreCase(received));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            LogWriter logWriter = new LogWriter(this.logFileName);
            logWriter.write(log.toString());
        }
    }

    public static void main(String[] args) {
        OracleServer server = new OracleServer("./chapter_006/data/wisdom.txt", "./chapter_006/data/wisdomLog.txt");
        server.init();
        server.exchange();
    }
}
