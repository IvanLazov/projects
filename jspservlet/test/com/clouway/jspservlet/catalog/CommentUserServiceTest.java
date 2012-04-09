package com.clouway.jspservlet.catalog;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@RunWith(JMock.class)
public class CommentUserServiceTest {
  
  private Mockery context = new JUnit4Mockery();
  private CommentsDatabaseService commentsDatabaseService = context.mock(CommentsDatabaseService.class);
  private CommentUserService commentUserService;

  @Before
  public void setUp() {
    commentUserService = new CommentUserServiceImpl(commentsDatabaseService);
  }

  @Test
  public void saveUserComment() {

    context.checking(new Expectations(){{
      oneOf(commentsDatabaseService).saveComment(1, "Ivan", "Great Book");
    }});

    commentUserService.saveUserComment(1, "Ivan", "Great Book");
  }

  @Test
  public void getListOfBookComments() {

    context.checking(new Expectations(){{
      oneOf(commentsDatabaseService).getComments(1);
    }});

    commentUserService.getListOfComments(1);
  }
}
