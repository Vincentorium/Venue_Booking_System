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
import ict.dbutils.UserDB;
import ict.dbutils.BrandsDB;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Vincent
 */

@WebServlet(name = "brandController", urlPatterns = {"/brandController"})

public class BrandController extends HttpServlet {

    private BrandsDB brandsDB;

    public void init() {
        brandsDB = new BrandsDB();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equalsIgnoreCase(action)) {
            ArrayList brands = brandsDB.getBrands();
            request.setAttribute("brands", brands);
            RequestDispatcher rd = this.getServletContext()
                    .getRequestDispatcher("/brands.jsp");
            rd.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("NO such22 action :" + action);
        }

    }
}
