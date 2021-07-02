package com.eomcs.oop.young.y0630;

public class Child extends Father {

  public static void main(String[] args) {
    Child cd = new Child();
    int a = cd.bank();

    cd.car();
  }

  public void book() {
    int m = bank();
  }

  @Override
  public void car() {
    super.car();
    System.out.println("Father클래스 car 재정의");
  }

}
