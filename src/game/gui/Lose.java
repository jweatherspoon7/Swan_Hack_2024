package game.gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

	
	public class Lose extends JFrame{
		
		Clip clip;
		
		public Lose(){
		
			super("Lose");
			
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ImageIcon gojo_loses = new ImageIcon("animation (2).gif");
			 
	         // Resize the image
	 
	            
	         JLabel gojo = new JLabel(gojo_loses);
	       	 add(gojo);
	       	 
	       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		     setExtendedState(JFrame.MAXIMIZED_BOTH);
		     setVisible(true);  
			
		     try {
	             File audioFile = new File("sukuna-screaming-for-help.wav");
	             AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

	             clip = AudioSystem.getClip();
	             clip.open(audioStream);
	             
	             clip.stop(); // Stop the clip if it's already playing
                 clip.setFramePosition(0); // Reset the clip to the beginning
                 clip.start(); // Play the clip
	             
	         } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	             e.printStackTrace();
	         }
			
		}

}
