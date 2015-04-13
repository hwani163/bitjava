package step20.ex7;

/* 실습 목표: 크리티컬 섹션에 뮤텍스 적용하기
 * ==> 동기화(Syncronize) 라고 부른다.
 * ==> 일치하게 만든다! --> 동기화의 뜻
 *      곧 변수의 값이 쓰레드 실행에 상관 없이 일치하게 만든다.
 *      문법 : Critical Section?(특정 블록이나 메서드를 이야기 한다.)
 *               에 대하여 syncronize로 묶는다.
 */
public class Test2 {

  static class Account {
    long balance;
    
    public Account(long balance) {
      this.balance = balance;
    }
    
    
/*    돈을 찾을 떄는 한번에 한 쓰레드만 사용가능하게 한다.
     진입하면 해당 블록 전체를 locking한다(다른 스레드가 진입하지 못하도록).
     블록을 나올때 ( 메서드를 다 수행하면) 잠금을 헤제 한다.
    잠금을 해제 하면 다른 스레드가 접근 할 수 있다.
    synchronized를 하게되면 몇번을 실행 하더라고 각 지점에서 찾은 금액이 100만원을 넘지 않는다.
    => critical section을 실행 하다가 cpu를 빼앗기더라도 , 다른 쓰레드는 접근 할 수 없다.
        그렇게 되면 CPU를 갖고 있는 thread는 끝날 때 까지 계속 기다려야 한다.*/
    synchronized public  int  withdraw(int money) {
      long currBalance = this.balance;
      
      delayTime(); // CPU 뺏기고 싶어요!
      
      currBalance -= money;
 
      delayTime(); // CPU 뺏기고 싶어요!
      
      if (currBalance < 0) 
        return 0;
      
      delayTime(); // CPU 뺏기고 싶어요!
      
      this.balance = currBalance;
      
      delayTime(); // CPU 뺏기고 싶어요!
      
      return money;
    }
    
  }
  
  static class ATM365 extends Thread {
    Account account;
    
    public ATM365(String name, Account account) {
      super(name);
      this.account = account;
    }
    
    @Override
    public void run() {
      int sum = 0;
      int money = 0;
      for (int i = 0; i < 100; i++) {
        money = account.withdraw(10000);
        
        delayTime();
        
        if (money == 0)
          break;
        
        delayTime();
        
        sum += money;
        
        delayTime();
      }
      System.out.printf("[%s]찾은 금액: %d\n", this.getName(), sum);
    }
  }
//로컬변수만 있으면 스레드 세이프 코드
  //스레드 안전 코드 : 여러 스레드가 동시에 호출해도 문제가 없다.
  static private void delayTime() {
    // 돈을 찾는 중간에 네트웍의 속도 지연 등과 같은 이유로 
    // 프로그램 실행 중간에 약간의 시간이 지체되는 상황을 만들자.
    double x = 234.3456677888;
    x /= 2.5670345;
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



















