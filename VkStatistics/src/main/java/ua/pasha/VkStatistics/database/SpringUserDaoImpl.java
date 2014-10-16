package ua.pasha.VkStatistics.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ua.pasha.VkStatistics.miscellaneous.Properties;
import ua.pasha.VkStatistics.pojo.User;

public class SpringUserDaoImpl implements UserDAO{
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jt;
	private String table = Properties.usersTable;

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jt = new JdbcTemplate(ds);
	}
	
	public void setTable(String table){
		this.table = table;
	}

	@Override
	public User getUser(Integer id) {
		String sql = "select * from " + table + " where id=?; ";
		User user = jt.queryForObject(sql, new Object[]{id}, new UserMapper());
		return user;
	}

	@Override
	public void createUser(User u) {
		String sql = "insert into " + table + " values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ); "; //21
		
		jt.update(sql, u.getId(), u.getName(), u.getLastName(), u.getSex(), u.getBdate(), u.getCity(), u.getCountry(), u.getHomeTown(), u.getPhotoAddress(), u.getStatus(), u.getRelation() , u.getFriendsNum(), u.getMaleFriends(), u.getFemaleFriends(), u.getFollowers(), u.getMaleFollowers(), u.getFemaleFollowers(), u.getSubscriptions(), u.getGroupSubscriptions(), u.getMaleSubscriptions(), u.getFemaleSubscriptions() );
		
		return;
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id=?;" ;
		jt.update(sql, id);
		return;
	}
	
	@Override
	public void deleteAll() {
		String sql = "delete from " + table + ";" ;
		jt.update(sql);
		return;
	}

	public void update(User u) throws Exception {
		throw new Exception("There is a bug in update method i dont know how to fix");
		//String sql = "update " + table + " set name=?, `last name`=?,sex=?,bdate=?,city=?,country=?,`home town`=?,`photo address`=?,status=?,relation=?,friens=?,`male friends`=?,`female friends`=?,followers=?,`male followers`=?,`female followers=?,subscriptions=?,`group subscriptions`=?,`male subscriptions`=? where id=?; "; //21,`female subscriptions`=?
		//jt.update(sql, u.getName(), u.getLastName(), u.getSex(), u.getBdate(), u.getCity(), u.getCountry(), u.getHomeTown(), u.getPhotoAddress(), u.getStatus(), u.getRelation() , u.getFriendsNum(), u.getMaleFriends(), u.getFemaleFriends(), u.getFollowers(), u.getMaleFollowers(), u.getFemaleFollowers(), u.getSubscriptions(), u.getGroupSubscriptions(), u.getMaleSubscriptions(),  u.getId() );// u.getFemaleSubscriptions(),
		//return;
	}

	@Override
	public List<User> listUsers() {
		String sql = "select * from " + table + ";" ;
		List<User> users = jt.query(sql, new UserMapper());
		return users;
	}


}
