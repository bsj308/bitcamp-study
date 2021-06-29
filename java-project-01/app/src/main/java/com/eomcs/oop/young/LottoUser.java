package com.eomcs.oop.young;

public class LottoUser {

  public static void main(String[] args) {

    int[] ret = Lotto.input();
    Lotto.output(ret);

    Lotto LG = new Lotto();
    int value = LG.inputHap();// 리턴값을 안받으면 그냥 호출, 에러는 없지만 의미가 없음
    System.out.println("숫자합계=" + value);
    System.out.println("숫자합계=" + LG.inputHap());

    System.out.println();
    System.out.println("LottoUser");
  }
}
