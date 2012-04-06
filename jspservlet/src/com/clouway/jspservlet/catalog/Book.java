package com.clouway.jspservlet.catalog;

import java.sql.Date;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class Book {

  private int bookId;
  private String title;
  private String author;
  private Date released;
  private String description;

  public Book(int bookId, String title, String author, Date released, String description) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.released = released;
    this.description = description;
  }

  public int getBookId() {
    return bookId;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public Date getReleased() {
    return released;
  }

  public String getDescription() {
    return description;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (bookId != book.bookId) return false;
    if (author != null ? !author.equals(book.author) : book.author != null) return false;
    if (description != null ? !description.equals(book.description) : book.description != null) return false;
    if (released != null ? !released.equals(book.released) : book.released != null) return false;
    if (title != null ? !title.equals(book.title) : book.title != null) return false;

    return true;
  }

  public int hashCode() {
    int result = bookId;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (author != null ? author.hashCode() : 0);
    result = 31 * result + (released != null ? released.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }

  public String toString() {
    return "Book{" +
            "bookId=" + bookId +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", released=" + released +
            ", description='" + description + '\'' +
            '}'+'\n';
  }
}
