package services;

import domain.Item;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public interface ItemService {


    Item create(Item obj);
    Item read(String id);
    Item update(Item obj);
    void delete(String id);

}
