package com.clouway.jspservlet.task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class CounterServlet extends HttpServlet {

  private Map<String, LinkCounter> linkCountersMap = new HashMap<String, LinkCounter>();

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();

    if (!linkCountersMap.containsKey(session.getId())) {

      LinkCounter linkCounter = new LinkCounter();
      linkCountersMap.put(session.getId(), linkCounter);
      linkCountersMap.get(session.getId()).add(request.getParameter("link"));
    } else {

      linkCountersMap.get(session.getId()).add(request.getParameter("link"));
    }

    session.setAttribute(request.getParameter("link"), linkCountersMap.get(session.getId()).getCount(request.getParameter("link")));
    response.sendRedirect("/jspservlet/task1/links.jsp");
  }
}
