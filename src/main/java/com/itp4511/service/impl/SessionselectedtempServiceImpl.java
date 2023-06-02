package com.itp4511.service.impl;

import com.itp4511.dao.SessionselectedtempDAO;
import com.itp4511.dao.impl.SessionselectedtempDAOImpl;
import com.itp4511.domain.Sessionselectedtemp;
import com.itp4511.service.SessionselectedtempService;

import java.util.List;

public class SessionselectedtempServiceImpl implements SessionselectedtempService {

    private SessionselectedtempDAOImpl sessionselectedtempDAOImpl = new SessionselectedtempDAOImpl();
    @Override
    public Integer addSessionTemp(Integer sessionTempID, Integer memberID) {
         return   sessionselectedtempDAOImpl.addSessionTemp(new Sessionselectedtemp(null,sessionTempID,memberID));

    }

    @Override
    public Integer delSessionTemp(Integer sessionTempID) {
        return null;
    }

    @Override
    public Integer emptySessionTempByMemberID(Integer memberID) {
        return null;
    }

    @Override
    public List<Sessionselectedtemp> getSessionTempByMemberID(Integer memberID) {
        return null;
    }
}
