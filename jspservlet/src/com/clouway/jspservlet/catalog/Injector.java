package com.clouway.jspservlet.catalog;

/**
 * Injector class is used to get an instance of objects when we need them.
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public final class Injector {

  private static DatabaseHelper databaseHelper;

  public static DatabaseHelper injectDatabaseHelper(String database) {
    if (databaseHelper == null) {
      databaseHelper = new DatabaseHelper(database);
    }
    return databaseHelper;
  }

  public static CatalogDatabaseService injectCatalogDatabaseService(DatabaseHelper databaseHelper) {
    return new CatalogDatabaseServiceImpl(databaseHelper);
  }

  public static CatalogUserService injectCatalogUserService(CatalogDatabaseService catalogDatabaseService) {
    return new CatalogUserServiceImpl(catalogDatabaseService);
  }

  public static CommentsDatabaseService injectCommentsDatabaseService(DatabaseHelper databaseHelper) {
    return new CommentsDatabaseServiceImpl(databaseHelper);
  }

  public static CommentUserService injectCommentsUserService(CommentsDatabaseService commentsDatabaseService) {
    return new CommentUserServiceImpl(commentsDatabaseService);
  }
}
