package com.clouway.jspservlet.catalog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CommentsDatabaseServiceTest {
  
  private final DatabaseHelper databaseHelper = Injector.injectDatabaseHelper("test");
  private CommentsDatabaseService commentsDatabaseService;
  
  @Before
  public void setUp() {
    databaseHelper.executeQuery("DELETE FROM comments");
    databaseHelper.executeQuery("DELETE FROM books");
    databaseHelper.executeQuery("INSERT INTO books(bookId,title,author,released,description) VALUES(?,?,?,?,?)", 1, "Book1", "Author1", "2010-10-01", "Description");
    
    commentsDatabaseService = new CommentsDatabaseServiceImpl(databaseHelper);
    saveComments(3);
  }
  
  private void saveComments(int numberOfComments) {
    
    for (int i = 1; i <= numberOfComments; i++) {      
      commentsDatabaseService.saveComment(1, "Ivan" + i, "Comment" + i);
    }
  }
  
  private List<Comment> expectedComments(int numberOfComments) {
    
    List<Comment> listOfComments = new ArrayList<Comment>();
    
    for (int i = 1; i <=numberOfComments; i++) {
      listOfComments.add(new Comment(1, "Ivan" + i, "Comment" + i));  
    }

    return listOfComments;
  }
  
  @Test
  public void getAllCommentsForABook() {

    assertEquals(expectedComments(3), commentsDatabaseService.getComments(1));
  }

  @After
  public void tearDown() {
    databaseHelper.executeQuery("DELETE FROM comments");
    databaseHelper.executeQuery("DELETE FROM books");
  }
}
