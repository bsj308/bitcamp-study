package com.eomcs.oop.young.y0630;

public class Work01jumin {

  public static void main(String[] args) {
    String min = "871024-2541965"; //키보드입력대신 초기값
    String min1 = "871024";
    String min2 = "2541965";

    //문제1 총 자릿수 6 - 7 13자릿수, 14자릿수
    //문제2 ******-2541965
    //문제3 1/3남자 2/4여자 switch
    //length(), substring(), indexOf(), charAt()


    if(min.length() == 14) {

      String data = min.substring(min.indexOf("-")+1);
      System.out.println("******-" + data);

      String gender = "성별확인";
      switch(min.charAt(7)) {
        case '1':
        case '3': gender = "남자"; break;
        case '2':
        case '4': gender = "여자"; break;
        default:
          System.out.println("성별을 잘못입력하셨습니다.");
      }
      System.out.println("성별 = " + gender);

    } else {System.out.println("잘못 입력하셨습니다.");}
  }
}

//String[] a = min.split("-");
//System.out.println(a[0]);
//
//
//min1 = min.substring(0,6); //******
//String[] b = min1.split("");
//
//for(int i=0; i<min1.length(); i++) {
//  b[i] = "*";
//}
//
//
//
//
//System.out.println(b[0]);
//
//System.out.println();
//System.out.println(b[1]);
//min2 = min.substring(8);
//
//System.out.println();

//    System.out.println(min.substring(0,6));
//    System.out.println(min.substring(7));
//    min.substring(0,6);
//    min.substring(8);