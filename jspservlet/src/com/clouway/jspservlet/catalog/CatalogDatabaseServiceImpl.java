package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * CatalogDatabaseServiceImpl provides implementation of the CatalogDatabaseService interface
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogDatabaseServiceImpl implements CatalogDatabaseService {

  private final DatabaseHelper databaseHelper;

  /**
   * Constructor sets the databaseHelper we will use to execute queries
   * against the database
   *
   * @param databaseHelper - databaseHelper which executes queries
   */
  public CatalogDatabaseServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  /**
   * Returns the number of books currently in the database
   *
   * @return - number of books
   */
  public int getNumberOfBooks() {
    return Integer.parseInt(databaseHelper.executeQueryResult("SELECT COUNT(title) FROM books"));
  }

  /**
   * Returns a list of books within a certain range
   *
   * @param currentPage - page on which the user is currently
   * @param range - the number of books we want to get
   * @return - list of books
   */
  public List getBooks(int currentPage, int range) {
    return databaseHelper.executeQuery("SELECT * FROM books LIMIT ?,?", new BookRowMapper(), currentPage, range);
  }

  /**
   * Returns a Book object with а certain bookId
   *
   * @param bookId - bookId
   * @return - Book object
   */
  public Book getBook(int bookId) {
    return databaseHelper.executeQuery("SELECT * FROM books WHERE bookId=?", new BookRowMapper(), bookId).get(0);
  }
}
