package ua.pasha.VkStatistics.database;

import java.util.List;

import javax.sql.DataSource;

import ua.pasha.VkStatistics.pojo.User;

public interface UserDAO {

	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to list down a record from the Users table
	 * corresponding to a passed user id.
	 */
	public User getUser(Integer id);

	/**
	 * This is the method to be used to create a record in the Users table by
	 * parsing user object.
	 */
	public void createUser(User user);

	/**
	 * This is the method to be used to delete a record from the Users table
	 * corresponding to a passed user id.
	 */
	public void delete(Integer id);
	
	/**
	 * This is the method to be used to delete all records from the Users table
	 */
	public void deleteAll();

	/**
	 * This is the method to be used to update a record into the Users table.
	 * @throws Exception 
	 */
	public void update(User u) throws Exception;

	/**
	 * This is the method to be used to list down all the records from the users
	 * table.
	 */
	public List<User> listUsers();

}
