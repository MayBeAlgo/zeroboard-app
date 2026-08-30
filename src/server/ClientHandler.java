package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;
    private final Server server;

    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket, Server server) {

        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            while ((message = in.readLine()) != null) {

                System.out.println("Received: " + message);

                server.broadcast(message, this);
            }

        } catch (IOException e) {

            System.out.println("Connection lost: " + socket.getInetAddress());

        } finally {

            //IF ANYTHING GOES WRONG DISCONNET THE CLIENT AND CLOSE THE SOCKET
            server.removeClient(this);

            try {
                socket.close();
            }
            catch (IOException ignored) {
            }
        }
    }

    //send the data to all the clients
    public synchronized void send(String message) {

        if (out != null) {
            out.println(message);
        }
    }
}