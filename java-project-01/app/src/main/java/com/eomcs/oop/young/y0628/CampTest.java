package com.eomcs.oop.young.y0628;

import java.util.Scanner;

public class CampTest {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    CampTestMethod campTestMethod = new CampTestMethod(sc);

    System.out.println("1차원배열 캠프예매 28일 월요일 ");

    campTestMethod.printAll();

    while(true) {
      try {
        campTestMethod.menu();

        if(campTestMethod.sel==9) {
          campTestMethod.myExit();
          break;
        }

        switch(campTestMethod.sel) {
          case 1: 
            campTestMethod.input();
            campTestMethod.printAll();
            break;
          case 2: //퇴실은 조별/개인별처리
            campTestMethod.output();
            campTestMethod.printAll();
            break;   
          case 3: //전체예약상태
            campTestMethod.printAll();
            break;
          default: 
            System.out.println("1~3메뉴를 선택하셔야 합니다");
            break;   
        }//switch end
      }catch (Exception e) {   }
    }//while 

    sc.close();
  }//end


}//class END
