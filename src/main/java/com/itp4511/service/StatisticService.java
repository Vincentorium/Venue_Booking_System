package com.itp4511.service;

import com.itp4511.dao.StatVenbookingcountDAO;
import com.itp4511.dao.VenueDAO;
import com.itp4511.domain.StatVenbookingcount;

import java.util.List;

public class StatisticService {

    private StatVenbookingcountDAO statVenbookingcountDAO=new StatVenbookingcountDAO();

    public List<StatVenbookingcount> getStatVenbookingcountDaily(String dateStart, String dateEnd) {




        return statVenbookingcountDAO.queryMulti(
                "SELECT   " +
                        "  v.venID,   " +
                        "  v.venName ,  " +
                        "  ses.sessionID,  " +
                        "  ses.sessionDate,  " +
                        "  booking_count.bookingCount,  " +
                        "  v.venBookingFee * booking_count.bookingCount AS bookingRevenue  " +
                        "FROM session AS ses  " +
                        "LEFT JOIN bookingrecord AS bkr ON bkr.bookID = ses.sessionFKbookingRecord  " +
                        "LEFT JOIN venue AS v ON ses.sessionCampus = v.venID  " +
                        "LEFT JOIN (  " +
                        "  SELECT   " +
                        "    ses2.sessionDate,  " +
                        "    ses2.sessionCampus,  " +
                        "    COUNT(bkr2.bookID) AS bookingCount  " +
                        "  FROM session AS ses2  " +
                        "  LEFT JOIN bookingrecord AS bkr2 ON bkr2.bookID = ses2.sessionFKbookingRecord  " +
                        "  WHERE ses2.sessionDate BETWEEN  \""+ dateStart+"\" and  \"" +dateEnd  +
                        "\"    AND ses2.sessionStatus = 1   " +
                        "    AND bkr2.bookStatus > 1  " +
                        "  GROUP BY ses2.sessionDate, ses2.sessionCampus  " +
                        ") AS booking_count ON booking_count.sessionDate = ses.sessionDate AND booking_count.sessionCampus = ses.sessionCampus  " +
                        "WHERE ses.sessionDate BETWEEN  \""+ dateStart+"\" and  \"" +dateEnd  +
                        "\" group by   " +
                        "ses.sessionDate,  " +
                        "ses.sessionCampus    " +
                        "ORDER BY ses.sessionID ASC;", StatVenbookingcount.class);

    }

    public List<StatVenbookingcount> getStatVenbookingCountRevenue(String dateStart, String dateEnd) {

        return statVenbookingcountDAO.queryMulti(
                "select v.venID, v.venName  , count( sessionID) as bookingCount, v.venBookingFee*count( sessionID) as bookingRevenue " +
                        "from bookingrecord as bkr " +
                        "left join session as ses on bkr.bookID = ses.sessionFKbookingRecord " +
                        "left join venue  as v on ses.sessionCampus =  v.venID " +
                        "where ses.sessionStatus=1 and bkr.bookStatus>1    and ses.sessionDate between  \""+ dateStart+"\" and  \"" +dateEnd  +
                        "\" group by  " +
                        "ses.sessionCampus " +
                        "Order by bookingRevenue ", StatVenbookingcount.class);

    }

}
