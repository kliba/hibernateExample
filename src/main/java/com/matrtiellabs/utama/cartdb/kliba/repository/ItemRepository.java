package com.matrtiellabs.utama.cartdb.kliba.repository;

import com.matrtiellabs.utama.cartdb.kliba.entity.Item;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ItemRepository {

    private static final Logger logger = LoggerFactory.getLogger("ItemRepository Class ");
    private Session theSession;

    public ItemRepository(Session theSession) {
        this.theSession = theSession;
    }

    public List<Item> getItems() {
        try {
            logger.info("theSession.beginTransaction() started executing");
            theSession.beginTransaction();
            Criteria criteria = theSession.createCriteria(Item.class);
            List<Item> list = criteria.list();
            return list;
        } finally {
            logger.info("theSession.getTransaction().commit() starts committing");
            theSession.getTransaction().commit();
            logger.info("theSession.getTransaction().commit() has been committed");
        }
    }

}
