package com.eomcs.oop.young;

import java.util.Scanner;

public class TestGugudan {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int dan = 1;

    System.out.print("원하는 단 입력 >>> ");
    try {
      dan = sc.nextInt();
    }catch(Exception ex) {}

    for(int i=1; i<10; i++) {
      System.out.println(dan+"*"+i+"="+(dan*i));
    }


    System.out.println();
    System.out.println("우리나라");

    sc.close();
  }

}
