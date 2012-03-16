package com.clouway.jspservlet.task1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class LinkCounter {
  
  private Map<String, Integer> linkCounter = null;
  
  public LinkCounter() {
    linkCounter = new HashMap<String, Integer>();
  }
  
  public void add(String linkName) {
    
    if (!linkCounter.containsKey(linkName)) {
      linkCounter.put(linkName, 1);
    } else {
      linkCounter.put(linkName, linkCounter.get(linkName) + 1);
    }
  }
  
  public Integer getCount(String linkName) {
    return linkCounter.get(linkName);
  }
}
