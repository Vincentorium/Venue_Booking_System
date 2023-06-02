package com.itp4511.dao.impl;

import com.itp4511.dao.BasicDAO;
import com.itp4511.domain.Sessionselectedtemp;

import java.util.List;

public class SessionselectedtempDAOImpl extends BasicDAO<Sessionselectedtemp> implements com.itp4511.dao.SessionselectedtempDAO {


    @Override
    public Integer addSessionTemp(Sessionselectedtemp s) {

        return update("INSERT INTO `sessionselectedtemp`(`tempID`, `tempMemberID`, `tempSessionID`) VALUES (null,?,?)",
             s.getTempMemberId(),s.getTempSessionId());
    }

    @Override
    public Integer delSessionTemp(Integer sessionTempID) {
        return update("DELETE FROM `sessionselectedtemp` WHERE tempSessionID = ?",
                sessionTempID);
    }

    @Override
    public Integer emptySessionTempByMemberID(Integer memberID) {
        return update("DELETE FROM `sessionselectedtemp` WHERE tempMemberID = ?",
                memberID);
    }

    @Override
    public List<Sessionselectedtemp> getSessionTempByMemberID(Integer memberID) {



        return  queryMulti("SELECT * FROM `sessionselectedtemp` WHERE tempMemberID = ?", Sessionselectedtemp.class,memberID);
    }
}
