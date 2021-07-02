package com.eomcs.oop.common;

public class Dunkin {

  public Dunkin() { }

  public String coffee() {
    //Non-static 메소드, 리턴값
    //주문할 때 = 필요할 때 메모리에 로드
    //객체화 생성후 객체명.coffee;
    String kind = "아이스돌체라떼";
    return kind;
  }

  public void donuts(int cnt) {
    //static 메소드, 메소드(매개인자)
    //미리상품화 클래스이름.도너츠()
    //Dunkin.donuts(); 접근
    System.out.println("도너츠메소드 주문갯수 " + cnt + "개 입니다.");
  }

  public void menu() { //리턴값X, 매개인자X

  }
}
