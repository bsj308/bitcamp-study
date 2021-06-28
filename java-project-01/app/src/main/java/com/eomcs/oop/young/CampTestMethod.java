package com.eomcs.oop.young;

import java.util.Scanner;

public class CampTestMethod {

  static boolean[] camp = new boolean[5]; // 0번째 1번째 2번째 3번째 4번째
  int sel = 9, num = 0;
  Scanner sc;
  String campName;

  CampTestMethod(Scanner sc) {
    this.sc = sc;
  }

  public int menu() {
    System.out.print("\n1.예약  2.퇴실  3.보기  9.종료 : ");
    this.sel = Integer.parseInt(sc.nextLine());
    return sel;
  }

  public void myExit() {
    System.out.println("캠프장예약프로그램을 종료합니디");
    System.exit(1);
  }

  public void printAll() {
    //캠핑장 예약상태확인 
    for(int i=0; i<camp.length; i++) {
      if(camp[i]==true) {
        System.out.println("  "+ (i+1)+"번째 ■캠프사용중입니다 "  );
      }else {
        System.out.println("  "+ (i+1)+"번째 □캠프장은 비어 있습니다 "  ); 
      }
    } //for end
  }

  public void input() {
    System.out.print("예약캠핑번호 입력>>> ");
    num=Integer.parseInt(sc.nextLine()); //고객이 5입력
    if(num <1 || num >5) { System.out.println(num +"번호를 사용할수 없습니다"); }

    if(camp[num-1] == false) {
      camp[num-1] = true;
      System.out.println(num + "번방 예약이 완료되었습니다.");
    } else {
      System.out.println("이미 예약된 방입니다.");
    }
    System.out.println();
  }

  public void output() {
    System.out.print("퇴실캠핑번호 입력>>> ");
    num=Integer.parseInt(sc.nextLine()); //3입력하면 
    if(num <1 || num >5) { System.out.println(num +"번호를 사용할수 없습니다"); }

    if(camp[num-1] == true) {
      camp[num-1] = false;
      System.out.println(num + "번방 퇴실되었습니다.");
    } else {
      System.out.println("사용중인 방이 아닙니다.");
    }
    System.out.println();
  }
}//class END
