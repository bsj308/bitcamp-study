package com.eomcs.oop.young.y0628;

import com.eomcs.oop.common.Dunkin;

public class UserDK {

  public static void main(String[] args) {
    //문제 Dunkin클래스 coffee메소드 호출, donuts메소드 호출

    Dunkin dunkin = new Dunkin();
    String msg = dunkin.coffee();
    System.out.println("주문하신 음료는 " + msg +" 입니다.");

    //Dunkin.donuts(5);

  }

}
