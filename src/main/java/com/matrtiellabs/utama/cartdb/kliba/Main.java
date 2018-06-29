package com.matrtiellabs.utama.cartdb.kliba;

import com.matrtiellabs.utama.cartdb.kliba.configuration.HibernateSessionFactory;
import com.matrtiellabs.utama.cartdb.kliba.entity.Item;
import com.matrtiellabs.utama.cartdb.kliba.entity.Settings;
import com.matrtiellabs.utama.cartdb.kliba.repository.ItemRepository;
import com.matrtiellabs.utama.cartdb.kliba.repository.ItemService;
import com.matrtiellabs.utama.cartdb.kliba.repository.SettingsRepository;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {


        Session theSession = null;
        theSession = HibernateSessionFactory.getSessionFactory().openSession();

//        SettingsRepository sr = new SettingsRepository(theSession);
//        System.out.println("-----------getSettings()-----below------------");
//        System.out.println(sr.getSettings());
//        theSession.close();
//        HibernateSessionFactory.closeSessionFactory();


//        theSession = HibernateSessionFactory.getSessionFactory().openSession();
//        ItemRepository ir = new ItemRepository(theSession);
//        System.out.println("-----------getItem()-----below------------");
//        System.out.println("getItems() = " +
//        ir.getItems());
//        theSession.close();
//        HibernateSessionFactory.closeSessionFactory();

        ItemService is = new ItemService(theSession);
        try {
//            is.getTotalPrice();
            is.averageItemPrice();
            is.getCheckoutPrice();
            is.writeItemList("/home/kliba/dev/exam5Origin/src/main/sql/test.txt");

//            is.getSettingList();
//            is.getItemList();
        } catch (Exception e) {
            e.getMessage();
        }
        finally {
            if (theSession != null) {
                theSession.close();
            }
            HibernateSessionFactory.closeSessionFactory();
        }

    }
}
