package net.hb.day0707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest {

  Connection CN = null; //DB서버연결정보 서버ip주소 계정id,pwd
  Statement ST = null; //ST=CN, createStatement() 명령어생성 삭제, 신규등록, 조회하라
  ResultSet RS = null; //select조회결과값 전체데이터를 기억
  String msg = "isud = crud쿼리문기술";
  int Gtotal = 0; // 조회갯수72/ 전체갯수329
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    DBTest db = new DBTest();

    db.dbconnect();

    loop: while(true) {
      int menu = 0;

      System.out.println("1.전체데이터출력 2.데이터입력 3.데이터삭제 9.종료");
      System.out.print("메뉴선택>> ");
      try {menu = Integer.parseInt(db.sc.nextLine());
      }catch(Exception ex) {System.out.println("잘못입력"); continue;}

      switch(menu) {
        case 1:
          db.dbSelectAll();
          break;
        case 2:
          db.dbInsert();
          break;
        case 3:
          db.dbDelete();
          break;
        case 9:
          break loop;
        default :
          System.out.println("잘못입력하셨습니다.");
      }//switch end
    }//while end

    db.sc.close();
  }//end

  public void dbconnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection( url, "system", "1234");
      System.out.println("오라클 드라이브및 서버연결성공");

      ST = CN.createStatement();
    }catch(Exception ex) { System.out.println("에러이유 " + ex);}
  }//connect end

  public void dbSelectAll() {
    try {

      //select ==> Statement 명령어 ==> ResultSet기억
      //RS.next() ==> true ==>  int total ==> RG.getInt("hit")
      msg = "select count(*) as hit from test";
      RS = ST.executeQuery(msg);
      if( RS.next() == true) {
        Gtotal = RS.getInt("hit");
      }

      System.out.println("프로그램 전체데이터 읽어오는 중... 잠시 기다려 주세요");
      Thread.sleep(1000);
      msg = "select * from test"; //문자열을 명령어 인식해서 실행하도록 Statement
      RS = ST.executeQuery(msg);

      System.out.println("------------------ 데이터 출력 ------------------");
      System.out.println("전체레코드갯수:" + Gtotal);
      System.out.println("코드\t이름\t제목\t날짜\t\t조회수");
      while(RS.next()==true) {
        //필드접근해서 데이터가져올 때 getXXX()
        int ucode = RS.getInt("code");
        String uname = RS.getString("name");
        String utitle = RS.getString("title");
        java.util.Date udt = RS.getDate("wdate");
        int ucnt = RS.getInt("cnt");
        System.out.println(ucode + "\t" + uname + "\t" + utitle +"\t" + udt + "\t" + ucnt);    
      }//while end
    }catch(Exception ex) {System.out.println("에러이유: "+ex);}
  }//select end

  public void dbInsert() {
    try {
      //2.키보드에서 데이터 입력
      int a = 0;
      while(true) {
        System.out.print("\n코드입력(4자릿수)>>> ");
        a = Integer.parseInt(sc.nextLine());

        if((int)(Math.log10(a)+1) < 4) {
          System.out.println("4자리 숫자를 입력해주세요"); 
          continue;
        }//if end
        break;
      }//while end

      System.out.print("이름입력>>> ");
      String b = sc.nextLine();
      System.out.print("제목입력>>> ");
      String c = sc.nextLine();

      //3.쿼리문완성
      msg = "insert into test(code,name,title,wdate,cnt) values(" + a + " , '" + b + "' , '" + c + "' , sysdate, 0)";
      System.out.println(msg);

      //4. 서버에서 실행 executeUpdate("insert ~~")
      int OK = ST.executeUpdate(msg);
      if(OK > 0) {
        System.out.println(a + " 코드데이터 저장성공했습니다.");
      } else {
        System.out.println(a + " 코드데이터 저장실패했습니다.");
      }
    }catch(Exception ex) {System.out.println("에러이유 " + ex);}
  }//insert end

  public void dbDelete() {
    try {
      System.out.print("삭제할 코드>> ");
      int a = Integer.parseInt(sc.nextLine());

      msg = "delete from test where code = " + a;
      int OK = ST.executeUpdate(msg);
      if(OK > 0) {
        System.out.println(a + " 코드데이터 삭제성공했습니다.");
      } else {
        System.out.println(a + " 코드데이터 삭제실패했습니다.");
      }
    }catch(Exception ex) { }
  }
}//Class END
