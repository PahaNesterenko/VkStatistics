package ua.pasha.VkStatistics.database;

import java.util.List;

import org.hibernate.Session;

import ua.pasha.VkStatistics.pojo.User;

public class HibernateUserDaoImpl implements UserDAO {

	Session ses = null;

	@Override
	public User getUser(Integer id) {
		User user;
		try {
			ses = HibernateConnector.getFactory().openSession();
			ses.beginTransaction();
			user = (User) ses.get(User.class, id);
			ses.getTransaction().commit();
		} finally {
			if (ses != null && ses.isOpen()) {
				System.out.println("closing session");
				ses.close();
			}
		}
		return user;
	}

	@Override
	public void createUser(User user) {
		try {
			ses = HibernateConnector.getFactory().openSession();
			ses.beginTransaction();
			ses.save(user);
			ses.getTransaction().commit();
		} finally {
			if (ses != null && ses.isOpen()) {
				System.out.println("closing session");
				ses.close();
			}
		}
	}

	@Override
	public void delete(Integer id) {
		User user = getUser(id);
		try {
			ses = HibernateConnector.getFactory().openSession();
			ses.beginTransaction();
			ses.delete(user);
			ses.getTransaction().commit();
		} finally {
			if (ses != null && ses.isOpen()) {
				System.out.println("closing session");
				ses.close();
			}
		}
	}

	@Override
	public void deleteAll() {
		List<User> users;

		try {
			ses = HibernateConnector.getFactory().openSession();
			ses.beginTransaction();
			users = listUsers();
			if (users.size() > 0) {
				for (User userToDelete : users) {
					ses.delete(userToDelete);
				}
			}
			ses.getTransaction().commit();
		} finally {
			if (ses != null && ses.isOpen()) {
				System.out.println("closing session");
				ses.close();
			}

		}
	}

	@Override
	public void update(User u) throws Exception {
		try {
			ses = HibernateConnector.getFactory().openSession();
			ses.beginTransaction();
			ses.saveOrUpdate(u);
			ses.getTransaction().commit();
		} finally {
			if (ses != null && ses.isOpen()) {
				System.out.println("closing session");
				ses.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		List<User> result;
		try {
			ses = HibernateConnector.getFactory().openSession();
			ses.beginTransaction();
			result = (List<User>) ses.createCriteria(User.class).list();
			ses.getTransaction().commit();
		} finally {
			if (ses != null && ses.isOpen()) {
				System.out.println("closing session");
				ses.close();
			}
		}
		return result;
	}

}
