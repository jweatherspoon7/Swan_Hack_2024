package game.gui;

import javax.sound.sampled.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LevelTwoScreen extends BaseLevelScreen {
    public LevelTwoScreen() {
    	super("Level Two Screen", 2);
    	Clip clip;
    	 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         

         
        

         // Create a JButton
         JButton playButton = new JButton("Play Phone Clip");
         JButton stopButton = new JButton("Stop phone clip");
         
		try {
             File audioFile = new File("scamcall.wav");
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

             clip = AudioSystem.getClip();
             clip.open(audioStream);
             
             // Add an ActionListener to the button
             playButton.addActionListener(e -> {
                 if (clip != null) {
                     clip.stop(); // Stop the clip if it's already playing
                     clip.setFramePosition(0); // Reset the clip to the beginning
                     clip.start(); // Play the clip
                 }
             });
             
             stopButton.addActionListener(e -> {
                 if (clip != null && clip.isRunning()) {
                     clip.stop(); // Stop the clip
                 }
             });
         } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
             e.printStackTrace();
         }


  
    
         // Add the button to the frame
         add(playButton);
         add(stopButton);

        
 	    //title of the level
 	    JLabel title = new JLabel("FIND OUT IF ITS A SCAM");
 	    title.setFont(new Font("Arial", Font.PLAIN, 25));
 		
 	    gbc.anchor = GridBagConstraints.NORTH;
 		gbc.fill = GridBagConstraints.HORIZONTAL;
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		gbc.gridheight = 5;
 		gbc.ipady = 30;
 		add(title, gbc);
 		
 		
 		
 		//scam button
 		gbc.gridx = 3;
 		gbc.gridy = 6;
 		gbc.gridwidth = 2;
 		gbc.gridheight = 2;
 		add(scamButton, gbc);
 		
 		//not scam button
 		gbc.gridx = 5;
 		gbc.gridy = 6;
 		gbc.gridwidth = 2;
 		gbc.gridheight = 2;
 		add(notScamButton, gbc);
 		
 		JCheckBox isWrongDomain = new JCheckBox("A) Sus email domain");    
 		gbc.gridx = 3;
 		gbc.gridy = 8;
 		gbc.gridheight = 2;
 		add(isWrongDomain, gbc);
 		isWrongDomain.setVisible(false);
 		
 		JButton undoScamButton = new JButton("back");
 		gbc.gridx = 4;
 		gbc.gridy = 10;
 		gbc.gridwidth = 2;
 		gbc.gridheight = 2;
 		add(undoScamButton, gbc);
 		undoScamButton.setVisible(false);
 		
 		
 		JButton submitButton = new JButton("submit");
 		gbc.gridx = 5;
 		gbc.gridy = 10;
 		gbc.gridwidth = 2;
 		gbc.gridheight = 2;
 		add(submitButton, gbc);
 		submitButton.setVisible(false);
 		
 		
 		scamButton.addActionListener(new ActionListener() {
 			@Override
             public void actionPerformed(ActionEvent e) {
 				isWrongDomain.setVisible(true);
 				undoScamButton.setVisible(true);
 				submitButton.setVisible(true);
 				
 				notScamButton.setEnabled(false);
 				
             }
 		});
 		
 		undoScamButton.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				isWrongDomain.setVisible(false);
 				undoScamButton.setVisible(false);
 				submitButton.setVisible(false);
 				
 				isWrongDomain.setSelected(false);
 				
 				notScamButton.setEnabled(true);
 			}
 		});
 		
 		submitButton.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				if(isWrongDomain.isSelected())
 				{
 					//check if right/wrong
 				}
 			}
 		});
 		
 		notScamButton.addActionListener(new ActionListener() {
 			@Override
             public void actionPerformed(ActionEvent e) {
                 //go to next thing
             }
 		});
 		
 		
 		setVisible(true);
    }}
 
    	
    	
    
    
   
