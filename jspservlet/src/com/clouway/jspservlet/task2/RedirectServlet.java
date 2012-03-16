package com.clouway.jspservlet.task2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RedirectServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setAttribute("pageName", request.getParameter("pageName"));
    request.getRequestDispatcher("/task2/result.jsp").forward(request, response);
  }
}
