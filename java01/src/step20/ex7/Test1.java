package step20.ex7;

import java.util.concurrent.Delayed;

/*
 * 실습 목표 :  다중 Thread에 안전하지 않는 코드
 * 여러 쓰레드에서 동시에 withdraw()를 호출 한다.
 * 여러 Thread가 동시에 balance 변수값을 변경한다.
 * => 잘못된 결과를 만든다.
 * 
 * withdraw() 처럼 동시에 여러 Thread가 호출했을 때 발생되는 것을
 * Thread에 안전하지 않는 코드 라고 부른다.
 * Critical Section 이라고 부른다.
 * ==> 동시에 여러 스레드가 접근 했을 때 잘못된 결과를 낼 수 있는 코드블럭
 * 
 * 해결책 ? 접근 개수의 관리가 필요하다.
 * 
 * Semaphore
 * -> Critica Section 에 접근할 수 있는 Thread 수를 지정한다.
 * -> 지정개수를 초과하면 다른 Thread는 기다려야 한다.
 * => 화장실!
 * 
 * Mutex(Mutual Exclusion, 상호 배제)
 * 1개 짜리 Semaphore를 말한다.
 * 
 * Thread-Safe
 * -> 동시에 여러 Thread가 접근하더라도 실행결과에 문제가 없는 코드
 * 예) delayTime()
 * */
public class Test1{
  static class Account{
    long balance;
    
    public Account(long balance){
      this.balance = balance;
      
    }
    public int withDraw(int money){
      long currBalance = this.balance;
      delayTime();
      
      currBalance = currBalance - money;
      delayTime();
      if (currBalance <0) {
        return 0;
        
      }
      delayTime();
      this.balance = currBalance;
      delayTime();
      return money;
      
      
    }
    
    
  }
  static  void delayTime() {
    // 돈을 찾는 중간에 네트웍의 속도 지연 등과 같은 이유로 
    // 프로그램 실행 중간에 약간의 시간이 지체되는 상황을 만들자.
    double x = 234.3456677888;
    x /= 2.5670345;      
  }
  
  static class ATM365 extends Thread{
    Account account;
    
    public ATM365(String name , Account account){
      super(name);
      this.account = account;
    }
  @Override
  public void run() {
    int sum =0;
    int money =0;
    for (int i = 0; i < 100; i++) {
      money = account.withDraw(100000);
      
      delayTime();
      
      if (money ==0) {
        break;
            }
      delayTime();
      
      sum+=money;
      delayTime();
      
     
    }
    System.out.println(this.getName()+"찾은금액 : "+sum);
  }
  
  
  
  }
  public static void main(String[] args) {
    Account account = new Account(1000000);
    
    ATM365 강남 = new ATM365("강남", account);
    ATM365 부산 = new ATM365("부산", account);
    ATM365 광주 = new ATM365("광주", account);
    ATM365 대전 = new ATM365("대전", account);
    ATM365 강릉 = new ATM365("강릉", account);

    강남.start();
    부산.start();
    광주.start();
    대전.start();
    강릉.start();
    
    
  }

}
