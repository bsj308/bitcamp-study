package com.eomcs.oop.young;

public class SJUser {

  public static void main(String[] args) {
    SJ sj = new SJ();

    int first = 90;
    int second = 55;
    int total = sj.getTotal("kim", first, second);
    double avg = sj.getMean(total);
    char grade = sj.getGrade(avg);

    String info = sj.result(first, second, avg);

    System.out.println("합계=" + total);
    System.out.println("평균=" + avg);
    System.out.println("학점=" + grade);
    System.out.println("결과=" + info);
  }

}
