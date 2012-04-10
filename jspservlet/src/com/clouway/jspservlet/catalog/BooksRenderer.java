package com.clouway.jspservlet.catalog;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * BooksRenderer class extends SimpleTagSupport.
 * This way the class is able to display every book from the List of books
 * when it encounters the "displayBooks" tag in a specified .jsp page
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class BooksRenderer extends SimpleTagSupport {

  private List books;
  private String book;
  private int currentPage;
  private int lastPage;
  private int range;

  public void setBooks(List books) {
    this.books = books;
  }

  public void setBook(String book) {
    this.book = book;
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

    for (Object book : books) {
      getJspContext().setAttribute(this.book, book);
      getJspBody().invoke(null);
    }
  }
}
