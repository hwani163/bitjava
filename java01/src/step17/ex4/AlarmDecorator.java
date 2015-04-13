package step17.ex4;


/*
 * 로봇에 기능을 Decorate하는 Class입니다
 * Decotator 역할을 수행하는 Class는 
 *    1) 주요Class와 동일하게 같은 superClass(Robot)를 상속받아야 한다.
 *    2) 생성자에서 기능을 확장할 객체를 받아야 한다.*/
public class AlarmDecorator extends Robot {
  
  Robot robot;
  public  AlarmDecorator(Robot robot) {
    this.robot = robot;
  }
  
  @Override
  public void run() {
    
//    데코레이터 역할을 수행하는 클래스는 직접 작업을 해서는 안된다.
//    생성자에서 받은 객체를 사용하여 작업을 수행한다.
    robot.run();

  }
  
  public void bookRunning(int mills){
    try {
      Thread.sleep(mills);
      run();
    } catch (InterruptedException e) {
      
      e.printStackTrace();
    }
  }

}
