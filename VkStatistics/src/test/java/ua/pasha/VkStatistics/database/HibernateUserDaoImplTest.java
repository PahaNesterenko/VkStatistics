package ua.pasha.VkStatistics.database;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.pasha.VkStatistics.database.HibernateUserDaoImpl;
import ua.pasha.VkStatistics.pojo.User;

public class HibernateUserDaoImplTest {
	
	UserDAO dao; 
	String table = "test_users";
	User nick;
	User sarah;
	User alf;
	
	@Before
	public void init(){
		
		dao = new HibernateUserDaoImpl();
		dao.deleteAll();
		
		nick = new User();
		nick.setId(1);
		nick.setName("Nicolas");
		nick.setLastName("Jonson");
		
		sarah = new User();
		sarah.setId(15);
		sarah.setName("Sarah");
		sarah.setLastName("Berkovich");
		
		alf = new User();
		alf.setId(75);
		alf.setName("Alfred");
		alf.setLastName("Simpson");
	}

	
	@Test
	public void countUsersTest() {
	
		//should return zero records
		assertEquals(0, dao.listUsers().size());
		
		dao.createUser(nick);
		
		//should return one record
		assertEquals(1, dao.listUsers().size());
		
		dao.createUser(sarah);
		//should return two records
		assertEquals(2, dao.listUsers().size());

		dao.createUser(alf);
		//should return three records
		assertEquals(3, dao.listUsers().size());
		
		dao.delete(1);
		//should return two records, nick was deleted
		assertEquals(2, dao.listUsers().size());
		
		dao.deleteAll();
		//should return zero records, all users were deleted
		assertEquals(0, dao.listUsers().size());
		
	}
	
	@Test
	public void recordCheckTest(){
		dao.createUser(nick);
		User user = dao.getUser(1);
		//User name should be Nickolas
		assertEquals("Nicolas", user.getName());
		//User last name should be Jonson
		assertEquals("Jonson", user.getLastName());
	}

	//Should throw exception if create the same records
	@Test (expected=ConstraintViolationException.class)
	public void repeatRecordTest(){
		dao.createUser(nick);
		dao.createUser(nick);
	}
	
	//Should return nothig if delete the same records
	@Test(expected = IllegalArgumentException.class)
	public void repeatDeleteTest(){
		dao.createUser(nick);
		dao.createUser(sarah);
		dao.delete(15);
		dao.delete(15);
	}
	
	//Should throw exception if try to get record that not exists
	@Test //(expected=EmptyResultDataAccessException.class)
	public void requestToUnexistedRecordTest(){
		dao.getUser(1);
	}
	
	@Test
	public void updateTest() throws Exception{
		dao.createUser(nick);
		User user = new User();
		user.setId(1);
		user.setName("John");
		user.setLastName("Moody");
		dao.update(user);
	}
	
	@Test( expected = IllegalArgumentException.class)
	public void createNullRecordTest(){
		dao.createUser(null);
	}
	
	@Test
	public void listUsersTest(){
		List<User> expected = new ArrayList<User>();
		dao.createUser(nick);
		dao.createUser(alf);
		dao.createUser(sarah);
		expected.add(nick);
		expected.add(alf);
		expected.add(sarah);
		List<User> actual = dao.listUsers();
		//Lists should contain equal number of records
		assertEquals( expected.size(), actual.size() );
		
	}
	
}