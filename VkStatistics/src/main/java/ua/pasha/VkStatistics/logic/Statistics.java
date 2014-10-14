package ua.pasha.VkStatistics;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;


/**
 * Class for calculate statistics. Perform simple calculates.
 * @author Pasha
 *
 */
public class Statistics {
	
	private static ArrayList<String> report = new ArrayList<String>();

	int totalUsers;
	int totalMale;
	int totalFemale;

	int russiaUsers;
	int ukraineUsers;
	int belorussiaUsers;
	int otherUsers;

	HashMap<String, Integer> russiaCitiesByUsers = new HashMap<String, Integer>();
	HashMap<String, Integer> ukraineCitiesByUsers = new HashMap<String, Integer>();
	HashMap<String, Integer> belorussiaCitiesByUsers = new HashMap<String, Integer>();
	HashMap<String, Integer> otherCitiesByUsers = new HashMap<String, Integer>();

	int usersWhoShowRelations;

	int singleUsers;
	int singleMales;
	int singleFemales;

	int inARelationshipUsers;
	int inARelationshipMales;
	int inARelationshipFemales;

	int engagedUsers;
	int engagedMales;
	int engagedFemales;

	int marriedUsers;
	int marriedMales;
	int marriedFemales;

	int messUsers;
	int messMales;
	int messFemales;

	int inActiveSearchUsers;
	int inActiveSearchMales;
	int inActiveSearchFemales;

	int inLoveUsers;
	int inLoveMales;
	int inLoveFemales;

	int totalFriends;
	int friendsOfMales;
	int friendsOfFemales;
	int femalesOfMalesFriends;
	int femalesOfFemalesFriends;
	int malesOfMalesFriends;
	int malesOfFemalesFriends;

	/**
	 * Method parse data from parameters, calculate and fill report, then print report to console 
	 * @param data that will be parsed and calculated in format Vector<Vector<String>>
	 */
	public void calculateStatistics() {
		Vector<Vector<String>> res ;
		parseData(res);
		calculate();
		printReportToConsole();
	}
	
	
	
	/**
	 * Method fills all fields of this class by analyze all strings of data which contains in parameter
	 * @param Structured data from sql request 
	 */
	private void parseData(Vector<Vector<String>> res) {
		// 0id 1name 2lastName 3sex 4bdate 5city 6country 7homeTown
		// 8photoAddress 9status 10relation 11friends 12maleFriends
		// 13femaleFriends
		// 14followers 15maleFollowers 16femaleFollowers 17subscriptions
		// 18groupSubscriptions 19maleSubscriptions 20femaleSubscriptions
		// each line contains 20 columns info about user

		for (Vector<String> row : res) {

			totalUsers++;
			String sex = row.get(3);
			if (sex.equals("male")) {
				totalMale++;
			} else if (sex.equals("female")) {
				totalFemale++;
			}

			// -----------------------country and cityes

			if (row.get(6).equals("���i�")) {
				russiaUsers++;
				String city = row.get(5);
				if (russiaCitiesByUsers.containsKey(city)) {
					int temp = russiaCitiesByUsers.get(city);
					temp++;
					russiaCitiesByUsers.put(city, temp);
				} else {
					russiaCitiesByUsers.put(city, 1);
				}
			} else if (row.get(6).equals("������")) {
				ukraineUsers++;
				String city = row.get(5);
				if (ukraineCitiesByUsers.containsKey(city)) {
					int temp = ukraineCitiesByUsers.get(city);
					temp++;
					ukraineCitiesByUsers.put(city, temp);
				} else {
					ukraineCitiesByUsers.put(city, 1);
				}
			} else if (row.get(6).equals("�i������")) {
				belorussiaUsers++;
				String city = row.get(5);
				if (belorussiaCitiesByUsers.containsKey(city)) {
					int temp = belorussiaCitiesByUsers.get(city);
					temp++;
					belorussiaCitiesByUsers.put(city, temp);
				} else {
					belorussiaCitiesByUsers.put(city, 1);
				}
			} else {
				otherUsers++;
				String city = row.get(5);
				if (otherCitiesByUsers.containsKey(city)) {
					int temp = otherCitiesByUsers.get(city);
					temp++;
					otherCitiesByUsers.put(city, temp);
				} else {
					otherCitiesByUsers.put(city, 1);
				}
			}

			// -------------------relationship

			if (!row.get(10).equals("n/d")) {
				usersWhoShowRelations++;
			}

			String relation = row.get(10);

			if (relation.equals("single")) {
				singleUsers++;
				if (sex.equals("male")) {
					singleMales++;
				} else if (sex.equals("female")) {
					singleFemales++;
				}
			} else if (relation.equals("in a relationship")) {
				inARelationshipUsers++;
				if (sex.equals("male")) {
					inARelationshipMales++;
				} else if (sex.equals("female")) {
					inARelationshipFemales++;
				}
			} else if (relation.equals("engaget")) {
				engagedUsers++;
				if (sex.equals("male")) {
					engagedMales++;
				} else if (sex.equals("female")) {
					engagedFemales++;
				}
			} else if (relation.equals("married")) {
				marriedUsers++;
				if (sex.equals("male")) {
					marriedMales++;
				} else if (sex.equals("female")) {
					marriedFemales++;
				}
			} else if (relation.equals("mess")) {
				messUsers++;
				if (sex.equals("male")) {
					messMales++;
				} else if (sex.equals("female")) {
					messFemales++;
				}
			} else if (relation.equals("in active search")) {
				inActiveSearchUsers++;
				if (sex.equals("male")) {
					inActiveSearchMales++;
				} else if (sex.equals("female")) {
					inActiveSearchFemales++;
				}
			} else if (relation.equals("in love")) {
				inLoveUsers++;
				if (sex.equals("male")) {
					inLoveMales++;
				} else if (sex.equals("female")) {
					inLoveFemales++;
				}
			}

			// -----------------friends

			int friendsOfUser = Integer.parseInt(row.get(11));
			int maleFriendsOfUser = Integer.parseInt(row.get(12));
			int femaleFriendsOfUser = Integer.parseInt(row.get(13));

			totalFriends += friendsOfUser;
			if (sex.equals("male")) {
				friendsOfMales += friendsOfUser;
				malesOfMalesFriends += maleFriendsOfUser;
				femalesOfMalesFriends += femaleFriendsOfUser;
			} else if (sex.equals("female")) {
				friendsOfFemales += friendsOfUser;
				malesOfFemalesFriends += maleFriendsOfUser;
				femalesOfFemalesFriends += femaleFriendsOfUser;
			}

			// ------------------

		}// for vector<String> row : res
		
		
		

		
	}
	
	/**
	 * Method calculate report from inner fields
	 */
	private void calculate(){
		String total = String.format(
				"Counted users - %4d \tmale/female %.2f/%.2f", totalUsers,
				(totalMale * 1.0 / totalUsers),
				(totalFemale * 1.0 / totalUsers));
		report.add(total);
		String countries = "Countries:";
		report.add(countries);
		String russia = String.format("\tRussia - %.2f", russiaUsers * 1.0
				/ totalUsers);
		report.add(russia);
		String ukraine = String.format("\tUkraine - %.2f", ukraineUsers * 1.0
				/ totalUsers);
		report.add(ukraine);
		String belorussia = String.format("\tBelorussia - %.2f",
				belorussiaUsers * 1.0 / totalUsers);
		report.add(belorussia);
		String relations = "Relations";
		report.add(relations);
		String single = String.format(
				"\tsingle - %.2f\t\t\t male/female %.2f/%.2f", singleUsers * 1.0
						/ usersWhoShowRelations, singleMales * 1.0
						/ singleUsers, singleFemales * 1.0 / singleUsers);
		report.add(single);
		String inAReationship = String.format(
				"\tin a relationship - %.2f \t male/female %.2f/%.2f",
				inARelationshipUsers * 1.0 / usersWhoShowRelations,
				inARelationshipMales * 1.0 / inARelationshipUsers,
				inARelationshipFemales * 1.0 / inARelationshipUsers);
		report.add(inAReationship);
		String engaged = String.format(
				"\tengaged - %.2f \t\t\t male/female %.2f/%.2f", engagedUsers * 1.0
						/ usersWhoShowRelations, engagedMales * 1.0
						/ engagedUsers, engagedFemales * 1.0 / engagedUsers);
		report.add(engaged);
		String married = String.format(
				"\tmarried - %.2f \t\t\t male/female %.2f/%.2f", marriedUsers * 1.0
						/ usersWhoShowRelations, marriedMales * 1.0
						/ marriedUsers, marriedFemales * 1.0 / marriedUsers);
		report.add(married);
		String mess = String.format(
				"\tall difficult - %.2f \t\t male/female %.2f/%.2f", messUsers * 1.
						/ usersWhoShowRelations, messMales * 1.0 / messUsers,
				messFemales * 1.0 / messUsers);
		
		report.add(mess);
		String inActiveSearch = String.format(
				"\tin active search - %.2f \t male/female %.2f/%.2f ",
				inActiveSearchUsers * 1.0 / usersWhoShowRelations,
				inActiveSearchMales * 1.0 / inActiveSearchUsers,
				inActiveSearchFemales * 1.0 / inActiveSearchUsers);
		report.add(inActiveSearch);
		String inLove = String.format(
				"\tin love - %.2f \t\t\t male/female %.2f/%.2f", inLoveUsers * 1.0
						/ usersWhoShowRelations, inLoveMales * 1.0
						/ inLoveUsers, inLoveFemales * 1.0 / inLoveUsers);
		report.add(inLove);
		String friends = "friends";
		report.add(friends);
		String averageFriends = String.format(
				"\taverage - %.2f \t\t male/female %.2f/%.2f", totalFriends * 1.0
						/ totalUsers, friendsOfMales * 1.0 / totalMale,
				friendsOfFemales * 1.0 / totalFemale);
		report.add(averageFriends);
		String malesFriends = String.format(
				"\tparts of male's friends \t male/female %.2f/%.2f",
				malesOfMalesFriends * 1.0 / friendsOfMales,
				femalesOfMalesFriends * 1.0 / friendsOfMales);
		report.add(malesFriends);
		String femalesFriends = String.format(
				"\tparts of female's friends \t male/female %.2f/%.2f",
				malesOfFemalesFriends * 1.0 / friendsOfFemales,
				femalesOfFemalesFriends * 1.0 / friendsOfFemales);
		report.add(femalesFriends);
		
	}
	
	/**Method print report to console*/
	public void printReportToConsole(){
		if( report.size() == 0){
			// TODO show messge that report not ready
			return;
		}
		for( String s : report){
			System.out.println(s);
		}
	}
	
	/**Method write report to File "VKREport(date).txt" 
	 * @throws IOException */
	public void writeReportToFile(String path) throws IOException {
		if( report.size() == 0){
			// TODO show message that report not ready
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(new Date());
		String fileName = "VKReport(" + date + ").txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			//TODO send message that file not found or IOException
			return;
		}
		
		for( String s : report){
			fw.write(s);
		}
		fw.close();
		//TODO send message that file writed
		
	}

	/**Method return report as ArraList<String>*/
	public ArrayList<String> getReportAsList(){
		if( report.size() == 0){
			// TODO show messge that report not ready
		}
		return report;
	}

}
