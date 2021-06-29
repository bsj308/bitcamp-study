package com.eomcs.oop.young;

public class Lotto {

  public static int[] input() {
    int[] su = new int[6]; //su배열 지역배열기술, 전역배열로 빼지 마세요
    su[0] = 3; su[1] = 5; su[2] = 1;
    su[3] = 2; su[4] = 9; su[5] = 3;
    return su;
  }

  public static void output(int[] LT) {
    for(int i=0; i<LT.length; i++) {
      System.out.print(LT[i] + "\t");
    }
    System.out.println("\n로또배열 출력에 성공했습니다.");
  }

  public int inputHap() {
    int hap = 0;
    int[] su = new int[6]; //su배열 지역배열기술, 전역배열로 빼지 마세요
    su[0] = 3; su[1] = 5; su[2] = 1;
    su[3] = 2; su[4] = 9; su[5] = 4;

    for(int i=0; i<su.length; i++) {
      hap += su[0];
    }

    return hap;
  }
}
