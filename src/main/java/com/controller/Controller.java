package com.controller;

import com.model.MyBigNumber;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("Kết quả cộng hai số lớn: ");
            String numberone = request.getParameter("number1");
            String numbertwo = request.getParameter("number2");
//            String submitadd = request.getParameter("add");
            String result = MyBigNumber.sum(numberone, numbertwo);
            StringBuilder stringbuild = new StringBuilder();
            int len = result.length();
            int i = 0;
            while(i<len){
                if(i+130<len){
                stringbuild.append(result.substring(i,i+130));
                stringbuild.append("</br>");
                }
                else{
                stringbuild.append(result.substring(i));
                }
                i = 130+i;
            }
            
            String stringBuildline = stringbuild.toString(); 
            out.println(stringBuildline);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
