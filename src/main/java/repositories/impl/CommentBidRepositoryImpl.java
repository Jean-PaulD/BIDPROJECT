package repositories.impl;

import domain.CommentBid;
import repositories.CommentBidRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class CommentBidRepositoryImpl implements CommentBidRepository {

    private static CommentBidRepositoryImpl respository = null;

    private Map<String, CommentBid> bidTable;

    private CommentBidRepositoryImpl() {
        bidTable = new HashMap<String, CommentBid>();
    }

    public static CommentBidRepositoryImpl getInstance(){
        if(respository==null)
            respository = new CommentBidRepositoryImpl();
        return respository;
    }

    public CommentBid create(CommentBid bid) {
        bidTable.put(bid.getId(),bid);
        CommentBid savedCommentBid = bidTable.get(bid.getId());
        return savedCommentBid;
    }

    public CommentBid read(String id) {
        CommentBid bid = bidTable.get(id);
        return bid;
    }

    public CommentBid update(CommentBid bid) {
        bidTable.put(bid.getId(),bid);
        CommentBid savedCommentBid = bidTable.get(bid.getId());
        return savedCommentBid;
    }

    public void delete(String id) {
        bidTable.remove(id);

    }
}


