package com.clouway.guice.onlinebanking;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class User {
  
  private int userId;
  private String userName;
  private String password;

  public User(int userId, String userName, String password) {
    this.userId = userId;
    this.userName = userName;
    this.password = password;
  }

  public int getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (userId != user.userId) return false;
    if (password != null ? !password.equals(user.password) : user.password != null) return false;
    if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = userId;
    result = 31 * result + (userName != null ? userName.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }
}
