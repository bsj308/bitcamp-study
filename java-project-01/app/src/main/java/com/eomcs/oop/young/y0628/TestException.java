package com.eomcs.oop.young.y0628;

public class TestException {

  public static void main(String[] args) {

    int dan = 3;
    for(int i=1; i<10; i++) {
      System.out.println(dan+"*"+i+"="+(dan*i));
      try { Thread.sleep(500); } catch (Exception e) {}
    }

    System.out.println();
    System.out.println("우리나라");
  }

}
