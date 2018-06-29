package com.matrtiellabs.utama.cartdb.kliba.configuration;

import com.matrtiellabs.utama.cartdb.kliba.entity.Item;
import com.matrtiellabs.utama.cartdb.kliba.entity.Settings;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateSessionFactory {

    private static final Logger logger = LoggerFactory.getLogger("HibernateSessionFactory Class ");
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Item.class);
            configuration.addAnnotatedClass(Settings.class);
            sessionFactory = configuration.buildSessionFactory();
            logger.info("Session factory has been built");
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory == null) {
            try {
                logger.error("IllegalAccessException because the SessionFactory has not been initialized.");
                throw new IllegalAccessException("SessionFactory not yet initialized, cannot close it");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        logger.info("sessionFactory is closing");
        sessionFactory.close();
    }
}
