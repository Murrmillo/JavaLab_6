package com.ksu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        //getParameter() uses ISO-8559-1 instead of UTF-8.
        request.setCharacterEncoding("UTF-8"); // решение проблемы с  кодировкой
        String author = request.getParameter("author");



        try {

            writer.println("<p>Author: " + author + "</p>");
        } finally {
            writer.close();
        }
    }
}