package com.matrtiellabs.utama.cartdb.kliba.repository;

import com.matrtiellabs.utama.cartdb.kliba.entity.Settings;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SettingsRepository {

    private Session theSession;
    private static final Logger logger = LoggerFactory.getLogger("SettingsRepository Class ");

    public SettingsRepository(Session theSession) {
        this.theSession = theSession;
    }

    public Settings getSettings() {
        try {
            logger.info("theSession.beginTransaction() is starting executing");
            theSession.beginTransaction();
            Criteria criteria = theSession.createCriteria(Settings.class);
            List<Settings> list = criteria.list();
            return  list.get(0);
        } finally {
            logger.info("theSession.getTransaction().commit() started committing");
            theSession.getTransaction().commit();
            logger.info("theSession.getTransaction().commit() has been committed");
        }
    }
}
