package game.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LevelOneScreen extends BaseLevelScreen
{
	private static int levelCounter = 0;
	
	private final String EMAIL_SUBJECT = "THIS IS A TEST SCAM EMAIL TITLE";
	private final String EMAIL = "scammer@iastate.edu";
	private final String EMAIL_MESSAGE = "THIS IS A MESSAGE FOR A NEW JOB!!\n "
			+ "YOU GET 1 MILLION FOR DOING THIS SHIT \n YEAH BITCH THIS REAL \n Love, \n your gojo ";

	
	public LevelOneScreen()
	{
		super("Level One", 1);
		setupEmail(EMAIL_SUBJECT, EMAIL, EMAIL_MESSAGE); //setup email thingy
		
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
		
		//email config
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 4;
		add(emailPanel, gbc);
		
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
		

		scamReasonsDialog.add(isWrongDomain, gbc);
		
		scamReasonsDialog.add(submitButton, gbc);
		scamReasonsDialog.add(undoScamButton, gbc);

		scamButton.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {

				scamReasonsDialog.setVisible(true);
								
            }
		});
		
		undoScamButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				scamReasonsDialog.setVisible(false);
				isWrongDomain.setSelected(false);
				
				
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
	}
}
