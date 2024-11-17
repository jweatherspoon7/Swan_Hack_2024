package game.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Win extends JFrame{
	
	public Win(){
		
		
		super("Win");
		
		ImageIcon gojo = new ImageIcon("animation (1).gif");
		 JLabel image = new JLabel(gojo);
		 
		 add(image);
		
		 setSize(500, 600);
		 setVisible(true);  
	     setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		
	}
	
	

}
