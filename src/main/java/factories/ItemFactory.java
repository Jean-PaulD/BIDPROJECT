package factories;

import domain.Item;
import domain.User;

import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-12.
 */
public class ItemFactory {

    public static Item getItem(Map<String, String> values,
                               double valueOfItem,
                               User user) {


        Item items = new Item.Builder()
                .id(values.get("id"))
                .description(values.get("description"))
                .comment(values.get("comment"))
                .currentBidOwner(values.get("highestBidder"))
                .username(values.get("userName"))
                .itemValue(valueOfItem)
                .build();

        return items;
    }
}
