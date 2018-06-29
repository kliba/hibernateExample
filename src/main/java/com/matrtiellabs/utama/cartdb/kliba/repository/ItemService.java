package com.matrtiellabs.utama.cartdb.kliba.repository;

import com.matrtiellabs.utama.cartdb.kliba.entity.Item;
import com.matrtiellabs.utama.cartdb.kliba.entity.Settings;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger("ItemService Class ");
    Session theSession = null;

    public ItemService(Session theSession) {
        this.theSession = theSession;
    }

    private List<Settings> getSettingList() {
        List<Settings> settingsList = new ArrayList<>();

        SettingsRepository settingsRepository = new SettingsRepository(theSession);
        settingsList.add(settingsRepository.getSettings());

        //       System.out.println("settingsRepository = " + settingsList);
        logger.info("getSettingList() invoked");
        return settingsList;
    }

    private List<Item> getItemList() {
        List<Item> itemList = new ArrayList<>();
        ItemRepository itemRepository = new ItemRepository(theSession);

        for (int i = 0; i < itemRepository.getItems().size(); i++) {
            itemList.add(itemRepository.getItems().get(i));
        }
//        System.out.println("-----------------------------------------------------------");
//        System.out.println("itemRepository = " + itemList);
        logger.info("getItemList() invoked");
        return itemList;
    }

    public Integer getTotalPrice() {
        Integer totalPrice = 0;
        for (int i = 0; i < getItemList().size(); i++) {
            totalPrice += (getItemList().get(i).getQuantity() * getItemList().get(i).getPricePerPiece());
        }
//        System.out.println("totalPrice = " + totalPrice);
        logger.info("getTotalPrice() invoked");
        return totalPrice;
    }

    public Double averageItemPrice() {
        Double avaragePrice = 0d;
        Double quantity = 0d;
        Integer totalPrice = getTotalPrice();

        for (int i = 0; i < getItemList().size(); i++) {
            quantity += getItemList().get(i).getQuantity();
        }

        avaragePrice = (totalPrice / quantity);
        //       System.out.println("avaragePrice = " + avaragePrice);
        logger.info("averageItemPrice() invoked");
        return avaragePrice;
    }

    public Integer getCheckoutPrice() {
        Double checkOutPrice = 0d;
        Integer totalPrice = getTotalPrice();
        Integer subTotal = 0;
        Integer vat = getSettingList().get(0).getVat();
        Integer penality = 0;

        //       which is
        //       i. the total price +
        //       ii. plus the overweight charge which is the overweight penalty for
        // every kg over the weight limit +
        //      iii. the calculated VAT
        for (int i = 0; i < getItemList().size(); i++) {
            Integer totalWeight = 0;
            totalWeight = getItemList().get(i).getQuantity() * getItemList().get(i).getKgPerPiece();
            if (totalWeight > getSettingList().get(0).getWeightLimit()) {
                Integer subPenality = totalWeight - getSettingList().get(0).getWeightLimit();
                penality += subPenality * getSettingList().get(0).getOwPenaltyPerKG();
            }
        }
        subTotal = penality + totalPrice;
//        System.out.println("subTotal = " + subTotal);
        checkOutPrice = subTotal.doubleValue() * (vat.doubleValue() / 100d);

//        System.out.println("checkoutPrice: " + (checkOutPrice.intValue() + subTotal));
        logger.info("getCheckoutPrice() invoked");
        return checkOutPrice.intValue() + subTotal;
    }

    public void writeItemList(String path) {
        String toWrite = "";
        for (int i = 0; i < getItemList().size(); i++) {
            toWrite += getItemList().get(i).getName() + ";"
                    + getItemList().get(i).getQuantity() + ";"
                    + (getItemList().get(i).getQuantity() * getItemList().get(i).getPricePerPiece())
                    + "\n";
        }

        Path myPath = Paths.get(path);
        try {
            Files.write(myPath, toWrite.getBytes());
        } catch (IOException e) {
            logger.error("writeItemList() invoked and the pah is not valid ot the file is not existing");
            e.printStackTrace();
        }
    }


}
