package com.eomcs.oop.young.y0630;

public class BoardBit implements BoardImp{

  public static void main(String[] args) {


  }

  @Override
  public int boardCount() {

    return 0;
  }

  @Override
  public boolean boardInsert() {

    return false;
  }

  @Override
  public void boardDelete(int num) {


  }

  public void index() {
    //인터페이스 소속아님, 상속X, 재정의 대상X
    //@Override기술하면 에러
  }

}
