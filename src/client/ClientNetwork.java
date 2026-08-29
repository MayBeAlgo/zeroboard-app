package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLOutput;

public class ClientNetwork{

    private Socket socket;

    private String ip;
    private String port;
    private String username;

    public void connect(String ip, String port,String username) {
        this.ip = ip;
        this.port = port;
        this.username = username;


        System.out.println(getIp());
        System.out.println(getPort());
        System.out.println(getUsername());

        try {


            socket = new Socket(getIp(), Integer.parseInt(getPort()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("client connected to server");

            //client.close();
        } catch (IOException e) {
           // throw new RuntimeException(e);
        }
        }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
