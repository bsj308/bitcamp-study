package com.eomcs.oop.overview;



public class Test {
  static class A {
    int x;
  }
  static class B {
    int y;
  }
  static class C {
    int z;
  }
  public static void main(String[] args) {
    A r1 = new A();
    r1.x = 100;

    Object obj = new A();
    //obj.x = 100;

    A r2 = (A) obj;
    r2.x = 100;
  }

}
