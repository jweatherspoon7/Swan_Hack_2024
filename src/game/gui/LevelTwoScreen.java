package game.gui;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LevelTwoScreen extends BaseLevelScreen {
    public LevelTwoScreen() {
    	super("Level Two Screen");
    	 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         

         
        

         // Create a JButton
         JButton playButton = new JButton("Play Sound");

         // Add an ActionListener to the button
         playButton.addActionListener(e -> playSound("scamcall.wav"));

         // Add the button to the frame
         add(playButton);

         // Make the frame visible
         setVisible(true);
    	
    	
    }
    // Method to play sound
    private static void playSound(String filePath) {
        try {
            // Load the audio file
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Get a Clip object
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Play the audio
            clip.setFramePosition(0); // Reset to the beginning
            clip.start(); // Play again

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}
