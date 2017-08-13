package repositories.impl;

import domain.ReportUser;
import repositories.ReportUserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ReportUserRepositoryImpl implements ReportUserRepository {

    private static ReportUserRepositoryImpl respository = null;

    private Map<String, ReportUser> reportUserTable;

    private ReportUserRepositoryImpl() {
        reportUserTable = new HashMap<String, ReportUser>();
    }

    public static ReportUserRepositoryImpl getInstance(){
        if(respository==null)
            respository = new ReportUserRepositoryImpl();
        return respository;
    }

    public ReportUser create(ReportUser reportUser) {
        reportUserTable.put(reportUser.getId(),reportUser);
        ReportUser savedReportUser = reportUserTable.get(reportUser.getId());
        return savedReportUser;
    }

    public ReportUser read(String id) {
        ReportUser reportUser = reportUserTable.get(id);
        return reportUser;
    }

    public ReportUser update(ReportUser reportUser) {
        reportUserTable.put(reportUser.getId(),reportUser);
        ReportUser savedReportUser = reportUserTable.get(reportUser.getId());
        return savedReportUser;
    }

    public void delete(String id) {
        reportUserTable.remove(id);

    }
}

