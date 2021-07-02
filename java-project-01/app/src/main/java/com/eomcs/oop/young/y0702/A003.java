package com.eomcs.oop.young.y0702;

import com.eomcs.oop.common.Dunkin;

public class A003 {

  public static void main(String[] args) {
    Bank bk = new Bank();
    //System.out.println("password " + bk.pwd);
    bk.cal();
    Dunkin dd = new Dunkin();
    String name = dd.coffee();
    dd.donuts(7);

  }

}
