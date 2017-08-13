package factories;

import domain.CommentBid;
import domain.Item;
import domain.User;

import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-12.
 */
public class CommentBidFactory {

    public static CommentBid getCommentBid(Map<String, String> values, Item item, User user) {

        CommentBid commentBids = new CommentBid.Builder()
                .id(values.get("id"))
                .comment(values.get("comment"))
                .item(item)
                .itemId(values.get("itemId"))
                .username(values.get("userName"))
                .build();

        return commentBids;
    }
}
