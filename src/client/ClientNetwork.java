package client;

import commons.ClientStatus;
import commons.NetworkListener;

import java.io.*;
import java.net.Socket;

public class ClientNetwork {

    private Socket socket;

    private String ip;
    private String port;
    private String username;

    private BufferedReader in;
    private PrintWriter out;

    private ClientStatus clientStatus;

    private ConnectionListener connectionListener;
    private NetworkListener networkListener;

    // ---------------- CONNECTION LISTENER ----------------


    public interface ConnectionListener {

        void onConnected();
        void onDisconnected();
    }

    public void setConnectionListener(ConnectionListener listener) {
        this.connectionListener = listener;
    }

    public void setNetworkListener(NetworkListener networkListener)
    {
        this.networkListener = networkListener;
    }

    // ---------------- CONNECT ----------------

    public void connect(String ip, String port, String username) {

        this.ip = ip;
        this.port = port;
        this.username = username;

        try {

            if (socket != null && !socket.isClosed()) {
                return; // already connected
            }

            socket = new Socket(ip, Integer.parseInt(port));

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Connected to " + ip + ":" + port);

            if (connectionListener != null) {
                connectionListener.onConnected();
            }

            startReceiver();

        } catch (IOException e) {

            if (connectionListener != null) {
                connectionListener.onDisconnected();
            }

            System.out.println("Connection failed: " + e.getMessage());
        }
    }


    // ---------------- SEND ----------------

    //SEND THE MESSAGE TO SERVER
    public void send(String message) {

        if (out != null) {
            out.println(message);
        }
    }


    // ---------------- RECEIVE ----------------

    //START A RECIEVER THREAD FOR EACH CLIENT
    private void startReceiver() {

        Thread.startVirtualThread(() -> {

            try {

                String message;

                while ((message = in.readLine()) != null) {

                    System.out.println("From server: " + message);

                    networkListener.onMessageRecieved(message);

                }

            } catch (IOException e) {

                System.out.println("Disconnected from server.");

                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        });
    }


    // ---------------- DISCONNECT ----------------

    public void disconnect() {

        try {

            if (socket != null) {
                socket.close();
            }

        } catch (IOException ignored) {
        }
    }


    // ---------------- GETTERS / SETTERS ----------------

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }
}