package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CatalogUserService provides method for
 * - returning a Book object with specified bookId
 * - returning the number of pages needed to display all books currently saved in the database
 * - returning a List of Books, which will be displayed
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CatalogUserService {

  /**
   * Returns a Book with specified bookId
   *
   * @param bookId - bookId
   * @return - Book object
   */
  Book getRequestBook(int bookId);

  /**
   * Returns the number of pages needed to display all books
   * currently saved in the database
   *
   * @param range - the number of books per page
   * @return - number of pages
   */
  int getNumberOfPages(int range);

  /**
   * Returns a List of Book object which will be displayed
   *
   * @param currentPage - the page on which the user is currently on
   * @param range - the number of books per page
   * @return - List of Book objects
   */
  List getListOfBooks(int currentPage, int range);
}
