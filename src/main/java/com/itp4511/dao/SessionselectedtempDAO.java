package com.itp4511.dao;

import com.itp4511.domain.Sessionselectedtemp;

import java.util.List;

public interface SessionselectedtempDAO {




    Integer addSessionTemp(Sessionselectedtemp sessionselectedtemp);

    Integer delSessionTemp(Integer sessionTempID);


    Integer emptySessionTempByMemberID(Integer memberID);

    List<Sessionselectedtemp> getSessionTempByMemberID(Integer memberID);
}
