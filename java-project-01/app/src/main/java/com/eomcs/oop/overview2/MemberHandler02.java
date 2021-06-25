package com.eomcs.oop.overview2;

import java.util.Date;
import java.util.Scanner;

public class MemberHandler02 implements Handler02 {

  static class Member {

    String name;
    String email;
    String password;
    boolean working;
    Date registeredDate;

  }

  static Scanner keyScan;

  @Override
  public void execute() {
    loop: while (true) {
      System.out.print("회원 관리>");
      String command = keyScan.nextLine();
      switch(command) {
        case "list" : list(); break;
        case "add" : add(); break;
        case "update" : update(); break;
        case "delete" : delete(); break;
        case "view" : view(); break;
        case "back" :
          break loop;
        default :
          System.out.println("잘못 입력하셨습니다.");
      }
      System.out.println();
    }
  }

  static void list() {
    System.out.println("**회원 목록**");

    Object[] arr = ArrayList02.toArray();

    for(int i = 0; i<arr.length;i++) {

      Member member = (Member) arr[i];

      System.out.printf("%d, %s, %s,%b\n",
          i,
          member.name,
          String.format("%1$tY-%1$tm-%1$td", member.registeredDate),
          member.working);
    }
  }

  static void add() {
    System.out.println("**회원 등록**");

    if(ArrayList02.size == ArrayList02.MAX_LENGTH) {
      System.out.println("등록 개수를 초과했습니다.");
      return;
    }

    Member member = new Member();

    System.out.print("이름: ");
    member.name = keyScan.nextLine();
    System.out.print("이메일: ");
    member.email = keyScan.nextLine();
    System.out.print("비밀번호: ");
    member.password = keyScan.nextLine();
    System.out.print("재직중: (y/N)");

    if(keyScan.nextLine().equals("y")) {
      member.working = true; 
    } else {
      member.working = false;
    }
    member.registeredDate = new Date();

    System.out.println("회원을 등록했습니다.");

    ArrayList02.append(member);
  }

  static void update() {
    System.out.println("**회원 변경**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= ArrayList02.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    Member member = (Member)ArrayList02.retrieve(index);

    System.out.printf("이름(%s)?",member.name);
    String name = keyScan.nextLine();
    System.out.printf("이메일(%s)?", member.email);
    String email = keyScan.nextLine();
    System.out.printf("암호?");
    String password = keyScan.nextLine();
    System.out.printf("재직중(%s) (y/N)?", member.working ? "예": "아니오");
    boolean working = false;
    if(keyScan.nextLine().equals("y")) {
      working = true;
    }

    System.out.print("정말로 바꾸시겠습니까?(y/N) ");
    if(!keyScan.nextLine().equals("y")) {
      System.out.println("변경을 취소했습니다.");
      return;
    }

    member.name = name;
    member.email = email;
    member.password = password;
    member.working = working;
    System.out.println("변경했습니다.");
  }

  static void delete() {
    System.out.println("**회원 삭제**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= ArrayList02.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    System.out.print("정말로 삭제시겠습니까?(y/N) ");
    if(!keyScan.nextLine().equals("y")) {
      System.out.println("회원 삭제를 취소했습니다.");
      return;
    }

    ArrayList02.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  static void view() {
    System.out.println("**회원 조회**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= ArrayList02.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    Member member = (Member) ArrayList02.retrieve(index);

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("재직중: %s\n", member.working ? "예" : "아니오");
    System.out.printf("등록일: %1$tY-%1$tm-%1$td\n", member.registeredDate);
  }
}
