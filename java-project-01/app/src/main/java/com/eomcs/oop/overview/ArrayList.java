package com.eomcs.oop.overview;

public class ArrayList {

  static final int MAX_LENGTH = 100;

  Object[] list = new Object[MAX_LENGTH];
  int size = 0; // 로컬변수는 초기화 안하면 오류난다.

  //인스턴스 변수 (예: list, size)를 사용하는 메서드는 인스턴스 메서드를 전환한다.
  //인스턴스 메서드는 인스턴스 주소를 받는 this 이름의 레퍼런스를 내장하고 있다.
  void append(Object obj) {
    this.list[this.size++] = obj;
  }

  Object[] toArray() {
    Object[] arr = new Object[this.size];

    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
  Object retrieve(int index) {
    return this.list[index];
  }
  void remove(int index) {
    for (int i = index; i < this.size - 1; i++) {
      this.list[i] = this.list[i + 1];
    }

    this.size--;
  }
}