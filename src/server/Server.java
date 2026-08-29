package server;

import gui.ChatPanel;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    ChatPanel chatPanel;
    public Server(ChatPanel chatPanel)  {
        try {
  
            this.chatPanel = chatPanel;
           
            ServerSocket server = new ServerSocket(6000);

            System.out.println("Server started....");
            chatPanel.setSystemServerStatusMssg("Server is waiting for clients.....");


        } catch (IOException e) {
        }
    }
}
