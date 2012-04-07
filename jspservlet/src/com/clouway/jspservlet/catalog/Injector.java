package com.clouway.jspservlet.catalog;

/**
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

  public static CommentsUserService injectCommentsUserService(CommentsDatabaseService commentsDatabaseService) {
    return new CommentsUserServiceImpl(commentsDatabaseService);
  }
}
