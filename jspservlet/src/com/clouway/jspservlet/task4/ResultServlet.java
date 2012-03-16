package com.clouway.jspservlet.task4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ResultServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    out.println("You came from servlet: " + request.getAttribute("servletName").toString());
  }
}
