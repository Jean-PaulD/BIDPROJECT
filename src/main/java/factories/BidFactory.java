package factories;

import domain.Bid;
import domain.Item;
import domain.User;

import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-12.
 */
public class BidFactory {

    public static Bid getBid(Map<String, String> values, Item item, User user) {

        Bid bids = new Bid.Builder()
                .id(values.get("id"))
                .itemID(values.get("itemID"))
                .item(item)
                .user(user)
                .username(values.get("userName"))
                .build();

        return bids;
    }
}
