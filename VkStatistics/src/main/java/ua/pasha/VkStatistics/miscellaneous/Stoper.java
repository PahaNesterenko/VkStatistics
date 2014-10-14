package ua.pasha.VkStatistics.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class used for stopping filling database or any other work that take a long time. User in Worker class.
 * Instance of class after started is alive till user input Enter key. 
 * @author Pasha
 */
public class Stoper implements Runnable {
	
	public void run() {
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		try {
			rdr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
