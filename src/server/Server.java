package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private final int port;

    private final Set<ClientHandler> clientList = ConcurrentHashMap.newKeySet();

    public Server(int port) {
        this.port = port;
    }

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server started on port " + port);
            System.out.println("Waiting for clients...");

            //ACCEPT ALL INCOMING CLIENT REQUESTS
            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("Client connected: " + socket.getInetAddress());

                ClientHandler handler = new ClientHandler(socket, this);

                clientList.add(handler);

                //START NEW THREAD FOR EACH CLIENT
                Thread.startVirtualThread(handler);
            }

        } catch (IOException e) {

            System.out.println("Server stopped: " + e.getMessage());
        }
    }

    //BROADCAST RECIEVED MESSAGE TO ALL THE CLIENTS
    public void broadcast(String message, ClientHandler sender) {

        for (ClientHandler client : clientList) {

            //SYNCHRONIZED
            client.send(message);
        }
    }

    public void removeClient(ClientHandler client) {

        clientList.remove(client);

        System.out.println("Client disconnected. Active clients: " + clientList.size());
    }
}