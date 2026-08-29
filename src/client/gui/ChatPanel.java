package client.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatPanel extends JPanel {

    private final JTextArea chatArea;
    private final JTextField messageField;

    public ChatPanel() {

        setPreferredSize(new Dimension(0, 130));

        setBackground(new Color(25, 25, 25));

        setBorder(
                new EmptyBorder(
                        8,
                        10,
                        8,
                        10
                )
        );

        setLayout(new BorderLayout(8, 8));


        // CHAT AREA

        chatArea = new JTextArea();

        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        chatArea.setBackground(
                new Color(40, 40, 40)
        );

        chatArea.setForeground(Color.WHITE);

        chatArea.setText(
                "[System] Welcome to ZeroBoard\n" +
                        "[System] Not connected to a server\n"
        );

        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        add(scrollPane, BorderLayout.CENTER);


        // MESSAGE INPUT

        JPanel inputPanel =
                new JPanel(new BorderLayout(5, 0));

        inputPanel.setOpaque(false);

        messageField = new JTextField();

        messageField.setToolTipText(
                "Type a message..."
        );

        JButton sendButton =
                new JButton("Send");

        inputPanel.add(
                messageField,
                BorderLayout.CENTER
        );

        inputPanel.add(
                sendButton,
                BorderLayout.EAST
        );

        add(
                inputPanel,
                BorderLayout.SOUTH
        );


        // SEND MESSAGE

        sendButton.addActionListener(
                e -> sendMessage()
        );

        messageField.addActionListener(
                e -> sendMessage()
        );
    }

    private void sendMessage() {

        String message =
                messageField.getText().trim();

        if (message.isEmpty()) {
            return;
        }
        
        chatArea.append(
                "[You] " + message + "\n"
        );

        messageField.setText("");

        chatArea.setCaretPosition(
                chatArea.getDocument().getLength()
        );
    }
}
