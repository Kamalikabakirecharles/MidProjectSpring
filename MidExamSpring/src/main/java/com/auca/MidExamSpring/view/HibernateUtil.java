package com.auca.MidExamSpring.view;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.auca.MidExamSpring.model.Student;

import java.util.Properties;    


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	public static final String PERSISTENCE_UNIT_NAME = "YourPersistenceUnit";
	
	public static String getPersistenceUnitName() {
        return PERSISTENCE_UNIT_NAME;
    }
	
    public static SessionFactory getSession() {

        try {
            Configuration configuration = new Configuration();

            // Hibernate settings equivalent to hibernate.cfg.xml's properties
            Properties settings = new Properties();
            settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/middatabase?createDatabaseIfNotExist=true");
            settings.put("hibernate.connection.username", "root");
            settings.put("hibernate.connection.password", "12345");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

            settings.put(Environment.SHOW_SQL, "true");

			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			settings.put(Environment.HBM2DDL_AUTO, "create");

            // This helps to put all properties into our configuration
            configuration.addAnnotatedClass(Student.class);

                        
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate Java Config serviceRegistry created");
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sessionFactory;
    }

}
