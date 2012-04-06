package com.clouway.jspservlet.catalog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CatalogDatabaseServiceTest {

  private final String database = "test";
  private DatabaseHelper databaseHelper;
  private CatalogDatabaseService catalogDatabaseService;

  @Before
  public void setUp() {

    databaseHelper = Injector.injectDatabaseHelper(database);
    catalogDatabaseService = new CatalogDatabaseServiceImpl(databaseHelper);
    executeQueries(5);
  }
  
  @Test
  public void getNumberOfBooks() {

    assertEquals(5, catalogDatabaseService.getNumberOfBooks());
  }
  
  @Test
  public void getFirstBook() {
    
    List<Book> expectedBooks = createBooks(1);
    assertEquals(expectedBooks, catalogDatabaseService.getBooks(0,1));
  }

  @Test
  public void getFirstThreeBooks() {
    
    List<Book> expectedBooks = createBooks(3);
    assertEquals(expectedBooks, catalogDatabaseService.getBooks(0,3));
  }
  
  @Test
  public void getLastBook() {
    
    List<Book> expectedBooks = createBooks(5);
    assertEquals(expectedBooks.get(4), catalogDatabaseService.getBooks(4, 1).get(0));
  }

  @Test
  public void getAllBooks() {

    List<Book> expectedBooks = createBooks(5);
    assertEquals(expectedBooks, catalogDatabaseService.getBooks(0, 5));
  }
  
  @After
  public void tearDown() {
    databaseHelper.executeQuery("DELETE FROM books");
  }

  private void executeQueries(int numberOfQueries) {
    databaseHelper.executeQuery("DELETE FROM books");

    for (int i = 1; i <= numberOfQueries; i++) {
      databaseHelper.executeQuery("INSERT INTO books(bookId,title,author,released,description)" +
              "VALUES(?,?,?,?,?)", i, "Book" + i, "Author" + i, "2010-10-0" + i, "Description" + i);
    }
  }

  private List<Book> createBooks(int numberOfBooks) {

    List<Book> expectedBooks = new ArrayList<Book>();

    for (int i = 1; i <= numberOfBooks; i++) {
      expectedBooks.add(new Book(i, "Book" + i, "Author" + i, Date.valueOf("2010-10-0" + i), "Description" + i));
    }

    return expectedBooks;
  }
}
