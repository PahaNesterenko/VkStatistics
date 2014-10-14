package ua.pasha.VkStatistics.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.pasha.VkStatistics.pojo.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int colNum) throws SQLException {
		
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setLastName(rs.getString( "last name" ));
		user.setSex(rs.getString("sex"));
		user.setBdate(rs.getString("bdate"));
		user.setCity(rs.getString("city"));
		user.setCountry(rs.getString("country"));
		user.setHomeTown(rs.getString("home town"));
		user.setPhotoAddress(rs.getString("photo address"));
		user.setStatus(rs.getString("status"));
		user.setRelation(rs.getString("relation"));
		user.setFriendsNum(rs.getInt("friends"));
		user.setMaleFriends(rs.getInt("male friends"));
		user.setFemaleFriends(rs.getInt("female friends"));
		user.setFollowers(rs.getInt("followers"));
		user.setMaleFollowers(rs.getInt("male followers"));
		user.setFemaleFollowers(rs.getInt("female followers"));
		user.setSubscriptions(rs.getInt("subscriptions"));
		user.setGroupSubscriptions(rs.getInt("group subscriptions"));
		user.setMaleSubscriptions(rs.getInt("male subscriptions"));
		user.setFemaleSubscriptions(rs.getInt("female subscriptions"));
		
		return user;
		
	}

}
