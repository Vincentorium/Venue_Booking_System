package com.itp4511.service;

import com.itp4511.domain.Guest;
import com.itp4511.domain.Sessionselectedtemp;

import java.util.List;

public interface SessionselectedtempService {



    Integer addSessionTemp(Integer sessionTempID,Integer memberID);

    Integer delSessionTemp(Integer sessionTempID);


    Integer emptySessionTempByMemberID(Integer memberID);

    List<Sessionselectedtemp> getSessionTempByMemberID(Integer memberID);
}
