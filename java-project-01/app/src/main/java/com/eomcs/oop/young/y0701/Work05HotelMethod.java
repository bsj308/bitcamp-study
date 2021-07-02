package com.eomcs.oop.young.y0701;

import java.util.Scanner;

public class Work05HotelMethod implements Work05HotelImp {

  private int floor; //층=행 3층
  private int room; //호=열 5호
  String[][] name = new String[3][5];
  String title;
  Scanner sc = new Scanner(System.in);

  @Override
  public void checkIn(){
    loop: while(true) {
      try {
        System.out.print("몇 층에 투숙하시겠어요? ");
        floor = Integer.parseInt(sc.nextLine());
        if(floor<1 || floor>name.length) {
          System.out.printf("범위를 벗어났습니다. (1..%d)\n\n", name.length);
          continue;
        }//if end

        while(true) {
          try {
            System.out.print("몇 호에 투숙하시겠어요? ");
            room = Integer.parseInt(sc.nextLine());

            if(room<1 || room>name[0].length) {
              System.out.printf("범위를 벗어났습니다. (1..%d)\n\n", name[0].length);
              continue;
            }else if(name[floor-1][room-1] != null) {
              System.out.println("이미 예약된 방입니다.");
              continue loop;
            }//if end
            break;
          }catch(Exception ex) {System.out.println("숫자를 입력해주세요.\n");}
        }//while end

        break;
      }catch(Exception ex) {System.out.println("숫자를 입력해주세요.\n");}
    }//while end

    while(true) {
      System.out.print("성함을 입력해주세요 >>> ");
      String tmp = sc.nextLine();

      if(tmp.equals("")) {
        System.out.println("성함을 다시 입력해주세요 >>>");
        continue;
      } else {
        name[floor-1][room-1] = tmp;
        System.out.printf("%d0%d호 예약이 완료됐습니다.\n",floor,room);
      }//if end
      break;
    }//while end

  }//end

  @Override
  public void checkOut() {
    loop: while(true) {
      try {
        System.out.print("몇 층에서 퇴실하하시겠어요? ");
        floor = Integer.parseInt(sc.nextLine());
        if(floor<1 || floor>name.length) {
          System.out.printf("범위를 벗어났습니다. (1..%d)\n\n", name.length);
          continue;
        }//if end

        while(true) {
          try {
            System.out.print("몇 호에서 퇴실하시겠어요? ");
            room = Integer.parseInt(sc.nextLine());

            if(room<1 || room>name[0].length) {
              System.out.printf("범위를 벗어났습니다. (1..%d)\n\n", name[0].length);
              continue;
            }else if(name[floor-1][room-1] == null) {
              System.out.println("퇴실할 수 있는 방이 아닙니다.\n");
              continue loop;
            }//if end
            break;
          }catch(Exception ex) {System.out.println("숫자를 입력해주세요.\n");}
        }//while end

        break;
      }catch(Exception ex) {System.out.println("숫자를 입력해주세요.\n");}
    }//while end

    int count = 0;
    while(true) {
      System.out.print("예약자분 성함을 입력해주세요 >>> ");
      String tmp = sc.nextLine();

      if(tmp.equals("")) {
        System.out.println("잘못된 형식으로 입력하셨습니다.\n");
        continue;
      } else if(!name[floor-1][room-1].equals(tmp)) {
        System.out.println("예약자 성함이 아닙니다.\n");
        count++;
        if(count == 3) {
          System.out.println("예약자가 아니십니다. 퇴실을 종료합니다.");
          break;
        }
      } else {
        name[floor-1][room-1] = null;
        System.out.printf("%d0%d호 퇴실이 완료됐습니다.\n",floor,room);
        break;
      }//if end
    }//while end

  }//end

  @Override
  public void map() { //printAll() = list() = display()
    System.out.printf("\n\t[ %s 투숙 상태 ]\n\n",title);

    for(int i=0; i<name.length; i++) {
      for(int j=0; j<name[i].length; j++) {
        System.out.print((i+1)+"0"+(j+1)+"\t");
      }//for end
      System.out.println();

      for(int j=0; j<name[i].length; j++) {
        if(name[i][j] == null) {
          System.out.print("\t");
        } else {
          System.out.print(name[i][j] + "\t");
        }//if end
      }//for end
      System.out.println();
      System.out.println("---------------------------------------");
    }//for end
  }//end

  @Override
  public void list() {
    System.out.printf("\n\t[ %s 투숙 상태 ]\n\n",title);

    for(int i=0; i<name.length; i++) {
      for(int j=0; j<name[i].length; j++) {
        System.out.print((i+1)+"0"+(j+1) + "호 ");

        if(name[i][j] == null) {
          System.out.print("□ \t");
        } else {
          System.out.printf("■ %s\t",name[i][j]);
        }//if end
      }//for end
      System.out.println();
    }//for end
  }//end
}//Class END
