package com.eomcs.oop.overview;

import java.util.Date;
import java.util.Scanner;

//01. main(): 프로그램 entry point
//02. 사용자로부터 명령어 입력 받기
//03. 사용자로부터 계속 명령어 입력 받기
//04. quit 명령어를 입력 받았을 때 반복 종료하기
//05. 명령어 별로 실행을 분기하기
//06. 게시글 입력 받기
//07. 배열을 이용하여 여러 개의 게시글 보관하기
//08. 상수(final 변수)를 이용하여 배열의 크기를 다루기
//09. 게시글 목록 출력하기
//10. 게시글 상세 조회
//11. 게시글 조회수 추가하기
//12. 게시글 등록일 추가하기
//13. 게시글 변경하기
//14. 게시글 삭제하기
//15. 메서드 문법을 이용하여 기능 별로 명령어를 묶어 관리하기
//16. 클래스를 이용하여 새 데이터타입을 정의하기
public class App02 {

  static class Board {

    String title;
    String content;
    String password;
    int viewCount;
    Date createdDate;

  }

  static final int BOARD_LENGTH = 3;
  static Board[] boards = new Board[BOARD_LENGTH];
  static int size = 0;

  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("[게시판 관리]");

    loop : while(true) {
      System.out.print("명령> ");
      String command = keyScan.nextLine();

      switch(command) {
        case "list" : list(); break;
        case "add" : add(); break;
        case "update" : update(); break;
        case "delete" : delete(); break;
        case "view" : view(); break;
        case "quit" :
          System.out.println("종료합니다.");
          break loop;
        default :
          System.out.println("잘못 입력하셨습니다.");
      }
    }
    keyScan.close();
  }

  static void list() {
    System.out.println("**게시글 목록**");

    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s,%d\n",
          i,
          boards[i].title,
          String.format("%1$tY-%1$tm-%1$td", boards[i].createdDate),
          boards[i].viewCount);
    }
  }

  static void add() {
    System.out.println("**게시글 등록**");

    if(size == BOARD_LENGTH) {
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

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("비밀번호: %s\n", board.password);

    System.out.println("게시글을 등록했습니다.");

    boards[size++] = board;
  }

  static void update() {
    System.out.println("**게시글 변경**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    System.out.printf("제목(%s)?",boards[index].title);
    String title = keyScan.nextLine();
    System.out.printf("내용(%s)?", boards[index].content);
    String content = keyScan.nextLine();

    System.out.print("정말로 바꾸시겠습니까?(y/N) ");
    if(!keyScan.nextLine().equals("y")) {
      System.out.println("변경을 취소했습니다.");
      return;
    }

    boards[index].title = title;
    boards[index].content = content;
    System.out.println("변경했습니다.");
  }

  static void delete() {
    System.out.println("**게시글 삭제**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    System.out.print("정말로 삭제시겠습니까?(y/N) ");
    if(!keyScan.nextLine().equals("y")) {
      System.out.println("게시글 삭제를 취소했습니다.");
      return;
    }

    for(int i = index; i < size-1; i++) {
      boards[i] = boards[i + 1];
    }

    size--;

    System.out.println("게시글을 삭제했습니다.");
  }

  static void view() {
    System.out.println("**게시글 조회**");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if(index < 0 || index >= size) {
      System.out.println("잘못입력하셨습니다.");
      return;
    }

    boards[index].viewCount++;

    System.out.printf("제목: %s\n", boards[index].title);
    System.out.printf("내용: %s\n", boards[index].content);
    System.out.printf("조회수: %d\n", boards[index].viewCount);
    System.out.printf("등록일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", boards[index].createdDate);
  }
}







