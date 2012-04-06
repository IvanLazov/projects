package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CatalogUserService {
  
  int getNumberOfPages(int range);
  List getListOfBooks(int currentPage, int range);
}
