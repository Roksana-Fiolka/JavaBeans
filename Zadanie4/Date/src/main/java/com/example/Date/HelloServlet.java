package com.example.Date;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

     response.setContentType("text/html");
     PrintWriter out = response.getWriter();
     Date dt = new Date();
     out.println("Today's date:" + dt.toString());
    }

    public void destroy() {
    }
}