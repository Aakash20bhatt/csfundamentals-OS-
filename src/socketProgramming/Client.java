package socketProgramming;

import java.io.*;
import java.net.*;

public class Client {
    private static Socket socket = null;
    private static DataInputStream input = null;
    private static DataOutputStream out = null;

    // constructor to put ip address and port

    public static void main(String args[])
    {
        // establish a connection
        String address = "127.0.0.1";
        int port = 9000;
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(
                    socket.getOutputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Done")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }
}
