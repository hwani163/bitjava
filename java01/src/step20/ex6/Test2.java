package step20.ex6;

/*
 * 실습목표 : 쓰레드 우선순위
 * 쓰레드 생성
 * 현재 쓰레드의 자식 쓰레드가 된다.
 * 자식 쓰레드는 부모 쓰레드의 우선순위를 그대로 물려 받는다.*/

public class Test2{
  public static void main(String[] args) {
    /*
     * 쓰레드를 생성할 때 실행하는 스레드가 부모 스레드다.
     * main() 호출하는 쓰레드 : main쓰레드
     * 다음 쓰레드는 main의 자식 쓰레드 이다.*/
    Thread t1 = new Thread();
    
    System.out.println("t1 스레드 우선순위 : "+t1.getPriority());
    System.out.println("현재쓰레드 : 메인쓰레드의 우선순위"+Thread.currentThread().getPriority());
  }
}