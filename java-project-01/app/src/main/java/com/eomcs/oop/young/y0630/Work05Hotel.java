package com.eomcs.oop.young.y0630;

import java.util.Scanner;

public class Work05Hotel {

  private int floor; //층=행 3층
  private int room; //호=열 5호
  private String[][] name = new String[3][5];
  private String title;

  public Work05Hotel() { }
  public Work05Hotel(String name) {
    System.out.println("    *** " + name + " ***");
    System.out.println(name + "방문을 축하합니다");
  }
  public Work05Hotel(String name, int year) { }

  public void process() {
    Scanner sc = new Scanner(System.in);
    int sel = 9;
    while(true) {
      System.out.print("\n1.투숙 2.퇴실 3.map 4.list 9.종료 >>> ");
      try{ sel = Integer.parseInt(sc.nextLine()); }catch (Exception ex) { }
      if(sel==9) {
        System.out.println("호텔예약프로그램 종료합니다");
        System.exit(1);
      }
      switch(sel) {
        case 1:
          checkIn();
          break;
        case 2:
          checkOut();
          break;
        case 3:
          map();
          break;
        case 4:
          list();
          break;
        default:
          System.out.println("잘못 입력하셨습니다.");

      }//switch end
    }//while end
  }//end

  public void checkIn(){
    Scanner sc = new Scanner(System.in);

    while(true) {
      try {
        System.out.print("몇 층에 투숙하시겠어요? ");
        floor = Integer.parseInt(sc.nextLine());

        System.out.print("몇 호에 투숙하시겠어요? ");
        room = Integer.parseInt(sc.nextLine());

        System.out.print("성함을 입력해주세요. ");
        name[floor-1][room-1] = sc.nextLine();
        break;
      }catch (Exception ex) { }
    }//while end

  }//end

  public void checkOut() {

  }

  public void map() { //printAll() = list() = display()

    for(int i=0; i<name.length; i++) {
      for(int j=0; j<name[i].length; j++) {
        System.out.print("10"+(j+1)+"\t");
        System.out.printf("%s\t",name[i][j]);
      }
      System.out.println();
      System.out.println("---------------------------------------------------------------------");
    }

  }

  public void list() { //영림쌤

  }

  public static void main(String[] args) {

    Work05Hotel wh = new Work05Hotel("남산하얏트");
    wh.process();




  }

}
