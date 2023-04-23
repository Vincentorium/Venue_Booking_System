package com.itp4511.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ict.dbutils.BrandsDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "handlePic", urlPatterns = {"/handlePic"})

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
            out.println("NO such action :" + action);
        }

    }



    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1)
                        .trim()
                        .replace("\"", "");
            }
        }
        return null;
    }

}
