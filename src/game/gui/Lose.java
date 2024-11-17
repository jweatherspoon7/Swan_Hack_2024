package game.gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

	
	public class Lose extends JFrame{
		
		public Lose(){
		
			super("Lose");
			
			ImageIcon gojo_loses = new ImageIcon("animation (2).gif");
			 
	         // Resize the image
	 
	            
	         JLabel gojo = new JLabel(gojo_loses);
	       	 add(gojo);
	       	 
	       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		     setExtendedState(JFrame.MAXIMIZED_BOTH);
		     setVisible(true);  
			
			
			
		}

}
