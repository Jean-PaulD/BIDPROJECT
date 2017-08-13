package services.Impl;

import domain.Bid;
import repositories.BidRepository;
import repositories.impl.BidRepositoryImpl;
import services.BidService;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class BidServiceImpl implements BidService {

    private static BidServiceImpl service = null;

    BidRepository repository = BidRepositoryImpl.getInstance();

    public static BidServiceImpl getInstance(){
        if(service == null)
            service = new BidServiceImpl();
        return service;
    }

    public Bid create(Bid obj) {
        return repository.create(obj);
    }

    public Bid read(String id) {
        return repository.read(id);
    }

    public Bid update(Bid obj) {
        return repository.update(obj);
    }

    public void delete(String id) {
        repository.delete(id);

    }
    
}
