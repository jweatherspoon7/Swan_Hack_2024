package game.gui;

import javax.sound.sampled.*;

import javax.swing.*;

import game.App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LevelTwoScreen extends BaseLevelScreen 
{
	
	private String[] audioFiles = {"scamcall.wav","legitHospitalCall.wav", "lotteryscam.wav"};
	
	//{}reason1,reason2
	private boolean[][] reasons = {{true, false}, {false, false}, {true, true}};
	private boolean[] answers = {};
	private static int audioFilesPlayed = 0; //counter for the audio files
	
	private Clip clip;
	
    public LevelTwoScreen() {
    	super("Level Two Screen", 2);

    	
    	//goes to next level if all possible calls have been played
    	if(audioFilesPlayed >= audioFiles.length)
    	{

    		if(App.pointTracker > 7) new Win();
    		else new Lose();
    		
    		this.dispose();
    		return;
    	}
    	
         // Create a JButton
         JButton playButton = new JButton("Play Phone Clip");
         JButton stopButton = new JButton("Stop phone clip");
         
         setupPhone("num", playButton, stopButton);
         
		try {
			answers = reasons[audioFilesPlayed];
             File audioFile = new File(audioFiles[audioFilesPlayed++]);
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


		//email config
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		gbc.gridheight = 0;
		gbc.weightx = 0.25;
		gbc.weighty = 0.25;
		add(phonePanel, gbc);
 		
 		gbc.insets = new Insets(1,5,1,5);
		//scam button
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.weightx = 0.01;
		gbc.weighty = 0.01;
		add(scamButton, gbc);
		
		gbc.insets = new Insets(1,5,1,30);
		//not scam button
		gbc.gridx = 5;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		add(notScamButton, gbc);
		
		//check boxes to add to submit for reasons
		JCheckBox askingForInfo = new JCheckBox("Asking for info");
		JCheckBox otherReasons = new JCheckBox("other");

		scamReasonsDialog.add(askingForInfo, gbc);
		scamReasonsDialog.add(otherReasons, gbc);
		
		scamReasonsDialog.add(submitButton, gbc);
		scamReasonsDialog.add(undoScamButton, gbc);
		
		//for answering scam
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(askingForInfo.isSelected() == answers[0] && otherReasons.isSelected() == answers[1])
				{
					winSound();
					//win
					new LevelTwoScreen();
					LevelTwoScreen.this.dispose();
					
				}
				else
				{
					wrong();
				}
				
				clip.stop(); // Stop the clip if it's already playing
			}
		});
		
		notScamButton.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                if(askingForInfo.isSelected() == answers[0] && otherReasons.isSelected() == answers[1])
                {

                	winSound();
                	//win
                	new LevelTwoScreen();
					LevelTwoScreen.this.dispose();
                }
                else
                {

                	wrong();
                }
                
                clip.stop(); // Stop the clip if it's already playing
            }
		});
		
		
		setVisible(true);

    }
    
    public void wrong()
	{
		Timer timer = new Timer(300, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new LevelTwoScreen();
				LevelTwoScreen.this.dispose();
			}
    	});
    	timer.setInitialDelay(200);
    	timer.setRepeats(false);
    	
    	
    	timer.start();
    	hurtGojo();
    	--App.pointTracker;
	}
    
}

 
    	
    	
    
    
   
