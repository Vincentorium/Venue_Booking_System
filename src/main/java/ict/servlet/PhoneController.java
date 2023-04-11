package ict.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ict.bean.UserInfo;
import ict.bean.Phone;

import ict.dbutils.UserDB;
import ict.dbutils.BrandsDB;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "getPhone", urlPatterns = {"/getPhones"})

public class PhoneController extends HttpServlet {

    private BrandsDB brandsDB;

    public void init() {
        brandsDB = new BrandsDB();
    }
  
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String brand = request.getParameter("brand");
          
        ArrayList<Phone> phoneList = null;

        //1.處理邏輯
        if (!brand.isEmpty()) {
            
            //2.保存處理後的結果
            phoneList=brandsDB.getPhonesByBrand(brand);           
            request.setAttribute("phoneList", phoneList);

            //3.傳送結果到view頁面
            RequestDispatcher rd = this.getServletContext()
                 .getRequestDispatcher("/phoneList.jsp");
            rd.forward(request, response);
        
        
        } else {
            PrintWriter out = response.getWriter();
            out.println("NO such brand :" + brand);
        }
    }
}
