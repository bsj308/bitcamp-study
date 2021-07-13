package net.project.mini1;

import java.util.Scanner;

public class ProjectTestMain {
  public static void main(String[] args) {
    PTWordTest wordTest = new PTWordTest("ID3",2);
    JoinMember joinmember = new JoinMember();
    Scanner sc = new Scanner(System.in);

    while(true) {
      System.out.println("1.회원가입 2.단어시험 3.종료");
      System.out.print("메뉴>> ");
      try{
        String menu = sc.nextLine();

        switch(menu) {
          case "1":
            joinmember.dbConnect();
            joinmember.join();
            break;
          case "2":
            wordTest.dbConnect();
            wordTest.wordTest();
            break;
          case "3":
            System.exit(0);
        }//switch end
      }catch(Exception ex) { }
    }//while end
  }//main end
}//Test Class END
