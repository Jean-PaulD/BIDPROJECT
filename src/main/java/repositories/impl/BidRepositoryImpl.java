package repositories.impl;

import domain.Bid;
import repositories.BidRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class BidRepositoryImpl implements BidRepository {
    
    private static BidRepositoryImpl respository = null;

    private Map<String, Bid> bidTable;

    private BidRepositoryImpl() {
        bidTable = new HashMap<String, Bid>();
    }

    public static BidRepositoryImpl getInstance(){
        if(respository==null)
            respository = new BidRepositoryImpl();
        return respository;
    }

    public Bid create(Bid bid) {
        bidTable.put(bid.getid(),bid);
        Bid savedBid = bidTable.get(bid.getid());
        return savedBid;
    }

    public Bid read(String id) {
        Bid bid = bidTable.get(id);
        return bid;
    }

    public Bid update(Bid bid) {
        bidTable.put(bid.getid(),bid);
        Bid savedBid = bidTable.get(bid.getid());
        return savedBid;
    }

    public void delete(String id) {
        bidTable.remove(id);

    }
}


