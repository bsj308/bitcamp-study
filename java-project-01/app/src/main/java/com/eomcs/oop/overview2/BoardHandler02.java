package com.eomcs.oop.overview2;

import java.util.Date;
import java.util.Scanner;

public class BoardHandler02 implements Handler02{

  static class Board {

    String title;
    String content;
    String password;
    int viewCount;
    Date createdDate;

  }

  static Scanner keyScan;

  @Override
  public void execute() {
    loop: while (true) {
      System.out.print("게시글 관리>");
      String command = keyScan.nextLine();
      switch(command) {
        case "list" : BoardHandler02.list(); break;
        case "add" : BoardHandler02.add(); break;
        case "update" : BoardHandler02.update(); break;
        case "delete" : BoardHandler02.delete(); break;
        case "view" : BoardHandler02.view(); break;
        case "back" :
          break loop;
        default :
          System.out.println("잘못 입력하셨습니다.");
      }
      System.out.println();
    }
  }

  static void list() {
    System.out.println("**게시글 목록**");

    Object[] arr = ArrayList02.toArray();

    int i = 0;
    for(Object item: arr) {

      Board board = (Board) item;

      System.out.printf("%d, %s, %s,%d\n",
          i++,
          board.title,
          String.format("%1$tY-%1$tm-%1$td", board.createdDate),
          board.viewCount);
    }
  }

  static void add() {
    System.out.println("**게시글 등록**");

    if(ArrayList02.size == ArrayList02.MAX_LENGTH) {
      System.out.println("등록 개수를 초과했습니다.");
      return;
    }

    Board board = new Board();

    System.out.print("제목: ");
    board.title = keyScan.nextLine();
    System.out.print("내용: ");
    board.content = keyScan.nextLine();
    System.out.print("비밀번호: ");
    board.password = keyScan.nextLine();
    board.createdDate = new Date();

    System.out.println("게시글을 등록했습니다.");

    ArrayList02.append(board);
  }

  static void update() {
    System.out.println("**게시글 변경**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= ArrayList02.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    Board board = (Board)ArrayList02.retrieve(index);

    System.out.printf("제목(%s)?",board.title);
    String title = keyScan.nextLine();
    System.out.printf("내용(%s)?", board.content);
    String content = keyScan.nextLine();

    System.out.print("정말로 바꾸시겠습니까?(y/N) ");
    if(!keyScan.nextLine().equals("y")) {
      System.out.println("변경을 취소했습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("변경했습니다.");
  }

  static void delete() {
    System.out.println("**게시글 삭제**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= ArrayList02.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    System.out.print("정말로 삭제시겠습니까?(y/N) ");
    if(!keyScan.nextLine().equals("y")) {
      System.out.println("게시글 삭제를 취소했습니다.");
      return;
    }

    ArrayList02.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  static void view() {
    System.out.println("**게시글 조회**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= ArrayList02.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    Board board = (Board) ArrayList02.retrieve(index);

    board.viewCount++;

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("등록일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.createdDate);
  }
}
