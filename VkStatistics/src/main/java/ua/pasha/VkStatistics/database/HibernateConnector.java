package ua.pasha.VkStatistics.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateConnector {
	
	private static final SessionFactory sf;
	
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getFactory(){
		return sf;
	}
	
}
