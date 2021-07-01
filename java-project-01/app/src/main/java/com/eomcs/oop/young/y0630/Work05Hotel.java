package com.eomcs.oop.young.y0630;

import java.util.Scanner;

public class Work05Hotel {

  private int floor; //층=행 3층
  private int room; //호=열 5호
  private String[][] name = new String[3][5];
  private String title;
  Scanner sc = new Scanner(System.in);

  public Work05Hotel() { }
  public Work05Hotel(String name) {
    System.out.println("  *** " + name + " ***");
    System.out.println(name + "방문을 축하합니다");
  }
  public Work05Hotel(String name, int year) { }

  public void process() {
    int sel = 9;
    while(true) {
      System.out.print("\n1.투숙 2.퇴실 3.map 4.list 9.종료 >>> ");
      try{
        sel = Integer.parseInt(sc.nextLine());
      }catch (Exception ex) { System.out.println("잘못입력하셨습니다."); continue; }

      if(sel==9) {
        System.out.println("호텔예약프로그램 종료합니다");
        System.exit(1);
      }

      switch(sel) {
        case 1:
          map();
          checkIn();
          break;
        case 2:
          map();
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
    while(true) {
      try {
        System.out.print("몇 층에 투숙하시겠어요? ");
        floor = Integer.parseInt(sc.nextLine());

        System.out.print("\n몇 호에 투숙하시겠어요? ");
        room = Integer.parseInt(sc.nextLine());
        if(room<0 || room>5) {
          System.out.println("범위를 벗어났습니다.");
          continue;
        }else if(name[floor-1][room-1] != null) {
          System.out.println("이미 예약된 방입니다.");
          continue;
        }//if end

        while(true) {
          System.out.print("\n성함을 입력해주세요 >>> ");
          String tmp = sc.nextLine();

          if(tmp.equals("")) {
            System.out.println("성함을 다시 입력해주세요 >>>");
            continue;
          } else {
            name[floor-1][room-1] = tmp;
            System.out.printf("%d0%d호 예약이 완료됐습니다.\n",floor,room);
            break;
          }//if end
        }//while end
        break;
      }catch (Exception ex) { }
    }//while end
  }//end

  public void checkOut() {
    while(true) {
      try {
        System.out.print("몇 층에서 퇴실하시겠어요? ");
        floor = Integer.parseInt(sc.nextLine());

        System.out.print("\n몇 호에서 퇴실하시겠어요? ");
        room = Integer.parseInt(sc.nextLine());

        if(room<0 || room>5) {
          System.out.println("범위를 벗어났습니다.");
          continue;
        }else if(name[floor-1][room-1] == null) {
          System.out.println("퇴실할 수 있는 방이 아닙니다.");
          continue;
        }else {
          name[floor-1][room-1] = null;
          System.out.printf("%d0%d호 퇴실이 완료됐습니다.\n",floor,room);
        }
        break;
      }catch (Exception ex) { }
    }//while end
  }

  public void map() { //printAll() = list() = display()
    System.out.println("\t[ 델루나 투숙 상태 ]");
    System.out.println("-------------------------------------");
    for(int i=0; i<name.length; i++) {
      for(int j=0; j<name[i].length; j++) {
        System.out.print((i+1)+"0"+(j+1)+"\t");
      }
      System.out.println();

      for(int j=0; j<name[i].length; j++) {
        if(name[i][j] == null) {
          System.out.print("\t");
        } else {
          System.out.print(name[i][j] + "\t");
        }
      }
      System.out.println();
      System.out.println("---------------------------------------");
    }//for end
  }//end

  public void list() { //영림쌤

  }

  public static void main(String[] args) {

    Work05Hotel wh = new Work05Hotel("호텔델루나");
    wh.process();

  }
}
