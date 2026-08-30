package server;

import gui.ChatPanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    public Server(int port)  {
        this.port = port;

    }
    public void start()
    {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started....");

//            BufferedReader in = new BufferedReader(new InputStreamReader(server.accept().getInputStream()));
//            String message = in.readLine();
//            System.out.println("Message from client: " + message);

            System.out.println("waiting for clients");
            acceptRequests(server);
        } catch (IOException e) {
        }
    }

    //server thread
    private void acceptRequests(ServerSocket serverSocket)
    {
        while (true) {

            Socket socket = serverSocket.accept();

            Thread.startVirtualThread(() -> {
                handleClient(socket);
            });
        }
    }
}
