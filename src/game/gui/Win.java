package game.gui;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
s
		
		ImageIcon gojo = new ImageIcon("animation (1).gif");
		 JLabel image = new JLabel(gojo);
		 
		 add(image);
		
		 setSize(500, 600);
		 setVisible(true);  
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
	}
	
	

}
