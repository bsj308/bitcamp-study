package net.project.mini1;

public class ProjectTestMain {
  public static void main(String[] args) {
    PTWordTest wordTest = new PTWordTest("ID2",1);
    JoinMember joinmember = new JoinMember();
    //wordTest.dbConnect();
    //wordTest.wordTest();
    joinmember.dbConnect();
    joinmember.join();

  }
}//Test Class END
