package step20.ex6;

/*
 * 실습 목표 :  쓰레드 만들기
 * => Thread 클래스를 상속 받기
 */

public class Test3{
  // 독립적으로 실행할 코드를 담은 쓰레드를 만들자
  
  static class MyThread extends Thread{
    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        double x = 20.12345;
        x=x/2.34;
        System.out.println("Thread(쓰레드)"+i);
      }
    }
  }
  public static void main(String[] args) {
    /*
     * 쓰레드 실행하기
     * 1) 쓰레드 객체 생성
     */
    MyThread t1 = new MyThread();
    t1.start();
    
    for (int i = 0; i < 10000; i++) {
      double x = 20.12345;
      x/= 2.34;
      System.out.println("main=>"+i);
    }
    
    for (int i = 0; i < 10000; i++) {
      double x = 20.12345;
      x/= 2.34;
      System.out.println("main=>>>>>>>>>>>>"+i);
    }
 
  }
}