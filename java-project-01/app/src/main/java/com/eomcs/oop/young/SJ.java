package com.eomcs.oop.young;

public class SJ {

  //학점구하는 함수
  //합격여부 구하는 함수

  public int getTotal(String name, int kor, int eng) {
    System.out.println(name +"님의 성적합계처리");
    int sum = kor + eng;
    return sum;
  }

  public double getMean(int value) {
    double avg = (double)value/2;
    return avg;
  }

  public char getGrade(double data) {
    char grade='F';

    switch((int)data/10) {
      case 10:
      case 9: grade = 'A'; break;
      case 8: grade = 'B'; break;
      case 7: grade = 'C'; break;
      case 6: grade = 'D'; break;
      default:
        grade = 'F';
    }
    return grade;
  }

  public String result(double data) {
    String msg = "합격여부안내문";

    if(data>=70) {
      msg = "축합격";
    } else { msg = "재시험";}
    return msg;
  }


  public String result(int kor, int eng, double data) {
    String msg = "합격여부안내문";
    if(kor>=60 && eng>=60 && data>=70) {
      msg = "축합격";
    } else {
      msg = "재시험";
    }
    return msg;
  }

}
