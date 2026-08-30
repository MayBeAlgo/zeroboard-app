package gui;

import client.ClientNetwork;
import commons.ChatMessage;
import commons.ClientStatus;
import commons.NetworkConfig;
import commons.Role;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConnectionPanel extends JPanel{

    private final JTextField ipField;
    private final JTextField portField;
    private final JTextField usernameField;

    private JButton connectButton;
    private JButton changeNameButton;
    private final JLabel connectionStatus;

    private final DefaultListModel<String> usersModel;
    private final JList<String> usersList;
    private  String ip;
    private  String portNum ;
    private  String username;

    private ClientNetwork client;
    private Role role;

    public ConnectionPanel(ClientNetwork client,Role role) {

        this.client = client;
        this.role = role;

        setPreferredSize(new Dimension(220, 0));

        setBackground(new Color(35, 35, 35));

        setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        // TITLE

        JLabel title = new JLabel("CONNECTION");

        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 14));

        add(title);

        add(Box.createVerticalStrut(20));


        // SERVER IP

        add(createLabel("Server IP"));

        ipField = new JTextField(ip);

        add(ipField);

        add(Box.createVerticalStrut(10));


        // PORT

        add(createLabel("Port"));

        portField = new JTextField(portNum);

        add(portField);

        add(Box.createVerticalStrut(10));


        // USERNAME

        add(createLabel("Username"));

        usernameField = new JTextField();

        add(usernameField);

        add(Box.createVerticalStrut(15));


        // CONNECT BUTTON & CHANGE NAME BUTTON

        if(role == Role.HOST)
        {
            ipField.setText("localhost");
            portField.setText(String.valueOf(NetworkConfig.PORT));
        }
            connectButton = new JButton("Connect");

            connectButton.setAlignmentX(Component.LEFT_ALIGNMENT);

            connectButton.addActionListener(e -> {
                connectUser();
            });
            add(connectButton);


        add(Box.createVerticalStrut(15));


        // STATUS

        connectionStatus = new JLabel("● Disconnected");

        connectionStatus.setForeground(new Color(220, 80, 80));

        add(connectionStatus);

        add(Box.createVerticalStrut(25));


        // USERS

        JLabel usersTitle = new JLabel("CONNECTED USERS");

        usersTitle.setForeground(Color.WHITE);
        usersTitle.setFont(new Font("SansSerif", Font.BOLD, 12));

        add(usersTitle);

        add(Box.createVerticalStrut(8));

        usersModel = new DefaultListModel<>();

        usersList = new JList<>(usersModel);

        usersList.setBackground(new Color(45, 45, 45));
        usersList.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(usersList);

        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(scrollPane);

    }

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setForeground(
                new Color(180, 180, 180)
        );

        label.setFont(
                new Font("SansSerif", Font.PLAIN, 12)
        );

        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        return label;
    }

    //CONNECTION LOGIC
    private void connectUser()
    {

        if(client.getClientStatus()!= ClientStatus.CONNECTED) {
            ip = ipField.getText();
            portNum = portField.getText();
            username = usernameField.getText();

            //Client is connected now
            client.connect(ip, portNum, username);
            if(role == Role.HOST)
            {
                usersModel.addElement(client.getUsername()+"[HOST]");
            }
            else {
                usersModel.addElement(client.getUsername());
            }

            connectButton.setEnabled(false);
        }
    }
    //HOST NAME CHANGE
    private void changeHostName()
    {
        username = usernameField.getText();
        usersModel.set(0,username+"[HOST]");
    }
}
