package com.eomcs.oop.young;

public class TestJumin {

  public static void main(String[] args) {
    //java.lang패키지 String 클래읏의 메소드 char chatAt(int)
    String min = "871024-2541965";

    //조건if 남자입니다 / 여자입니다
    //String 문자열은 0번째부터 시작
    if(min.charAt(7)=='1') {
      System.out.println("남자입니다");
    } else if(min.charAt(7)=='2') {
      System.out.println("여자입니다");
    } else {
      System.out.println("잘못입력하셨습니다.");
    }

  }

}
