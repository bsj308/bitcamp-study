package net.project.mini1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JoinMember {
  Connection CN = null; //DB서버연결정보 서버ip주소 계정id,pwd
  Statement ST = null; //ST=CN, createStatement() 명령어생성 삭제, 신규등록, 조회하라
  ResultSet RS = null; //select조회결과값 전체데이터를 기억
  String msg = "isud = crud쿼리문기술";
  Scanner sc = new Scanner(System.in);
  //  memNo number(4) not null ,
  //  name varchar(9) not null ,
  //  ID varchar(6) primary key ,
  //  psw varchar(6) not null ,
  //  email varchar(20) not null ,
  //  cdate date not null ,
  //  score number(4) default(0)

  public void join() {
    System.out.println("회원가입");
    String id = "아이디";
    loop : while(true) {
      System.out.print("아이디>> ");
      id = sc.nextLine();
      System.out.println("아이디 중복확인 중 입니다.");
      try {
        Thread.sleep(2000);
        msg = "SELECT id FROM member";
        RS = ST.executeQuery(msg);
        while(RS.next()==true) {
          String tmpid = RS.getString("ID");
          if(id.equals(tmpid)) {
            System.out.println("이미 있는 ID입니다");
            continue loop;
          }//if end
        }//while end
        System.out.println("아이디로 사용가능합니다.");
        break;
      }catch(Exception ex) { }
    }//while end


    String psw = "비밀번호";

    while(true) {
      System.out.print("비밀번호>> ");
      psw = sc.nextLine();
      System.out.println("비밀번호 재확인>>");
      String tmp = sc.nextLine();
      if(psw.equals(tmp)) {
        System.out.println("비밀번호가 일치합니다.");
        break;
      }else {
        System.out.println("비밀번호가 일치하지 않습니다.");
        continue;
      }//if end
    }//while end
    System.out.print("이름>> ");
    String name = sc.nextLine();
    System.out.print("email>> ");
    String email = sc.nextLine();

    msg = "INSERT INTO member VALUES(member_seq.nextval,"+ name +","+ id +","+ psw +","+ email +",sysdate";
    try {
      ST.executeUpdate(msg);
    }catch(Exception ex) { }
  }//join end
}//Class END
