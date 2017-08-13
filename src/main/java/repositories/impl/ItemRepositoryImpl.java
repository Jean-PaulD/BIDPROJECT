package repositories.impl;

import domain.Item;
import repositories.ItemRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ItemRepositoryImpl implements ItemRepository {

    private static ItemRepositoryImpl respository = null;

    private Map<String, Item> itemTable;

    private ItemRepositoryImpl() {
        itemTable = new HashMap<String, Item>();
    }

    public static ItemRepositoryImpl getInstance(){
        if(respository==null)
            respository = new ItemRepositoryImpl();
        return respository;
    }

    public Item create(Item item) {
        itemTable.put(item.getid(),item);
        Item savedItem = itemTable.get(item.getid());
        return savedItem;
    }

    public Item read(String id) {
        Item item = itemTable.get(id);
        return item;
    }

    public Item update(Item item) {
        itemTable.put(item.getid(),item);
        Item savedItem = itemTable.get(item.getid());
        return savedItem;
    }

    public void delete(String id) {
        itemTable.remove(id);

    }
}

