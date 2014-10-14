package ua.pasha.VkStatistics.pojo;

import java.util.ArrayList;

/**
 * Class container for User of VK social web. Contains basic info about user
 * @author Pasha
 *
 */
public class User {
	
	private int id = 0;
	private String name = "n/d";
	private String lastName = "n/d";
	private boolean isDeactivated = false;
	private String sex = "n/d";
	private String bdate = "n/d";
	private String city = "n/d";
	private String country = "n/d";
	private String homeTown = "n/d";
	private String photoAddress = "n/d";
	private String status = "n/d";
	private String relation = "n/d";
	private int friendsNum;
	private ArrayList<Integer> friendList;
	private int maleFriends;
	private int femaleFriends;
	private int followers;
	private int maleFollowers;
	private int femaleFollowers;
	private int subscriptions;
	private int groupSubscriptions;
	private int maleSubscriptions;
	private int femaleSubscriptions;
	
	
	
	public int getGroupSubscriptions() {
		return groupSubscriptions;
	}

	public void setGroupSubscriptions(int groupSubscriptions) {
		this.groupSubscriptions = groupSubscriptions;
	}

	public int getMaleFriends() {
		return maleFriends;
	}

	public void setMaleFriends(int maleFriends) {
		this.maleFriends = maleFriends;
	}

	public int getFemaleFriends() {
		return femaleFriends;
	}

	public void setFemaleFriends(int femaleFriends) {
		this.femaleFriends = femaleFriends;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getMaleFollowers() {
		return maleFollowers;
	}

	public void setMaleFollowers(int maleFollowers) {
		this.maleFollowers = maleFollowers;
	}

	public int getFemaleFollowers() {
		return femaleFollowers;
	}

	public void setFemaleFollowers(int femeleFollowers) {
		this.femaleFollowers = femeleFollowers;
	}

	public int getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(int subscriptions) {
		this.subscriptions = subscriptions;
	}

	public int getMaleSubscriptions() {
		return maleSubscriptions;
	}

	public void setMaleSubscriptions(int maleSubscriptions) {
		this.maleSubscriptions = maleSubscriptions;
	}

	public int getFemaleSubscriptions() {
		return femaleSubscriptions;
	}

	public void setFemaleSubscriptions(int femaleSubscriptions) {
		this.femaleSubscriptions = femaleSubscriptions;
	}

	public int getFriendsNum() {
		return friendsNum;
	}

	public void setFriendsNum(int friendsNum) {
		this.friendsNum = friendsNum;
	}

	public ArrayList<Integer> getFriendList() {
		return friendList;
	}

	public void setFriendList(ArrayList<Integer> friendList) {
		this.friendList = friendList;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getPhotoAddress() {
		return photoAddress;
	}

	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	
	
	 
	public boolean isDeactivated() {
		return isDeactivated;
	}

	public void setDeactivated(boolean isDeactivated) {
		this.isDeactivated = isDeactivated;
	}

	public User(){ 
		 
	}
	
	public User(int id, String name, String lastName) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString(){
		return "user id - " + id + "\tname - " + name + "\tlast name - " + lastName + "\tsex = " + sex + "\tbdate - " + bdate + "\n"
				+ "city - " + city + "\tcountry - " + country + "\thome town - " + homeTown + "\n"
				+ "status - " + status + "\n"
				+ "relation - " + relation + "\n"
				+ "friends - " + friendsNum + ", male/female - " + maleFriends + "/" + femaleFriends + "\n"
				+ "followers - " + followers + ", male/female - " + maleFollowers + "/" + femaleFollowers + "\n"
				+ "subscriptions - " + subscriptions + ", male/female - " + maleSubscriptions + "/" + femaleSubscriptions;
	}
	
}
