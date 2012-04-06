package com.clouway.jspservlet.catalog;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class ForTag extends SimpleTagSupport {

  private Object[] books;
  private String bookName;

  private int currentPage;
  private int lastPage;
  private int range;  
  

  public void setBooks(Object[] books) {
    this.books = books;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }
  
  public void setCurrentPage(String currentPage) {
    this.currentPage = Integer.parseInt(currentPage);
  }
  
  public void setRange(String range) {
    this.range = Integer.parseInt(range);
  }
  
  public void setLastPage(String lastPage) {
    this.lastPage = Integer.parseInt(lastPage);
  }
  
  public void doTag() throws JspException, IOException {

    for (int i = 0; i < range; i++) {
        getJspContext().setAttribute(bookName, books[(currentPage * range) - (range - i)]);
        getJspBody().invoke(null);
    }
  }
  
//  private int getLastPage() {
//
//    if (books.length % range != 0) {
//      lastPage = (books.length / range) + 1;
//    } else {
//      lastPage = books.length / range;
//    }
//    return lastPage;
//  }
}
