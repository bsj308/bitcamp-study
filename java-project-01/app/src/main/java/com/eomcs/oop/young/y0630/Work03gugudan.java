package com.eomcs.oop.young.y0630;

import java.io.InputStream;

public class Work03gugudan {

  public static void main(String[] args) throws Exception {

    InputStream is = System.in;

    System.out.println("단입력>>> ");
    int dan = is.read();
    for(int a=1; a<10; a++) {
      System.out.println(dan+"*"+a+"="+(dan*a));
    }
  }
}
