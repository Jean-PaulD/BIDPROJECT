package repositories;

import domain.Bid;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public interface BidRepository {

    Bid create(Bid bid);

    Bid read(String id);

    Bid update(Bid bid);

    void delete(String id);
}
