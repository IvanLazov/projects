package com.clouway.jspservlet.task3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RedirectServletTwo extends HttpServlet {

  private List<String> visitedLinks = new ArrayList<String>();
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    setVisitedPage(request, request.getSession());

    if (request.getParameter("option") != null) {
      response.sendRedirect("/jspservlet/task3/" + request.getParameter("option").toString());
    }
  }

  private void setVisitedPage(HttpServletRequest request, HttpSession session) {

    if (!visitedLinks.contains(request.getParameter("option"))) {
      visitedLinks.add(request.getParameter("option").toString());
      session.setAttribute("option", false);
    } else {
      visitedLinks.add(request.getParameter("option").toString());
      session.setAttribute("option", true);
    }
  }

}
