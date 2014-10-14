package ua.pasha.VkStatistics.vk;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import ua.pasha.VkStatistics.pojo.Group;
import ua.pasha.VkStatistics.pojo.User;

public interface SocialNetworkAPI {

	public User getUser(int id) throws IOException, ParseException;
	
	public User getRandUser() throws IOException, ParseException;
	
	public Group getRandGroup() throws IOException, ParseException;
	
	public Group getGroup(int gid) throws IOException, ParseException;
	
	public ArrayList<Integer> getFriendList(int id) throws IOException, ParseException;
	
	public ArrayList<Integer> getFriendParameters(int id) throws IOException, ParseException;
	
	public ArrayList<Integer> getSubscriptions(int id) throws IOException, ParseException;
	
	public ArrayList<Integer> getFollowers(int id) throws IOException, ParseException;
	
	
}