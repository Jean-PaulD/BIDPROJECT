package services;

import domain.Bid;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public interface BidService {

    Bid create(Bid obj);
    Bid read(String id);
    Bid update(Bid obj);
    void delete(String id);
    
}
