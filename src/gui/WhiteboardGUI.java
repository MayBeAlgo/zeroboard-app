package gui;

import javax.swing.*;
import java.awt.*;

public class WhiteboardGUI extends JFrame {
     private JPanel whiteboardCanvas;
     private JPanel connectionPanel;
     private JPanel toolsPanel;
     private JPanel chatPanel;

    public WhiteboardGUI() {

        setTitle("ZeroBoard");
        setSize(1200, 750);
        setMinimumSize(new Dimension(900, 600));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // MAIN CONTAINER

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(30, 30, 30));
        add(mainPanel);

        //TOP BAR OF THE BOARD
        JPanel topBar = createTopBar();
        mainPanel.add(topBar, BorderLayout.NORTH);

        // CANVAS
        whiteboardCanvas = new CanvasPanel();
        mainPanel.add(whiteboardCanvas, BorderLayout.CENTER);

        //CONNECTION PANEL
        connectionPanel = new ConnectionPanel();
        mainPanel.add(connectionPanel, BorderLayout.WEST);

        //TOOLS PANEL
        toolsPanel = new ToolsPanel();
        mainPanel.add(toolsPanel, BorderLayout.EAST);

        //CHAT PANEL
        chatPanel = new ChatPanel();
        mainPanel.add(chatPanel, BorderLayout.SOUTH);
    }

    private JPanel createTopBar() {

            JPanel panel = new JPanel(new BorderLayout());

            panel.setPreferredSize(new Dimension(0, 55));
            panel.setBackground(new Color(25, 25, 25));

            JLabel title = new JLabel("  ZeroBoard");

            title.setForeground(Color.WHITE);
            title.setFont(new Font("SansSerif", Font.BOLD, 22));

            JLabel status = new JLabel("LAN COLLABORATIVE WHITEBOARD  ");

            status.setForeground(new Color(150, 150, 150));
            status.setFont(new Font("SansSerif", Font.PLAIN, 12));

            panel.add(title, BorderLayout.WEST);
            panel.add(status, BorderLayout.EAST);

            return panel;
        }
    }

