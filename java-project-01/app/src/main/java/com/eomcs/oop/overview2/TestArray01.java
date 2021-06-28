package com.eomcs.oop.overview2;

public class TestArray01 {

  public static void main(String[] args) {
    //배열은 초기화
    //배열의 장단점
    String[] dong = new String[5];
    for(int i = 0; i < dong.length; i++) {
      System.out.print(dong[i] + " ");
    }

    System.out.println();
    boolean[] camp = new boolean[5];
    for(int i = 0; i < camp.length; i++) {
      System.out.print(camp[i] + " ");
    }

    System.out.println();
    double[] pi = new double[5];
    for(int i = 0; i < pi.length; i++) {
      System.out.print(pi[i] + " ");
    }

    System.out.println();
    //배열은 같은 타입으로만 구성, 크기사이즈 고정
    //채팅 구성원 정보 닉이름String, 나이int, 성별boolean => 배열구성비권장
    //웹web게시판 글쓴이, 제목, 이미지, 조회수, 날짜
    //채팅, 쇼핑몰, 게시판 구성할 때 배열의 한계극복 collection모음 List계열
    //java.util패키지 List인터페이스 상속 - ArrayList, Vector
    //java.util패키지 Map인터페이스, Set인터페이스, List인터페이스
    //같은 타입구성, 크기고정인 배열의 단점을 List인터페이스 상속으로 해결
    //배열및 문자열 시작위치 0번째부터입니다.
    //자바에서 표준출력 모니터 System.out ==> PrintStream
    //자바에서 표준출력 모니터 System.in  ==> Scanner클래스생성자

  }
}