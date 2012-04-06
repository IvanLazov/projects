package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogDatabaseServiceImpl implements CatalogDatabaseService {

  private final DatabaseHelper databaseHelper;

  public CatalogDatabaseServiceImpl(DatabaseHelper databaseHelper) {
    this.databaseHelper = databaseHelper;
  }

  public int getNumberOfBooks() {
    return Integer.parseInt(databaseHelper.executeQueryResult("SELECT COUNT(title) FROM books"));
  }

  public List getBooks(int currentPage, int range) {
    return databaseHelper.executeQuery("SELECT * FROM books LIMIT ?,?", new BookRowMapper(), currentPage, range);
  }
}
