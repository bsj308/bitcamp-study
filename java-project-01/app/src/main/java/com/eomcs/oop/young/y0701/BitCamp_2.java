package com.eomcs.oop.young.y0701;

public class BitCamp_2 extends LA {

  public static void main(String[] args) {
    BitCamp_2 bc = new BitCamp_2();
    bc.book();
    bc.cherry();

  }//end

  public void book() {
    System.out.println("book 몽블랑");

    super.cherry(); //부모 클래스 접근 super
    this.cherry(); //this 생략가능
  }

  @Override
  public void cherry() {
    System.out.println("제주산 체리");
  }

  //LA클래스에 있는 cherry() 메소드 재정의 {제주도산 체리}
}//Class END
