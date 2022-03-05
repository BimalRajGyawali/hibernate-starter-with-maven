package me.personal.config;

import me.personal.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory != null){
            return sessionFactory;
        }
        var config = new Configuration();

        var properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/test");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");
        properties.put(Environment.SHOW_SQL, true);

        config.setProperties(properties);
        config.addAnnotatedClass(Customer.class);

        sessionFactory =  config.buildSessionFactory();

        return sessionFactory;
    }
}
