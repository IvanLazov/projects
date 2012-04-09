package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CatalogUserServiceImpl class provides implementation of CatalogUserService
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogUserServiceImpl implements CatalogUserService {

  private CatalogDatabaseService catalogDatabaseService;

  public CatalogUserServiceImpl(CatalogDatabaseService catalogDatabaseService) {
    this.catalogDatabaseService = catalogDatabaseService;
  }

  /**
   * Returns the number of pages needed to display all books
   *
   * @param range - the number of books per page
   * @return - number of pages
   */
  public int getNumberOfPages(int range) {

    int numberOfBooks = catalogDatabaseService.getNumberOfBooks();

    if (numberOfBooks % range != 0) {
      return ((numberOfBooks / range) + 1);
    } else {
      return numberOfBooks / range;
    }
  }

  /**
   * Returns a List of Book objects
   *
   * @param currentPage - the page on which the user is currently on
   * @param range - the number of books per page
   * @return - list of Book objects
   */
  public List getListOfBooks(int currentPage, int range) {

    int start = (currentPage * range) - range;
    return catalogDatabaseService.getBooks(start, range);
  }

  /**
   * Returns a Book with a given bookId
   *
   * @param bookId - bookId
   * @return - Book object
   */
  public Book getRequestBook(int bookId) {
    return catalogDatabaseService.getBook(bookId);
  }
}
