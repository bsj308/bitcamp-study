package com.eomcs.oop.young.y0630;

import java.io.InputStream;
import java.util.Scanner;

public class Work02emp {

  public static void main(String[] args) {
    InputStream is = System.in;
    Scanner sc = new Scanner(is);
    int sabun = 2000;
    String name = "길동";

    //해결 키보드입력 Scanner클래스, 반복문, 예외처리, 형변환
    while(true) {
      try {
        System.out.print("사번입력>>> ");
        sabun = Integer.parseInt(sc.nextLine());
      }catch (Exception ex){ }

      if(sabun == 2000) {
        System.out.println("사번을 잘못 입력하셨습니다.");
        System.out.println();
      } else {break;}
    }

    while(true) {
      System.out.print("이름입력>>> ");
      name = sc.nextLine();

      if(name.length()<1) {
        System.out.println("이름을 잘못 입력하셨습니다");
        System.out.println();
      } else {break;}
    }

    System.out.println();
    System.out.println("사번 =" + sabun);
    System.out.println("이름 =" + name);

  }
}
