package com.eomcs.oop.young.y0629;

public class TestNote {

  public static void main(String[] args) {
    System.out.println("배솔지 9:42");
    System.out.println("배솔지 9:42");
    TestNote tn = new TestNote();
    String title = tn.book(); //리턴값존재
    tn.note();
  }

  public String book() {//문제1 같은 문서의 메소드호출
    String my = "몽블랑"; //지역변수 = local variable = 어린아이 = 철저하게 보호
    return my;
  }

  public int price() {
    int money = 2700;
    return money;
  }

  public void note() {
    String title = book();
    int pay = price();
    System.out.println("책제목="+ title);
    System.out.println("책제목="+ book());
    System.out.println("책가격="+ pay);
    System.out.println("책제목="+ price());
  }
}
