package net.hb.day0707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Board {//test테이블
  public static void main(String[] args) {
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    String sql = "sql 명령";
    Scanner sc = new Scanner(System.in);

    //1. 오라클드라이버 로드하는 명령어 Class.forName(" ")
    //2. db서버접근 계정명, pwd        127.0.0.1:152:XE    system  1234
    //3. 명령어 생성은 2번 서버정보를 참조해서 명령어생성  Statement ST =

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "1234");
      System.out.println("db서버연결성공 4:05");

      stat = conn.createStatement();
      //4. 명령어생성후, 명령어실행() 결과값을 ResultSet 기억
      //5. 레코드를 첫번째부터 차례차례 이동하면서 출력 while(???) { }

    }catch(Exception ex) {System.out.println("error = " + ex); }

    System.out.println("1.데이터입력 2.데이터삭제 3.전체데이터조회 9.종료");
    System.out.print("메뉴입력>> ");
    int menu = Integer.parseInt(sc.nextLine());

    switch(menu) {
      case 1:
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
        break;
      case 2:
        try {
          System.out.println("코드값으로 데이터를 삭제합니다.");
          System.out.print("코드>> ");
          int a = Integer.parseInt(sc.nextLine());

          sql = "delete from test where code = " + a;

          int Ok = stat.executeUpdate(sql);
          if(Ok>0) {
            System.out.println(a + "데이테삭제 성공");
          }else {
            System.out.println(a +"데이터삭제 실패");
          }
        }catch(Exception ex) {System.out.println("에러이유: " + ex); }
        break;
      case 3:
        try {
          sql = "select * from test";
          rs = stat.executeQuery(sql);
          System.out.println("코드\t이름\t제목");
          while(rs.next()) {
            int ucode = rs.getInt("code");
            String uname = rs.getString("name");
            String utitle = rs.getString("title");
            System.out.println(ucode + "\t" + uname + "\t" + utitle);
          }
        }catch(Exception ex) {System.out.println("에러이유: " + ex); }
        break;
      case 9:
        break;
      default :
        System.out.println("잘못 입력하셨습니다.");
    }
  }//main end
}//Board class END
