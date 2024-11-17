package game.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

	
	public class Win extends JFrame{
	private Clip clip;
			
		public Win(){
		
			super("Win");
			setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			
			ImageIcon gojo_wins = new ImageIcon("animation (1).gif");
			 
	         // Resize the image
			
			JLabel you_wins = new JLabel("You Win!");
	 
	            
	         JLabel gojo = new JLabel(gojo_wins);
	         
	         
	         you_wins.setHorizontalAlignment(JLabel.CENTER);
	         
	         you_wins.setAlignmentX(CENTER_ALIGNMENT);
	         gojo.setAlignmentX(CENTER_ALIGNMENT);
	         
	         
	        
	         
	         
	         add(you_wins);
	         add(Box.createVerticalStrut(50));
	       	 add(gojo);
	       	 
	       	Font font = new Font("Arial", Font.PLAIN, 90);
	       	
	       	you_wins.setFont(font);
	       	 
	       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		     setExtendedState(JFrame.MAXIMIZED_BOTH);
		     
		     try {
	             File audioFile = new File("gojo-i-stroke-my-pickle.wav");
	             AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

	             clip = AudioSystem.getClip();
	             clip.open(audioStream);
	             
	             clip.stop(); // Stop the clip if it's already playing
                 clip.setFramePosition(0); // Reset the clip to the beginning
                 clip.start(); // Play the clip
	             
	         } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	             e.printStackTrace();
	         }
		     
		     setVisible(true);  
			
			
			
		}
}
