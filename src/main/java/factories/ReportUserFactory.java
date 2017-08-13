package factories;

import domain.ReportUser;
import domain.User;

import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-12.
 */
public class ReportUserFactory  {
    public static ReportUser getReportUser(Map<String, String> values, User user, int numberOfReports) {

        ReportUser reportUser = new ReportUser.Builder()
                .id(values.get("id"))
                .user(user)
                .username(values.get("userName"))
                .numberOfReports(numberOfReports)
                .build();

        return reportUser;
    }
}
