package com.eomcs.oop.young.y0701;

import com.eomcs.oop.young.y0630.Father;

public class BitCamp_4 extends Father implements AAA, BBB {

  public static void main(String[] args) {
    BitCamp_4 bc4 = new BitCamp_4();
    bc4.game();

  }

  public void game() {
    System.out.println("삼국지 ");
    int m = this.bank();
  }

  @Override public void apple() {
    System.out.println("");
  }

  @Override
  public String memo() {
    return null;
  }

  @Override
  public boolean nullCheck(int key) {
    return false;
  }

  @Override
  public void blue() {

  }

}
