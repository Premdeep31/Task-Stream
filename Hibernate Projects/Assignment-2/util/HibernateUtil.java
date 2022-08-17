package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entities.Customer;
import com.entities.Locker;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				
				settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				jdbc:sqlserver://localhost\\SQLEXPRESS:59410; databaseName=Impact_14
//				jdbc:sqlserver://localhost\\SQLEXPRESS:1433; databaseName=Impact_14; encrypt=true;trustServerCertificate=true
				settings.put(Environment.URL, "jdbc:sqlserver://localhost\\SQLEXPRESS:59410; databaseName=Impact_14; trustServerCertificate=true");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "password_123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Locker.class);
				configuration.addAnnotatedClass(Customer.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return sessionFactory;
	}
}
