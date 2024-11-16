package game.gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IntroDialogue extends JFrame{
	
	  private static int currentTextIndex = 0; // Track the current dialogue index
	    private static final String[] dialogue = {
	        "       Welcome to Scammer Slammer! I Gojo, wil teach you the basics of this game.",
	        "       In this game, you will be presented with various possible scams",
	        "       Determine if they are scams or not by finding what's wrong with them",
	        "       Good luck, the fate of the free world counts on you!"
	    };
	   
    public IntroDialogue()
    {
    	super("Intro Dialogue");
        
        setSize(600, 600);  
        
        ImageIcon gojo = new ImageIcon("Gojo_Satoru.WEBP-ezgif.com-webp-to-jpg-converter.jpg");
        JLabel label = new JLabel(gojo);
        JLabel text1 = new JLabel(dialogue[currentTextIndex]);
        JButton continueButton = new JButton("Click to continue");
        Font textFont = new Font("Arial", Font.BOLD, 25);
        text1.setFont(textFont);
        
        // Add an ActionListener to the button
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Increment the currentTextIndex and update the label's text
                if (currentTextIndex < dialogue.length - 1) {
                    currentTextIndex++;
                    text1.setText(dialogue[currentTextIndex]);
                } else {
                	new LevelOneScreen();
            		IntroDialogue.this.dispose();
                }
            }
        });
        
        add(label, BorderLayout.SOUTH);
        add(text1, BorderLayout.CENTER);
        add(continueButton, BorderLayout.NORTH);
        
        
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}