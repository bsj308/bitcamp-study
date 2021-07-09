package net.hb.day0707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Board {//test테이블

  Connection conn = null;
  Statement stat = null;
  ResultSet rs = null;
  String sql = "sql 명령";
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    Board board = new Board();
    board.dbConnect();

    //1. 오라클드라이버 로드하는 명령어 Class.forName(" ")
    //2. db서버접근 계정명, pwd        127.0.0.1:152:XE    system  1234
    //3. 명령어 생성은 2번 서버정보를 참조해서 명령어생성  Statement ST =



    System.out.println("1.데이터입력 2.데이터삭제 3.전체데이터조회 4.데이터변경 9.종료");
    System.out.print("메뉴입력>> ");
    int menu = Integer.parseInt(board.sc.nextLine());

    switch(menu) {
      case 1:
        board.dbInsert();
        break;
      case 2:
        board.dbDelete();
        break;
      case 3:
        board.dbSelectAll();
        break;
      case 4:
        board.dbUpdate();
        break;
      case 9:
        break;
      default :
        System.out.println("잘못 입력하셨습니다.");
    }
  }//main end

  public void dbConnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "1234");
      System.out.println("db서버연결성공 4:05");

      stat = conn.createStatement();
      //4. 명령어생성후, 명령어실행() 결과값을 ResultSet 기억
      //5. 레코드를 첫번째부터 차례차례 이동하면서 출력 while(???) { }

    }catch(Exception ex) {System.out.println("error = " + ex); }
  }

  public void dbInsert() {
    try {
      System.out.println("데이터추가");
      System.out.print("코드>> ");
      int a = Integer.parseInt(sc.nextLine());
      System.out.print("이름>> ");
      String b = sc.nextLine();
      System.out.print("제목>> ");
      String c = sc.nextLine();

      sql = "insert into test values(" + a + ", '" + b + "', '" + c + "', sysdate, 0)";
      System.out.println(sql);
      int Ok = stat.executeUpdate(sql);
      if(Ok>0) {
        System.out.println(a + "데이터입력 성공");
      }else {
        System.out.println(a +"데이터입력 실패");
      }
    }catch(Exception ex) {System.out.println("에러이유: " + ex); }
  }

  public void dbDelete() {
    try {
      System.out.println("코드값으로 데이터를 삭제합니다.");
      System.out.print("코드>> ");
      int del = Integer.parseInt(sc.nextLine());

      sql = "delete from test where code = " + del;
      System.out.println(sql);

      String msg1 ="insert into ~~ ";
      String msg2 ="delete where ~~ ";
      String msg3 ="update T명 set  where~~ ";
      String msg4 ="select ~~ "; //372데이터조회=추출
      //msg1,msg2,msg2 처리는 ST.executeUpate(쿼리문장)
      //msg4 처리는 ResultSet RS = ST.executeQuery(쿼리문장)
      //select는 다량의 결과를 조회하므로 ResultSet에 저장해서 하나씩 출력해야한다.
      //나머지는 명령문 실행하면 끝이므로 다름

      //문자열 sql문자열을 sql명령어 인식할 Statement가 꼭 필요함
      int Ok = stat.executeUpdate(sql);
      if(Ok>0) {
        System.out.println(del + "데이테삭제 성공");
      }else {
        System.out.println(del +"데이터삭제 실패");
      }
    }catch(Exception ex) {System.out.println("에러이유: " + ex); }
  }

  public void dbSelectAll() {
    try {
      sql = "select * from test order by code";
      rs = stat.executeQuery(sql);
      System.out.println("코드\t이름\t제목");
      while(rs.next()) {
        int ucode = rs.getInt("code");
        String uname = rs.getString("name");
        String utitle = rs.getString("title");
        System.out.println(ucode + "\t" + uname + "\t" + utitle);
      }
    }catch(Exception ex) {System.out.println("전체조회실패: " + ex); }
  }

  public void dbUpdate() {
    try {
      System.out.println("데이터변경(코드번호기준)");
      System.out.print("변경할 데이터의 코드번호>> ");
      int a = Integer.parseInt(sc.nextLine());
      System.out.print("변경할 곳 (name or title)>> ");
      String b = sc.nextLine();
      System.out.print("변경데이터>> ");
      String c = sc.nextLine();

      sql = "update test set "+ b + " = '" + c + "' where code = " + a;
      System.out.println(sql);
      int Ok = stat.executeUpdate(sql);
      if(Ok>0) {
        System.out.println(a + "데이터변경 성공");
      }else {
        System.out.println(a +"데이터변경 실패");
      }
    }catch(Exception ex) { }
  }
}//Board class END
