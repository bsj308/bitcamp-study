package com.eomcs.oop.young.y0701;

public class BitCamp_3 {

  public BitCamp_3() { this("종로점",7,"python"); } //기본생성자는 생략가능
  public BitCamp_3(String location) { }  
  public BitCamp_3(int floor) { }
  public BitCamp_3(String location, int floor, String subject) {
    System.out.println(location + floor + "층" + subject + "과정입니다.");
  }

  public static void main(String[] args) {
    BitCamp_3 bc = new BitCamp_3();
    bc.coffee();

  }//end

  public void coffee() {
    System.out.println("coffee 맥심 카누");
    this.cookie();
  }

  public void cookie() {
    System.out.println("cookie 새우깡");
  }

  //LA클래스에 있는 cherry() 메소드 재정의 {제주도산 체리}
}//Class END
