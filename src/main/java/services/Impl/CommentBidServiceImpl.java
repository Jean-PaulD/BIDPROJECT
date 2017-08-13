package services.Impl;


import domain.CommentBid;
import repositories.CommentBidRepository;
import repositories.impl.CommentBidRepositoryImpl;
import services.CommentBidService;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class CommentBidServiceImpl implements CommentBidService {

    private static CommentBidServiceImpl service = null;

    CommentBidRepository repository = CommentBidRepositoryImpl.getInstance();

    public static CommentBidServiceImpl getInstance(){
        if(service == null)
            service = new CommentBidServiceImpl();
        return service;
    }

    public CommentBid create(CommentBid obj) {
        return repository.create(obj);
    }

    public CommentBid read(String id) {
        return repository.read(id);
    }

    public CommentBid update(CommentBid obj) {
        return repository.update(obj);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
