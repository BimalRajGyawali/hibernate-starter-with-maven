package me.personal;

import me.personal.config.HibernateConfig;

public class HibernateApplication {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate");
        System.out.println(HibernateConfig.getSessionFactory());
    }
}
