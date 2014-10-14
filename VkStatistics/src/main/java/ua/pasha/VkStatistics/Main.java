package ua.pasha.VkStatistics;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.parser.ParseException;

/**
 * Main class of project. Class perform user interface.
 * @author Pasha
 *
 */
public class Main {

	public static void main(String[] args) throws IOException, ParseException, SQLException, InterruptedException {
		WorkerSpring work = new WorkerSpring();
		String path = "C://VK_Photos";

		mainLoop: while (true) {
			
			Util.printFile(Properties.WelcomeFile);
			
			String command = Util.getCommandFromKeyboard();
			if (command.equals("e") || command.equals("exit") || command.equals("q")) {
				Util.printMsg("Good bye, nice to meet you again");
				break;
			}
			
			switch (Integer.parseInt(command)) {
			case 1:
				work.fillUsersDatabase();
				break;
			case 2:
				work.deleteDatabase();
				break;
			case 3:
				work.viewShortStatiscics();
				break;
			case 4:
				work.executeAndPrintQuery();
				break;
			case 5:
				work.printDatabase();
				break;
			case 6:
				work.savePhotos(path);
				break;
			case 7:
				work.showUserById();
				break;
			case 8:
				work.uploadBaseToFile();
				break;
			case 9:
				work.fillGroupsDatabase();
				break;
			default:
				System.out.println("Unknown command, good bye");
				break mainLoop;
			}

		}

	}

}
