package com.eomcs.oop.young.y0630;

import java.util.Scanner;

public class Work04emp2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int sabun = 0;
    String name = null;

    while(true) {
      try {
        System.out.print("사번입력>>> ");
        sabun = Integer.parseInt(sc.nextLine());

        while(true) {
          System.out.print("이름입력>>> ");
          name = sc.nextLine();
          if(name.equals(null) || name.equals("")) {
            System.out.println("잘못입력하셨습니다.");
            continue;
          }else {
            break;
          }
        }
        break;
      }catch (Exception ex) { }
    }

    System.out.println();
    System.out.println("사번= " + sabun);
    System.out.println("이름= " + name);
  }

}
