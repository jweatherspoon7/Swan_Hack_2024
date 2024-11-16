package game.gui;

import java.awt.*;

import javax.swing.*;

public abstract class BaseLevelScreen extends JFrame
{
	protected GridBagLayout grid = new GridBagLayout();
	protected GridBagConstraints gbc = new GridBagConstraints();
	
	public BaseLevelScreen(String title)
	{
		super(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(grid);
		
		
	}
}
