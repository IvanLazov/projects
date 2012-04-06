package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CatalogDatabaseService {
  
  int getNumberOfBooks();
  List getBooks(int currentPage, int range);
}
