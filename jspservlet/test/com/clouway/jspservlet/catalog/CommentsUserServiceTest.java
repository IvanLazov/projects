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
public class CommentsUserServiceTest {
  
  private Mockery context = new JUnit4Mockery();
  private CommentsDatabaseService commentsDatabaseService = context.mock(CommentsDatabaseService.class);
  private CommentsUserService commentsUserService;

  @Before
  public void setUp() {
    commentsUserService = new CommentsUserServiceImpl(commentsDatabaseService);
  }

  @Test
  public void saveUserComment() {

    context.checking(new Expectations(){{
      oneOf(commentsDatabaseService).saveComment(1, "Ivan", "Great Book");
    }});

    commentsUserService.saveUserComment(1, "Ivan", "Great Book");
  }

  @Test(expected = InvalidUserNameException.class)
  public void shouldNotSaveCommentIfUseNameIsEmpty() {

    context.checking(new Expectations(){{
    }});

    commentsUserService.saveUserComment(1, "", "Great Book");
  }

  @Test(expected = InvalidUserNameException.class)
  public void shouldNotSaveCommentIfUserNameContainsBlankCharacter() {

    context.checking(new Expectations(){{
    }});

    commentsUserService.saveUserComment(1, " ", "Great Book");
  }

  @Test(expected = InvalidUserNameException.class)
  public void shouldNotSaveCommentIfUserNameContainsNumberCharacters() {

    context.checking(new Expectations(){{
    }});

    commentsUserService.saveUserComment(1, "12345", "Great Book");
  }

  @Test(expected = InvalidCommentException.class)
  public void shouldNotSaveCommentIfCommentIsEmpty() {

    context.checking(new Expectations(){{
    }});

    commentsUserService.saveUserComment(1, "Ivan", "");
  }

  @Test(expected = InvalidCommentException.class)
  public void shouldNotSaveCommentIfCommentContainsBlankCharacter() {

    context.checking(new Expectations(){{
    }});

    commentsUserService.saveUserComment(1, "Ivan", " ");
  }

  @Test
  public void getListOfBookComments() {

    context.checking(new Expectations(){{
      oneOf(commentsDatabaseService).getComments(1);
    }});

    commentsUserService.getListOfComments(1);
  }
}
