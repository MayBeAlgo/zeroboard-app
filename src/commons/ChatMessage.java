package commons;

public class ChatMessage {
    private static String systemConnectedMessage = "[System] Connected to server ";
    private static String systemDisconnectedMessage = "[System] Disconnected from server";
    private String sentMessage;

    public static String getSystemConnectedMessage()
    {
        return systemConnectedMessage;
    }
    public static String getSystemDisconnectedMessage()
    {
        return systemDisconnectedMessage;
    }
    public void setSentMessage(String sentMessage)
    {
        this.sentMessage=sentMessage;
    }
    public String getSentMessage()
    {
        return sentMessage;
    }
}
