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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static final Logger LOG = LoggerFactory.getLogger(OtherController.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int bookingID = -1;

        if (ServletFileUpload.isMultipartContent(request)) {

            LOG.debug("Confirm the content is multi one");

            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

            //new a object to handle content
            ServletFileUpload servletFileUpload =
                    new ServletFileUpload(diskFileItemFactory);
            //handle chinese input
            servletFileUpload.setHeaderEncoding("utf-8");

            try {
                //parse the content into a list with attribute relating to form dom
                List<FileItem> list = servletFileUpload.parseRequest(request);

                for (FileItem fileItem : list) {
                    LOG.debug("Handle the item " + fileItem.toString());


                    if (fileItem.isFormField()) {//如果是true就是文本 input text
                        LOG.debug("Entering conditional statement to check and confirm file is text. ");


                        //bookingID= fileItem.getString("utf-8"); //name of pic when upload :文件名
                        bookingID = Integer.parseInt(fileItem.getString());
                        LOG.debug("bookingID=" + bookingID);

                    } else {//是一个文件
                        LOG.debug("Entering conditional statement to check and confirm element is file. ");

                         String name = fileItem.getName(); //輸入的名字

                        //get the name of input
                        if (fileItem.getFieldName().equals("image")) {
                            LOG.debug("Name of file upload=" + name);
                        }


                        String fileRealPath = "K:\\IT\\Project\\ITP4511_EA_PROJECT\\src\\main\\webapp\\uploads\\";

                        File fileRealPathDirectory = new File(fileRealPath + Utility.getYearMonthDay());

                        if (!fileRealPathDirectory.exists()) {
                            try {
                                if (fileRealPathDirectory.mkdirs()) {

                                    LOG.debug("File " + fileRealPathDirectory + " created successfully");
                                } else {
                                    LOG.debug("File " + fileRealPathDirectory + " could not be created");
                                }
                            } catch (Exception e) {
                                LOG.error("An I/O error occurred while creating the directory: ", e);
                            }
                        }


                        name = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_" + name;
                        String fileFullPath = fileRealPathDirectory + "/" + name;
                        fileItem.write(new File(fileFullPath));// how to see if write successfully

                        LOG.debug("The path for saving the file is " + fileRealPathDirectory);


                        if (bookingID != -1) {
                            try {
                                bookingRecordService.updateBookingImgnfoByMemberID(bookingID, (Utility.getYearMonthDay() + name));
                                LOG.debug("Successfully Update the book receipt to bookingID: "+ bookingID +" with path+receipt: "+ (Utility.getYearMonthDay() + name) );
                            } catch (NumberFormatException e) {
                                LOG.debug("Fail to update the book receipt, err info is ", e);
                            }
                        }


                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("upload successfully~");


                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Not a file .");
        }
    }

}
