package com.eomcs.oop.young.y0701;

public class Work05Hotel extends Work05HotelMethod {

  public Work05Hotel() { }
  public Work05Hotel(String name) {
    this.title = name;
    System.out.println("  *** " + title + " ***");
    System.out.println(title + "방문을 축하합니다");
  }//end
  public Work05Hotel(String name, int year) {
    this.title = name;
    System.out.println("  *** " + title + " ***");
    System.out.println(title + "방문을 축하합니다");
    System.out.println(title + "은 설립된지 " + year + "년된 호텔입니다.");
  }//end

  public static void main(String[] args) {

    Work05Hotel wh = new Work05Hotel("호텔델루나");
    wh.process();
  }

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
          super.map();
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

  @Override
  public void map() {
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
      System.out.println("***************************************");
    }//for end
  }//end
}
