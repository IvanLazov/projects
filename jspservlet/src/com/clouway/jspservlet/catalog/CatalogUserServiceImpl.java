package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogUserServiceImpl implements CatalogUserService {

  private CatalogDatabaseService catalogDatabaseService;

  public CatalogUserServiceImpl(CatalogDatabaseService catalogDatabaseService) {
    this.catalogDatabaseService = catalogDatabaseService;
  }

  public int getNumberOfPages(int range) {

    int numberOfBooks = catalogDatabaseService.getNumberOfBooks();

    if (numberOfBooks % range != 0) {
      return ((numberOfBooks / range) + 1);
    } else {
      return numberOfBooks / range;
    }
  }

  public List getListOfBooks(int currentPage, int range) {

    int start = (currentPage * range) - range;
    return catalogDatabaseService.getBooks(start, range);
  }
}
