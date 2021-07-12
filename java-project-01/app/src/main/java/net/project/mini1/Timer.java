package net.project.mini1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;  

public class Timer {



  public static void main(String[] args) throws java.io.IOException {
    Questio q = new Questio(); //메소드
    System.out.println("You have 5 seconds: " + q.toString()); // 메소드 값호출

    String userAnswer = null; // 내 답변
    ExecutorService ex = Executors.newSingleThreadExecutor();
    //쓰레드 1개인 ExecutorService를 리턴합니다. 싱글 쓰레드에서 동작해야하는 작업을 처리할 때 사용합니다.
    try {
      Future<String> result = ex.submit(new GetInputLineCallable()); // 정답함수 받아서 쓰레드에 전달
      //submit은 Runnable 또는 Callable을 받는다. Runnable은 리턴값이 없고 Callable은 리턴값이 있다.
      try {
        userAnswer = result.get(5, TimeUnit.SECONDS);
        //필요에 따라서 최대지정된 시간, 계산이 완료할 때까지 대기해, 그 후, 계산 결과가 이용 가능한 경우는 결과를 가져옵니다.
        if (Integer.valueOf(userAnswer) == q.getAnswer()){
          System.out.println("good!");
        }
        else{
          System.out.println("Incorrect!");
        }

      } catch (ExecutionException e) { // 작업도중에 에러가 발생한 경우에 발생
        e.getCause().printStackTrace(); // 오류출력
      } catch (TimeoutException e){ //대기시간이 초과된 경우에 발생
        System.out.println("too late!"); // 시간초과
        return;
      } catch (InterruptedException e){ //현재 스레드가 인터럽트된 경우에 발생
        System.out.println("interrupted?");
        e.getCause().printStackTrace(); // 오류출력
      }

    } finally {
      ex.shutdownNow(); //진행중인거 강제 종료
      //스레드 풀의 스레드는 기본적으로 데몬 스레드가 아니기 때문에 main 스레드가 종료되더라도 작업을 처리하기 위해 계속 실행 상태로 남아있습니다.
      //프로세스를 종료시키려면 스레드 풀을 종료시켜 스레드들이 종료 상태가 되도록 처리필요
    }
  }
}



class GetInputLineCallable implements Callable<String> { // 값 입력받기
  @Override
  public String call() throws IOException {
    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    while ("".equals(input)) {
      try {
        while (!inp.ready()) {
          Thread.sleep(100);
        }
        input = inp.readLine();
      } catch (InterruptedException e) {
        return null;
      }
    } 
    return input;
  }
}




class Questio{ //문제함수
  int p1, p2;
  public Questio(){
    p1 = 2;
    p2 = 3;
  }
  @Override
  public String toString(){
    return String.format("%d + %d = ?", p1, p2);
  }
  public int getAnswer(){
    return p1+p2;
  }  
}

