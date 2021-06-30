package com.eomcs.oop.young.y0630;

public class TestBook {

  public int m = 7800;

  public static void main(String[] args) {

    char a = 'A', b = '1', c=90;
    System.out.println(a + "\t" + b + "\t" + c);

    int x = a;
    int y = b;
    int z = c;
    System.out.println(x + "\t" + y + "\t" + z);
    System.out.println();

  }

  public void note() {
    int m = 2400;
    System.out.println("지역변수 가격="+ m); //2400
    System.out.println("전역변수 책제목="+ this.m); //7800
  }
}
