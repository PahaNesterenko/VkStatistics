package ua.pasha.VkStatistics;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.pasha.VkStatistics.database.UserDaoImpl;
import ua.pasha.VkStatistics.pojo.User;

public class UserDaoImplTest {

	@Test
	public void test() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("UserDaoContext.xml");
		
		UserDaoImpl dao = (UserDaoImpl) context.getBean("UserDaoImpl");
		String table = "test_users";
		
		User nick = new User();
		nick.setId(1);
		nick.setName("Nicolas");
		
		User sarah = new User();
		sarah.setId(2);
		sarah.setName("Sarah");
		
		//should return zero records
		assertEquals(0, dao.listUsers().size());
		
		dao.createUser(nick);
		
		//should return one record
		assertEquals(1, dao.listUsers().size());
		
		
	}

}
