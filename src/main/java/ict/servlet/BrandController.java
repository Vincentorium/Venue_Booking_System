package ict.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import ict.bean.UserInfo;
import ict.dbutils.UserDB;
import ict.dbutils.BrandsDB;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Vincent
 */

@WebServlet(name = "brandController", urlPatternqs = {"/brandController"})

public class BrandController extends HttpServlet {

    private BrandsDB brandsDB;

    public void init() {
        brandsDB = new BrandsDB();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {









        System.out.println("In do post method of Add Image servlet.");
        Part file=request.getPart("image");

//        String imageFileName=file.getSubmittedFileName();  // get selected image file name

        String cd = file.getHeader("Content-Disposition");
//截取不同类型的文件需要自行判断
        String imageFileName = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);


        System.out.println("Selected Image File Name : "+imageFileName);

        String uploadPath="./"+imageFileName;  // upload path where we have to upload our actual image
        System.out.println("Upload Path : "+uploadPath);

        // Uploading our selected image into the images folder





        try
        {

            FileOutputStream fos=new FileOutputStream(uploadPath);
            InputStream is=file.getInputStream();

            byte[] data=new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();



        }

        catch(Exception e)
        {
            e.printStackTrace();
        }



        request.setAttribute("imageFileName","Successfully upload"  );

        request.setAttribute("url","login.jsp");
        RequestDispatcher rd;

        rd = getServletContext().getRequestDispatcher("/errMessage.jsp");

        rd.forward(request, response);
        //**********************

        //getting database connection (jdbc code)













        String action = request.getParameter("action");
        if ("list".equalsIgnoreCase(action)) {
            ArrayList brands = brandsDB.getBrands();
            request.setAttribute("brands", brands);
              rd = this.getServletContext()
                    .getRequestDispatcher("/brands.jsp");
            rd.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("NO such22 action :" + action);
        }

    }
}
