package com.itp4511.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itp4511.domain.*;
import com.itp4511.service.*;
import com.itp4511.utils.Utility;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.io.FilenameUtils.getExtension;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Vincent
 */
@WebServlet(name = "otherController", urlPatterns = {"/otherController"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class OtherController extends HttpServlet {

    private BookingRecordService bookingRecordService = new BookingRecordService();


        protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //   Part fileName = request.getPart("image");

            String uploadPath= null;  // upload path where we have to upload our actual image

            System.out.println("In do post method of Add Image servlet.");
            Part file = request.getPart("image");

//        String imageFileName=file.getSubmittedFileName();  // get selected image file name

            String cd = file.getHeader("Content-Disposition");
//截取不同类型的文件需要自行判断
            String imageFileName = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);


            System.out.println("Selected Image File Name : "+imageFileName);

            uploadPath = "./"+imageFileName;
            System.out.println("Upload Path : "+uploadPath);
            // 获取文件部分（file part）
            Part filePart = request.getPart("testForm"); // "file" 是 HTML 表单字段的名称

            // 获取文本部分（text part）
            String fileName = request.getParameter("image"); // "name" 是 HTML 表单字段的名称

            //
       ///     String fileName = extractFileName(filePart);
            String extension = getExtension(fileName);

            // 构建上传目标路径（destination path）
            String uploadDir = "/path/to/uploads";
            String filePath = uploadDir + File.separator + UUID.randomUUID().toString() + "." + extension;

            // 将文件写入磁盘
            filePart.write(filePath);

            // 发送响应给客户端
            response.setContentType("text/html");
            response.getWriter().println("File " + fileName + " has been uploaded successfully!");
        }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String uploadPath= null;  // upload path where we have to upload our actual image

            System.out.println("In do post method of Add Image servlet.");
        Part file = request.getPart("image");

            String id=request.getParameter("id");
//        String imageFileName=file.getSubmittedFileName();  // get selected image file name

            String cd = file.getHeader("Content-Disposition");

        String imageFileName = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);


            System.out.println("Selected Image File Name : "+imageFileName);


        uploadPath = "./uploads/"+imageFileName;
//            uploadPath = "./uploads/"+imageFileName;
            System.out.println("Upload Path : "+uploadPath);




        try
        {


            FileOutputStream fos=new FileOutputStream(uploadPath);
            InputStream is=file.getInputStream();

            byte[] data=new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            boolean isSent=bookingRecordService.updateBookingImgnfoByMemberID(Integer.parseInt(request.getParameter("id")),imageFileName);


      //**********************

        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //getting database connection (jdbc code)


    }
}
