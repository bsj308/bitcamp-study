package com.eomcs.oop.overview2;

import java.util.Scanner;

public class ComputeHandler02 implements Handler02{

  Scanner keyScan;

  ComputeHandler02 (Scanner keyScan) {
    this.keyScan = keyScan;
  }

  @Override
  public void execute() {

    loop: while (true) {
      System.out.print("계산기> (예: 100 * 3) ");
      String command = keyScan.nextLine();

      if (command.equals("back")) {
        break;
      }

      String arr[] = command.split(" ");

      if (arr.length > 3) {
        System.out.println("잘못 입력하셨습니다.");
      }

      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[2]);

      switch(arr[1]) {
        case "+" : System.out.printf("%d + %d = %d", a , b, a+b); break;
        case "-" : System.out.printf("%d - %d = %d", a , b, a-b); break;
        case "*" : System.out.printf("%d * %d = %d", a , b, a*b); break;
        case "/" : System.out.printf("%d / %d = %d", a , b, a/b); break;
        case "%" : System.out.printf("%d %% %d = %d", a , b, a%b); break;
        case "back" :
          break loop;
        default :
          System.out.println("잘못 입력하셨습니다.");
      }
      System.out.println();
    }

  }
}
