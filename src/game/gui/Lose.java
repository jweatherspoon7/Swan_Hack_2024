package game.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
			setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ImageIcon gojo_loses = new ImageIcon("animation (2).gif");
			 
	         // Resize the image
			
			JLabel you_lose = new JLabel("You Lose!");
	 
	            
	         JLabel gojo = new JLabel(gojo_loses);
	         
	         
	         you_lose.setHorizontalAlignment(JLabel.CENTER);
	         
	         you_lose.setAlignmentX(CENTER_ALIGNMENT);
	         gojo.setAlignmentX(CENTER_ALIGNMENT);
	         
	         
	        
	         
	         
	         add(you_lose);
	         add(Box.createVerticalStrut(50));
	       	 add(gojo);
	       	 
	       	Font font = new Font("Arial", Font.PLAIN, 90);
	       	
	       	you_lose.setFont(font);
	       	 
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
