package step20.ex6;


/*
 * Thread 
 * => 프로세스에 종속되어 독립적으로 실행되는 코드 블럭
 *    프로세스의 Heap , Method Area 영역을 공유한다.
 *    Stack 영역을 개별적으로 관리한다.
 *    
 *    JVM 프로세스도 실행할 떄 여러 스레드를 보유한다.
 *    GarbageCollector : 프로그램 실행과는 달리 별도로 실행 하여야 한다.
 *    main() 메서드 호출하는 스레드
 *    객체의 레퍼런스를 관리하는 스레드
 *    
 *    실습목표 : JVM이 실행 할 때 함께 존재하는 스레드 알아내기
 *    ==> Thread map
 *    [TG] system    <--최상위 스레드 그룹이다.
 *            -Reference Handler Thread
 *            - Finalizer Thread
 *            -Single Dispatcher Thread
 *            [Thread Group]main
 *                              -main Thread
 *                              
 * */

public class Test1{
  public static void main(String[] args) {
    //현재 명령을 실행하는 스레드를 리턴한다.
     Thread main = Thread.currentThread();
     
     System.out.println(main.getName());
     
     
     //스레드가 소속되어 있는 그룹 알아내기
     ThreadGroup mainTG = main.getThreadGroup();
     System.out.println("main쓰레드가 소속되어 있는 그룹 : "+mainTG.getName());
     //main 쓰레드 그룹의 바깥그룹 알아네기
     ThreadGroup systemTG = mainTG.getParent();
     System.out.println("main그룹의 바깥 그룹은"+systemTG.getName());
     
     //System그룹에 속해있는 하위 쓰레드 그룹 알아내기
     //1) 하위 쓰레드 그룹을 담을 배열을 준비한다.
     ThreadGroup [] childGroup = new ThreadGroup[100];
     int count = systemTG.enumerate(childGroup);
     
     for (int i = 0; i < count; i++) {
       System.out.println(childGroup[i].getName());      
    }
     
     
     //System 그룹의 쓰레드 목록 알아내기
     Thread [] threadList = new Thread[100];
     count = systemTG.enumerate(threadList, false);
     for (int i = 0; i < count; i++) {
      System.out.println("Systme => "+threadList[i].getName());
    }
     
     System.out.println("-----------------------");
     systemTG.list();
    
     
  }
}
