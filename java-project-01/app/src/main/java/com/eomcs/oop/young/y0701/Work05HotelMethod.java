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
        if(floor<0 || floor>name.length) {
          System.out.printf("범위를 벗어났습니다. (0..%d)\n", name.length);
          continue;
        }//if end

        while(true) {
          try {
            System.out.print("몇 호에 투숙하시겠어요? ");
            room = Integer.parseInt(sc.nextLine());

            if(room<0 || room>name[0].length) {
              System.out.printf("범위를 벗어났습니다. (0..%d)\n", name[0].length);
              continue;
            }else if(name[floor-1][room-1] != null) {
              System.out.println("이미 예약된 방입니다.");
              continue loop;
            }//if end
            break;
          }catch(Exception ex) {System.out.println("숫자를 입력해주세요.");}
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

        break;
      }catch(Exception ex) {System.out.println("숫자를 입력해주세요.");}
    }//while end
  }//end

  @Override
  public void checkOut() {
    loop: while(true) {
      try {
        System.out.print("몇 층에서 퇴실하하시겠어요? ");
        floor = Integer.parseInt(sc.nextLine());
        if(floor<0 || floor>name.length) {
          System.out.printf("범위를 벗어났습니다. (0..%d)\n", name.length);
          continue;
        }//if end

        while(true) {
          try {
            System.out.print("몇 호에서 퇴실하시겠어요? ");
            room = Integer.parseInt(sc.nextLine());

            if(room<0 || room>name[0].length) {
              System.out.printf("범위를 벗어났습니다. (0..%d)\n", name[0].length);
              continue;
            }else if(name[floor-1][room-1] == null) {
              System.out.println("퇴실할 수 있는 방이 아닙니다.");
              continue loop;
            }else {
              name[floor-1][room-1] = null;
              System.out.printf("%d0%d호 퇴실이 완료됐습니다.\n",floor,room);
            }//if end
            break;
          }catch(Exception ex) {System.out.println("숫자를 입력해주세요.");}
        }//while end

        break;
      }catch(Exception ex) {System.out.println("숫자를 입력해주세요.");}
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
  public void list() { //영림쌤
    System.out.printf("\n\t[ %s 투숙 상태 ]\n\n",title);

    for(int i=0; i<name.length; i++) {
      for(int j=0; j<name[i].length; j++) {
        System.out.print((i+1)+"0"+(j+1) + "호 ");

        if(name[i][j] == null) {
          System.out.print("□   \t");
          //System.out.printf("□ \t");
        } else {
          System.out.printf("■ %s \t",name[i][j]);
          //System.out.printf("■ %s \t",name[i][j]);
          //System.out.println("■" + name[i][j] +" \t");
        }//if end
      }//for end
      System.out.println();
    }//for end
  }//end
}//Class END
