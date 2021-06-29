package com.eomcs.oop.young;

public class BoardUser {

  public static void main(String[] args) {
    Board ob = new Board();
    ob.setTitle("6월 장미축제");
    String data = ob.getTitle();
    System.out.println(data);
  }

}
