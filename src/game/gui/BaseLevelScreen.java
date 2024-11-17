package game.gui;

import java.awt.*;

import javax.swing.*;

public abstract class BaseLevelScreen extends JFrame
{
	protected GridBagLayout grid = new GridBagLayout();
	protected GridBagConstraints gbc = new GridBagConstraints();
	
	//elements to be shared between objects
	protected JPanel emailPanel;
	
	//button if player wants to report spam
	protected JButton scamButton = new JButton("SCAM");
		
	//button if player wants say not sapm
	protected JButton notScamButton = new JButton("NOT SCAM");
	
	protected JDialog scamReasonsDialog = new JDialog(this, "Reasons", true);
	
	protected JCheckBox isWrongDomain = new JCheckBox("A) Sus email domain");  
	
	protected JButton undoScamButton = new JButton("back");
	
	protected JButton submitButton = new JButton("submit");
	
	public BaseLevelScreen(String title, int reasonsAmount)
	{
		super(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(grid);
		
		scamReasonsDialog.setSize(300, 300);
		scamReasonsDialog.setLayout(new GridLayout(reasonsAmount + 4, -1));
		scamReasonsDialog.add(new JLabel("Why is this a scam?"));
		
	}
	 	
	/**
	 * class to set up panel for email
	 */
	protected void setupEmail(String subject, String email, String message)
	{
		emailPanel = new JPanel(); 
		
		emailPanel.setBackground(Color.WHITE);
		
		GridBagLayout ePGBL = new GridBagLayout();
		GridBagConstraints ePGBC = new GridBagConstraints();
		
		emailPanel.setLayout(ePGBL);
				
		//add title of email
		JLabel eTitle = new JLabel(subject);
		ePGBC.fill = GridBagConstraints.HORIZONTAL;
		ePGBC.gridx = 0;
		ePGBC.gridy = 0;
		emailPanel.add(eTitle, ePGBC);
		
		//add sender of email
		JLabel eSender = new JLabel(email);
		ePGBC.fill = GridBagConstraints.HORIZONTAL;
		ePGBC.ipady = 20;  
		ePGBC.gridx = 0;
		ePGBC.gridy = 1;
		ePGBC.gridwidth = 2;
		emailPanel.add(eSender, ePGBC);
		
		JTextArea eMessage = new JTextArea(message);
		eMessage.setEditable(false);
		ePGBC.fill = GridBagConstraints.BOTH;
		ePGBC.ipady = 20;  
		ePGBC.gridx = 0;
		ePGBC.gridy = 2;
		ePGBC.gridwidth = 2;
		emailPanel.add(eMessage, ePGBC);
		
	}
}
