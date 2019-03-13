package us.Lab4.model;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {
    private List<Item> itemCatalog = new ArrayList<>();
    private int nextProductNumber;

    public ItemCatalog() {
        nextProductNumber = 1;
        itemCatalog.add(new Item(nextProductNumber++,"Gardevoir Plush",44.75,false,"THe best pokemon in Plush form!","images/Beechams_Pills.png"));
        itemCatalog.add(new Item(nextProductNumber++,"Nintendo Switch",300.00,true,"GAme on the go and on the TV. ITs the nintendo switch. what more do you want?","images/daffy.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,"Homework cheats", 71.22,true,"HEre is your answers to that math test you new studied for.","images/dalby.png"));
        itemCatalog.add(new Item(nextProductNumber++,"Little Big Battletoads",17.17,true,"It's another Battleotoads game.","images/hadacal.png"));
}

    public List<Item> getItemCatalog() {
        return itemCatalog;
    }

    public List<Item> getFeaturedItemCatalog() {
        List<Item> item = new ArrayList<>();

        for(Item i: itemCatalog) {
            if (i.isFeatured()) {
                item.add(i);
            }
        }
        return item;
    }
    public Item getSingleItem(int itemNum) {
        Item item=null;

        for(Item i: itemCatalog) {
            if (i.getProductNumer() == itemNum) {
                return i;
            }
        }
        return item;
    }
}
