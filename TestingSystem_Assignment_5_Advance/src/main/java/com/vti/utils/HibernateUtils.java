package com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Member;
import com.vti.entity.Position;

/**
 * This class is .
 *
 * @Description: .
 * @Author: LDQuyet
 * @Create_Date: 2022/04/29
 * @Version: 1.0
 * @Modifier: LDQuyet
 * @Modifier_Date: 2022/04/29
 */
public class HibernateUtils {
	private static HibernateUtils instance;
	private SessionFactory sessionFactory;
	private Configuration configuration;

	public static HibernateUtils getInstance() {
		if (null == instance) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	/**
	 * Contructor for class HibernateUtils.
	 *
	 * @Description: .
	 * @Author: LDQuyet
	 * @Create_Date: 2022/04/29
	 * @Version: 1.0
	 * @Modifier: LDQuyet
	 * @Modifier_Date: 2022/04/29
	 */
	public HibernateUtils() {
		configure();
	}

	/**
	 * This method is.
	 *
	 * @Description: .
	 * @Author: LDQuyet
	 * @Create_Date: 2022/04/29
	 * @Version: 1.0
	 * @Modifier: LDQuyet
	 * @Modifier_Date: 2022/04/29
	 */

	private void configure() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Member.class);
	}

	private SessionFactory buildSessionFactory() {
		if (sessionFactory == null || sessionFactory.isClosed()) {
			StandardServiceRegistryBuilder standard = new StandardServiceRegistryBuilder();
			ServiceRegistry serviceRegistry = standard.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

	public Session openSession() {
		return buildSessionFactory().openSession();
	}

	public void closeSessionFactory() {
		if (sessionFactory != null && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}
}
