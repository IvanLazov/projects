package com.clouway.jspservlet.catalog;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@RunWith(JMock.class)
public class CatalogUserServiceTest {

  private Mockery context = new JUnit4Mockery();
  private CatalogDatabaseService catalogDatabaseService = context.mock(CatalogDatabaseService.class);
  private CatalogUserService catalogUserService;
  private final int range = 3;

  @Before
  public void setUp() {
    catalogUserService = new CatalogUserServiceImpl(catalogDatabaseService);
  }

  @Test
  public void onePageWithRangeOfThreeIsRequiredToDisplayOneBook() {

    int expectedRequiredPages = 1;

    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getNumberOfBooks();
      will(returnValue(1));
    }});

    assertEquals(expectedRequiredPages, catalogUserService.getNumberOfPages(range));
  }
  
  @Test
  public void onePageWithRangeOfThreeIsRequiredToDisplayThreeBooks() {

    int expectedRequiredPages = 1;

    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getNumberOfBooks();
      will(returnValue(3));
    }});
    
    assertEquals(expectedRequiredPages, catalogUserService.getNumberOfPages(range));
  }
  
  @Test
  public void twoPagesWithRangeOfThreeAreRequiredToDisplayFourBooks() {

    int expectedRequiredPages = 2;

    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getNumberOfBooks();
      will(returnValue(4));
    }});
    
    assertEquals(expectedRequiredPages, catalogUserService.getNumberOfPages(range));
  }
  
  @Test
  public void twoPagesWithRangeOfThreeAreRequiredToDisplayFiveBooks() {

    int expectedRequiredPages = 2;

    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getNumberOfBooks();
      will(returnValue(5));
    }});
    
    assertEquals(expectedRequiredPages, catalogUserService.getNumberOfPages(range));
  }
  
  @Test
  public void twoPagesWithRangeOfThreeAreRequiredToDisplaySixBooks() {

    int expectedRequiredPages = 2;

    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getNumberOfBooks();
      will(returnValue(6));
    }});
    
    assertEquals(expectedRequiredPages, catalogUserService.getNumberOfPages(range));
  }
  
  @Test
  public void fourPagesWithRangeOfFiveAreRequiredToDisplayEighteenBooks() {

    int expectedRequiredPages = 4;
    int range = 5;

    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getNumberOfBooks();
      will(returnValue(18));
    }});
    
    assertEquals(expectedRequiredPages, catalogUserService.getNumberOfPages(range));
  }

  // Test which books will be displayed on each page

  // Display three books on each page
  @Test
  public void shouldGetNextThreeBooksStartingFromZeroIndex() {
    
    final int currentPage = 1;
    final int range = 3;
    final int bookIndex = 0;
    
    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getBooks(bookIndex, range);
    }});

    catalogUserService.getListOfBooks(currentPage, range);
  }

  @Test
  public void shouldGetNextThreeBooksStartingFromThirdIndex() {
    
    final int currentPage = 2;
    final int range = 3;
    final int bookIndex = 3;
    
    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getBooks(bookIndex, range);
    }});

    catalogUserService.getListOfBooks(currentPage, range);
  }
  
  @Test
  public void shouldGetNextThreeBooksStartingFromSixthIndex() {
    
    final int currentPage = 3;
    final int range = 3;
    final int bookIndex = 6;
    
    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getBooks(bookIndex, range);
    }});

    catalogUserService.getListOfBooks(currentPage, range);
  }

  // Display four books on each page
  @Test
  public void shouldGetNextFourBooksStartingFromZeroIndex() {
    
    final int currentPage = 1;
    final int range = 4;
    final int bookIndex = 0;
    
    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getBooks(bookIndex, range);
    }});

    catalogUserService.getListOfBooks(currentPage, range);
  }
  
  @Test
  public void shouldGetNextFourBooksStartingFromFourthIndex() {
    
    final int currentPage = 2;    
    final int range = 4;
    final int bookIndex = 4;
    
    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getBooks(bookIndex, range);
    }});

    catalogUserService.getListOfBooks(currentPage, range);
  }
  
  @Test
  public void shouldGetNextFourBooksStartingFromTheEighthIndex() {
    
    final int currentPage = 3;
    final int range = 4;
    final int bookIndex = 8;
    
    context.checking(new Expectations(){{
      oneOf(catalogDatabaseService).getBooks(bookIndex, range);
    }});

    catalogUserService.getListOfBooks(currentPage, range);
  }
}
