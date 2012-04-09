package com.clouway.jspservlet.catalog;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * DisplayComments class extends SimpleTagSupport.
 * This way the class is able to display every book from the List of books
 * when it encounters the "displayComments" tag in a specified .jsp page
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class DisplayComments extends SimpleTagSupport {
  
  private List comments;
  private String comment;
  
  public void setComments(List comments) {
    this.comments = comments;
  }
  
  public void setComment(String comment) {
    this.comment = comment;
  }
  
  public void doTag() throws JspException, IOException {

    for (Object comment : comments) {
      getJspContext().setAttribute(this.comment, comment);
      getJspBody().invoke(null);
    }
  }
}
