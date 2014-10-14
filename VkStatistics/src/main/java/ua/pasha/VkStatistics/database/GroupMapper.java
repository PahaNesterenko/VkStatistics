package ua.pasha.VkStatistics.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.pasha.VkStatistics.pojo.Group;

public class GroupMapper implements RowMapper<Group>{

	@Override
	public Group mapRow(ResultSet rs, int colNum) throws SQLException {
		
		Group group = new Group();
		
		group.setGid(rs.getInt("gid"));
		group.setName(rs.getString("name"));
		group.setScreenName(rs.getString("screen_name"));
		group.setClosed(rs.getBoolean("is_closed"));
		group.setType(rs.getString("type"));
		group.setCity(rs.getString("city"));
		group.setCountry(rs.getString("country"));
		group.setPlace(rs.getString("place"));
		group.setWikiPage(rs.getString("wiki_page"));
		group.setDescription(rs.getString("description"));
		group.setMembersCount(rs.getInt("members_count"));
		group.setStartDate(rs.getString("start_date"));
		group.setStartDate(rs.getString("finish_date"));
		group.setStartDate(rs.getString("activity"));
		group.setStartDate(rs.getString("status"));
		group.setMembersCount(rs.getInt("verified"));
		group.setStartDate(rs.getString("site"));
		group.setStartDate(rs.getString("photo_address"));
		
		return group;
	}

}
