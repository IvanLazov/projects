package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CatalogDatabaseService interface provides method for
 * - returning a Book object with given bookId
 * - returning the number of books currently in the database
 * - returning a list of Books within a certain range
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CatalogDatabaseService {

  /**
   * Returns a Book object with given bookId
   *
   * @param bookId - bookId
   * @return - Book object
   */
  Book getBook(int bookId);

  /**
   * Returns the number of books currently in the database
   *
   * @return - number of books
   */
  int getNumberOfBooks();

  /**
   * Returns a list of Books within a certain range
   *
   * @param start - start index
   * @param offset - offset
   * @return - list of Books
   */
  List getBooks(int start, int offset);
}
