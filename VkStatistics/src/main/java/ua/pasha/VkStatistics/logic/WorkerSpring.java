package ua.pasha.VkStatistics.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.pasha.VkStatistics.Statistics;
import ua.pasha.VkStatistics.database.UserDAO;
import ua.pasha.VkStatistics.miscellaneous.Properties;
import ua.pasha.VkStatistics.miscellaneous.Stoper;
import ua.pasha.VkStatistics.pojo.Group;
import ua.pasha.VkStatistics.pojo.User;
import ua.pasha.VkStatistics.vk.VkApiImpl;


/**
 * Class of VKStatistics project which contains all logic operations. It uses libraries for database and for
 * vk api.
 */
public class WorkerSpring {
	private static Logger log = Logger.getLogger("Logger");

	/**Name of table with users*/
	String usersTable = Properties.usersTable;
	/**Name of table with groups*/
	String groupsTable = Properties.groupsTable;
	private VkApiImpl vk = null;
	private static final int COUNT_USERS = Properties.COUNT_USERS;
	private static final int COUNT_GROUPS = Properties.COUNT_GROUPS;
	UserDAO userDao = null;
	String pathForPhotos = Properties.pathForPhotos;

	public WorkerSpring() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		userDao = (UserDAO) context.getBean("UserDaoImpl");
		
		vk = new VkApiImpl();
		log.log(Level.INFO, "Worker instance created");
	}

	public void fillUsersDatabase() throws IOException, ParseException, SQLException {

		Thread stoper = new Thread(new Stoper()); // thread that stop filling
		stoper.start();

		String insert;
		User user;
		Random rand = new Random();

		user = vk.getRandUser();
		for (int count = 0; count < COUNT_USERS; ++count) {

			if (!stoper.isAlive()) {
				log.log(Level.INFO, "Users recorded " + count);
				break;
			}
			
			userDao.createUser(user);

			//TODO fix logic
			if (user.getFriendsNum() == 0) {
				user = vk.getRandUser();
			} else {
				user = vk.getUser(user.getFriendList().get(rand.nextInt(user.getFriendList().size())));
			}
		}
		}


	/**
	 * Perform filling of groups database by getting random groups with at least 1000 members.
	 * One can stop it by press Enter key.
	 */
	public void fillGroupsDatabase() throws IOException, ParseException, SQLException {

		// "INSERT INTO `vk_database`.`vk_users`VALUES (19, 'Tom', 'Roy')";

		Thread stoper = new Thread(new Stoper()); // thread that stop filling
		stoper.start();

		int total = 0;
		String insert;
		Group group;
		ArrayList<String> parameters = new ArrayList<String>();

		for (int count = 0; count < COUNT_GROUPS; ++count) {
			group = vk.getRandGroup();

			if (!stoper.isAlive()) {
				log.log(Level.INFO, "Groups recorded " + total);
				break;
			}

			parameters.add(group.getGid() + "");
			parameters.add(group.getName());
			parameters.add(group.getScreenName());
			parameters.add(group.isClosed() + "");
			parameters.add(group.getType());
			parameters.add(group.getCity());
			parameters.add(group.getCountry());
			parameters.add(group.getPlace());
			parameters.add(group.getWikiPage());
			parameters.add(group.getDescription());
			parameters.add(group.getMembersCount() + "");
			parameters.add(group.getStartDate());
			parameters.add(group.getFinishDate());
			parameters.add(group.getActivity());
			parameters.add(group.getStatus());
			parameters.add(group.getVerified() + "");
			parameters.add(group.getSite());
			parameters.add(group.getPhotoAddress());

			insert = "INSERT INTO " + groupsTable + " VALUES ('" + parameters.get(0) + "'";
			for (int i = 1; i < parameters.size(); ++i) {
				insert += ",'" + parameters.get(i) + "'";
			}
			insert += ")";
			try {
				//db.runInsert(insert);
			} catch (Exception e) {
				log.log(Level.INFO, "user is already in base, sometimes happen");
			}

			total++;
			parameters.clear();
		}

	}



	public void viewShortStatiscics() throws SQLException {
		Statistics stat = new Statistics();
		stat.calculateStatistics();

	}


	public void savePhotos() throws SQLException, IOException {
		Thread stoper = new Thread(new Stoper()); // thread that stop filling
		stoper.start();

		String query = "SELECT `id`,`name`,`last name`,`photo address` FROM " + usersTable + ";";
		List<User> users = userDao.listUsers();
		int count = 0;
		String fullPath;

		for ( User user : users) {

			if (!stoper.isAlive()) {
				break;
			}

			if (user.getPhotoAddress().equals("n/d")) {
				continue;
			}
			fullPath = pathForPhotos + "/" + user.getName() + "_" + user.getLastName() + "_" + user.getId() + ".jpg";
			try {
				vk.savePhoto(user.getPhotoAddress(), fullPath);
			} catch (ConnectException e) {

			} catch (IOException e) {

			}
			count++;
		}
		System.out.println("Total " + count + " lines");

	}

	public void showUserById() throws IOException, ParseException {
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("input users id => ");
		int id;
		try {
			id = Integer.parseInt(rdr.readLine());
		} catch (NumberFormatException | IOException e) {
			//TODO logging
			System.out.println("Wrong input\n" + e);
			return;
		}
		User user = vk.getUser(id);
		System.out.println(user);
	}

}
