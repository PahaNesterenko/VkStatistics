package ua.pasha.VkStatistics.database;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ua.pasha.VkStatistics.miscellaneous.Properties;
import ua.pasha.VkStatistics.pojo.User;

public class UserDaoImpl implements UserDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jt;
	private String table = Properties.usersTable;

	@Override
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

	public void update(Map<String, String> user) {
		try {
			throw new Exception("Method not implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> listUsers() {
		String sql = "select * from " + table + ";" ;
		List<User> users = jt.query(sql, new UserMapper());
		return users;
	}

}
