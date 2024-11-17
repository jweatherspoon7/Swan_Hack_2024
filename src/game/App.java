//Title screen creation
package game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import game.gui.*;

public class App 
{
	public static Scanner scr;
	public static String[][] emailsArr;

	public static void main(String[] args) 
	{
		try
		{
			scr = new Scanner(new File("emails.txt"));
		}catch(FileNotFoundException e)
		{
			e.fillInStackTrace();
		}
		
		ArrayList<String> arrL = new ArrayList<String>();
		while(scr.hasNextLine())
		{
			arrL.add(scr.nextLine());
		}
		
		emailsArr = new String[arrL.size()][];
		
		for(int i = 0; i<arrL.size(); i++)
		{
			emailsArr[i] = arrL.get(i).split("[|]");
		}
		
		//TitleScreen titleScreen = new TitleScreen();
		Win Win = new Win();
		//DialogueAfterLvlOne n = new DialogueAfterLvlOne();
		
	}

}
