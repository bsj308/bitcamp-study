package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Test0110 {

  static void printSpaces(int len) {
    for (int count = 1; count <= len; count++) {
      System.out.print(" ");
    }
  }

  static void printStars(int len) {
    for (int count = 1; count <= len; count++) {
      System.out.print("*");
    }
  }

  static int getSpace(int totalStars, int starLen) {
    return (totalStars - starLen) / 2;
  }

  static int getTriangleLen() {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();
    return len;
  }

  public static void main(String[] args) {

    int len = getTriangleLen();

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(getSpace(len,starLen));
      printStars(starLen);
      System.out.println();
    }
  }
}