package step17.ex4;

/*
 * 실습목표 : Decorator 설계방법 익히기
 * => 데코레이터를 사용하여 기능을 넣고 빼기*/
public class Test1 {

  public static void main(String[] args) {
//    1) 기본로봇
    ClearRobot clearRobot = new ClearRobot();
//    청소로봇 실행
    clearRobot.run();
    AnmaRobot anmaRobot = new AnmaRobot();
//    안마로봇 실행
    anmaRobot.run();
    
    
//    기본로봇의 기능을 확장하자(알람기능을 넣자)
//    청소로봇+알람기능
    
    AlarmDecorator d1 = new AlarmDecorator(clearRobot);
//    청소로봇 실행예약
    d1.bookRunning(1000);
    //안마로봇 + 알람기능
    AlarmDecorator d2 = new AlarmDecorator(anmaRobot);
    d2.bookRunning(5000);
    
//    안마로봇 + 알람 + 두번실행기능
    DuplicateDecorator d3 = new DuplicateDecorator(anmaRobot);
    AlarmDecorator d4 = new AlarmDecorator(d3);
    System.out.println("안마로봇 실행예약 + 중복실행!----------------");
    d4.bookRunning(5000);
    
    
  }

}
