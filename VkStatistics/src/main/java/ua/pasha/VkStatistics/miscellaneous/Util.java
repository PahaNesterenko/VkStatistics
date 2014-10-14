package ua.pasha.VkStatistics.miscellaneous;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Util {

	private static List<String> validCommands = new ArrayList<String>();

	/**
	 * Method print the file content to console. Parameter is path and file name
	 * ( "resource/somefile" )
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void printFile(String path) throws IOException {

		FileReader fr = new FileReader(new File(path));

		int count = 0;
		char[] arr = new char[1024];

		while (true) {
			count = fr.read(arr);
			if (count == -1) {
				break;
			}
			System.out.println(arr);
		}
		fr.close();
	}

	public static String getCommandFromKeyboard() throws IOException {
		validCommands.add("e");
		validCommands.add("exit");
		validCommands.add("q");
		validCommands.add("1");
		validCommands.add("2");
		validCommands.add("3");
		validCommands.add("4 ");
		validCommands.add("5");
		validCommands.add("6");
		validCommands.add("7");
		validCommands.add("8");
		validCommands.add("9");

		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		String command;
		while (true) {
			command = rdr.readLine();
			if (validCommands.contains(command)) {
				break;
			}
			printMsg("Wrong command, try again");
		}
		rdr.close();
		return command;

	}

	/**
	 * print message to out
	 * 
	 * @param msg
	 */
	public static void printMsg(String msg) {
		System.out.println(msg);
	}

}
