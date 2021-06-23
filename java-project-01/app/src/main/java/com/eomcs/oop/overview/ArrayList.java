package com.eomcs.oop.overview;

import com.eomcs.oop.overview.App.Board;

public class ArrayList {

  static final int MAX_LENGTH = 100;
  static Object[] list = new Board[MAX_LENGTH];
  static int size = 0; // 로컬변수는 초기화 안하면 오류난다.

  static void append(Object obj) {
    list[size++] = obj;
  }

  static Object[] toArray() {
    Object[] arr = new Object[size];

    for (int i = 0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr;
  }
  static Object retrieve(int index) {
    return list[index];
  }
  static void remove(int index) {
    for (int i = index; i < size - 1; i++) {
      list[i] = list[i + 1];
    }

    size--;
  }
}