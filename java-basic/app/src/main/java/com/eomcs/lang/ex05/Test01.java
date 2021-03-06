package com.eomcs.lang.ex05;

//# 비트 연산자 : 응용 II
//
public class Test01 {
  public static void main(String[] args) {

    int lang2 = 0;

    final int LANG_C      = 0b10000000; //0x80
    final int LANG_CPP    = 0b01000000; //0x40
    final int LANG_JAVA   = 0b00100000; //0x20
    final int LANG_JS     = 0b00010000; //0x10
    final int LANG_PYTHON = 0b00001000; //0x08
    final int LANG_PHP    = 0b00000100; //0x04
    final int LANG_HTML   = 0b00000010; //0x02
    final int LANG_CSS    = 0b00000001; //0x01

    lang2 |= LANG_C;
    lang2 |= LANG_JAVA;
    lang2 |= LANG_PYTHON;
    lang2 |= LANG_HTML;

    System.out.println(Integer.toBinaryString(lang2));

    lang2 = LANG_C | LANG_JAVA | LANG_PYTHON | LANG_HTML;
    System.out.println(Integer.toBinaryString(lang2));

    lang2 = lang2 - LANG_JAVA;
    System.out.println(Integer.toBinaryString(lang2));

  }
}
