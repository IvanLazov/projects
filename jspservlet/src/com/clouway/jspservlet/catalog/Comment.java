package com.clouway.jspservlet.catalog;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Comment {

  private int bookId;
  private String userName;
  private String comment;
  
  public Comment(int bookId, String userName, String comment) {

    this.bookId = bookId;
    this.userName = userName;
    this.comment = comment;
  }

  public int getBookId() {
    return bookId;
  }

  public String getUserName() {
    return userName;
  }

  public String getComment() {
    return comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Comment comment1 = (Comment) o;

    if (bookId != comment1.bookId) return false;
    if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
    if (userName != null ? !userName.equals(comment1.userName) : comment1.userName != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = bookId;
    result = 31 * result + (userName != null ? userName.hashCode() : 0);
    result = 31 * result + (comment != null ? comment.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Comment{" +
            "bookId=" + bookId +
            ", userName='" + userName + '\'' +
            ", comment='" + comment + '\'' +
            '}';
  }
}
