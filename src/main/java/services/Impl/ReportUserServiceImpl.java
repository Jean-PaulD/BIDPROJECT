package services.Impl;

import domain.ReportUser;
import repositories.ReportUserRepository;
import repositories.impl.ReportUserRepositoryImpl;
import services.ReportUserService;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ReportUserServiceImpl implements ReportUserService {

    private static ReportUserServiceImpl service = null;

    ReportUserRepository repository = ReportUserRepositoryImpl.getInstance();

    public static ReportUserServiceImpl getInstance() {
        if (service == null)
            service = new ReportUserServiceImpl();
        return service;
    }

    public ReportUser create(ReportUser obj) {
        return repository.create(obj);
    }

    public ReportUser read(String id) {
        return repository.read(id);
    }

    public ReportUser update(ReportUser obj) {
        return repository.update(obj);
    }

    public void delete(String id) {
        repository.delete(id);

    }

}