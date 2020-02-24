package ru.job4j.oracle.client;

import ru.job4j.oracle.tools.ConsoleIO;
import ru.job4j.oracle.tools.InputOutput;
import ru.job4j.oracle.tools.LogWriter;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class OracleClient {
    private final static String EXIT = "bye!";
    private int serverPort = 5050;
    private String host = "localhost";
    private InputOutput io;
    private final StringBuilder logger = new StringBuilder();
    private String logFileName;
    private DataInputStream input;
    private DataOutputStream output;

    public OracleClient(InputOutput io, String logFileName) {
        this.io = io;
        this.logFileName = logFileName;
    }

    public boolean initConnection() {
        boolean result;
        try {
            System.out.println("Trying to connect..");
            InetAddress address = InetAddress.getByName(host);
            Socket socket = new Socket(address, serverPort);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connection reached. You can talk with Oracle");
            result = true;
        } catch (IOException e) {
            System.out.println("Connection failed..");
            result = false;
            e.printStackTrace();

        }
        return result;
    }

    public void exchange() {
        String received;
        String send;
        String separator = System.getProperty("line.separator");
        this.io.print("user: ");
        try {
            do {
                send = this.io.read();
                logger.append(String.format("user: %s%s", send, separator));
                this.output.writeUTF(send);
                received = input.readUTF();
                this.io.println(received);
                logger.append(String.format("%s%s", received, separator));
                this.io.print("user: ");
            } while (!EXIT.equalsIgnoreCase(send));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            LogWriter logWriter = new LogWriter(this.logFileName);
            logWriter.write(logger.toString());
        }
    }

    public static void main(String[] args) {
        OracleClient client = new OracleClient(new ConsoleIO(new BufferedReader(new InputStreamReader(System.in)), System.out), "userlog.txt");
        client.initConnection();
        client.exchange();
    }
}
