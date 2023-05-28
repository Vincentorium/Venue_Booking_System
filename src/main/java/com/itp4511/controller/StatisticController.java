package com.itp4511.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itp4511.domain.StatVenbookingcount;
import com.itp4511.domain.User;
import com.itp4511.service.StatisticService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import com.itp4511.utils.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Vincent
 */
@WebServlet(name = "statisticController", urlPatterns = {"/statisticController"})

public class StatisticController extends HttpServlet {



    private StatisticService statisticService = new StatisticService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        Gson gsonHandleFloat = new GsonBuilder()
                .serializeSpecialFloatingPointValues()
                .create();

        int type =  Integer.parseInt(request.getParameter("type"));

            //region Case : check user account

                switch (type) {

                    case 1:





                        try {
                            // List<BookingInfo_MM> displaySessionByID = sessionService.displaySessionByID(id);

                            String dateStart=request.getParameter("date_s_0");
                            String dateEnd=request.getParameter("date_e_0");
                            List<StatVenbookingcount> statVenbookingcount = statisticService.getStatVenbookingCountRevenue(dateStart,dateEnd);

                            String json=gsonHandleFloat.toJson(statVenbookingcount);



                               response.getWriter().write(json);

                        } catch (IOException e) {
                            e.printStackTrace();

                        }

                        break;
                    case 2:


                        try {


                            String dateStart=request.getParameter("date_s_0");
                            String dateEnd=request.getParameter("date_e_0");

                            List<StatVenbookingcount> statVenbookingcount2 = statisticService.getStatVenbookingcountDaily(dateStart,dateEnd);



                            if(statVenbookingcount2.size()==0 || checkCountZero(statVenbookingcount2) ){
                                throw new BusinessException("No Result Found Exception");
                            }

                            String json2=gsonHandleFloat.toJson(statVenbookingcount2);

                            response.getWriter().write(json2);

                        } catch (BusinessException  e) {

                            response.getWriter().write(e.getMessage());



                        }
                        break;


                }



    }

    public boolean checkCountZero(List<StatVenbookingcount> cList){

        boolean isZeroExit=true;
        for(StatVenbookingcount o : cList ){

            if(o.getBookingCount()!=0)
                isZeroExit=false;

        }
        return isZeroExit;
    }
}




