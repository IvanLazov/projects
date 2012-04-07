package com.clouway.jspservlet.catalog;

import java.util.List;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public interface CommentsUserService {
  
  void saveUserComment(int bookId, String userName, String comment);
  List getListOfComments(int bookId);
}
