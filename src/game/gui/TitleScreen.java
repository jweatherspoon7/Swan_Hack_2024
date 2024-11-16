package game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TitleScreen extends JFrame {
    public TitleScreen() {
        super("Title Screen");

        setLayout(new BorderLayout());

        // Title label
        JLabel title = new JLabel("Scammer Slammer!", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 25));
        add(title, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Buttons
        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");
        JButton creditsButton = new JButton("Credits");

        // Set button sizes
        startButton.setPreferredSize(new Dimension(200, 60));
        exitButton.setPreferredSize(new Dimension(150, 60));
        creditsButton.setPreferredSize(new Dimension(150, 60));

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listener to the exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Closes the program
            }
        });
        creditsButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new CreditScreen();
        		TitleScreen.this.dispose();

        	}
        });
        
        

        // Add buttons to the panel
        buttonPanel.add(Box.createVerticalStrut(60));
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createVerticalStrut(60)); // Spacing
        buttonPanel.add(exitButton);
        buttonPanel.add(Box.createVerticalStrut(60)); // Spacing
        buttonPanel.add(creditsButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Frame settings
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TitleScreen();
    }
}
