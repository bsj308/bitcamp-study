package com.eomcs.oop.young.y0701;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Memo extends Frame implements WindowListener, ActionListener {
  private Button btnExit = new Button(" exit ");
  private Button btnSend = new Button(" send ");
  private TextField tf = new TextField(20); //한줄입력
  private TextArea ta = new TextArea(); //가로row*세로column
  private Font ff = new Font("consolas",Font.BOLD, 20);
  private Panel pan = new Panel(); //레이아웃받침대 = 쟁반역할

  public Memo() {
    //초간단메모장
    pan.add(tf); pan.add(btnSend); pan.add(btnExit);

    ta.setFont(ff);
    this.add("Center", ta);
    this.add("South", pan); //pan=Panel 판넬

    //이벤트연결 리스너 추가

    //    Memo mm = new Memo();
    //    addWindowListener(mm);
    //WindowListener w1 = new WindowListener();
    //addWindowListener(w1);
    this.addWindowListener(this); //앞this 뒤this //괄호안매개인(WindowListener) //없으면 불편 윈도우X로 종료안됨
    tf.addActionListener(this); //없으면 엔터키로 전달안됨
    btnSend.addActionListener(this);
    btnExit.addActionListener(this);

    //프레임의 메소드값 변경
    ta.setBackground(Color.YELLOW);
    this.setSize(400, 500);
    this.setTitle("초간단메모장");
    this.setVisible(true);
  }

  @Override public void windowClosing(WindowEvent e) {myExit();}
  @Override public void windowOpened(WindowEvent e) { }
  @Override public void windowClosed(WindowEvent e) { }
  @Override public void windowIconified(WindowEvent e) { }
  @Override public void windowDeiconified(WindowEvent e) { }
  @Override public void windowActivated(WindowEvent e) { }
  @Override public void windowDeactivated(WindowEvent e) { }

  @Override
  public void actionPerformed(ActionEvent ae) {
    //메뉴클릭, 버튼클릭, 이미지클릭, 입력란enter
    if(ae.getSource()==tf) { //tf한줄입력란
      myText();
    }else if(ae.getSource()==btnSend) {
      myText();
    }else if(ae.getSource()==btnExit) {
      myExit();
    }else {}
  }//end

  public void myText() {
    //1. tf입력란 데이터가져오기
    //2. tf내용을 ta에 추가후 tf내용삭제, tf입력란에 초점
    String data = tf.getText();
    ta.append(data+"\n");
    tf.setText(""); //내용삭제
    tf.requestFocus();
  }//end

  public void myExit() {
    System.out.println("초간단 메모장 프로그램을 종료합니다");
    System.exit(0); //프로그램 완전종료
  }//end

  public void bitCamp() {
    //    AAA ac = new AAA(); //에러발생
    //    WindowListener w1 = new WindowListener();
  }

  public static void main(String[] args) {
    Memo pad = new Memo();
    //AAA aa = null; //선언만
    //AAA ac = new AAA(); //에러발생
    //WindowListener w1 = new WindowListener();
    //pad.windowClosing(null);
  }

}//class End
