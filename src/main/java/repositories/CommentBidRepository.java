package repositories;

import domain.CommentBid;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public interface CommentBidRepository {

    CommentBid create(CommentBid obj);

    CommentBid read(String id);

    CommentBid update(CommentBid obj);

    void delete(String id);
}
