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

  String boardName;
  Scanner keyScan;
  ArrayList02 boardList = new ArrayList02();

  BoardHandler02 (String boardName, Scanner keyScan) {
    this.boardName = boardName;
    this.keyScan = keyScan;
  }

  @Override
  public void execute() {
    loop: while (true) {
      System.out.print(this.boardName + "/게시글 관리>");
      String command = keyScan.nextLine();
      switch(command) {
        case "list" : this.list(); break;
        case "add" : this.add(); break;
        case "update" : this.update(); break;
        case "delete" : this.delete(); break;
        case "view" : this.view(); break;
        case "back" :
          break loop;
        default :
          System.out.println("잘못 입력하셨습니다.");
      }
      System.out.println();
    }
  }

  void list() {
    System.out.println("**게시글 목록**");

    Object[] arr = boardList.toArray();

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

  void add() {
    System.out.println("**게시글 등록**");

    if(boardList.size == ArrayList02.MAX_LENGTH) {
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

    boardList.append(board);
  }

  void update() {
    System.out.println("**게시글 변경**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= boardList.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    Board board = (Board)boardList.retrieve(index);

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

  void delete() {
    System.out.println("**게시글 삭제**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= boardList.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    System.out.print("정말로 삭제시겠습니까?(y/N) ");
    if(!keyScan.nextLine().equals("y")) {
      System.out.println("게시글 삭제를 취소했습니다.");
      return;
    }

    boardList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  void view() {
    System.out.println("**게시글 조회**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= boardList.size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    Board board = (Board) boardList.retrieve(index);

    board.viewCount++;

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("등록일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.createdDate);
  }
}
