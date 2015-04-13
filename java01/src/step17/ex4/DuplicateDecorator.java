package step17.ex4;

/*
 * 로봇을 두번 연속 실행하는 역할*/
public class DuplicateDecorator extends Robot{
  Robot robot;
  public  DuplicateDecorator(Robot robot){
    this.robot = robot;
  }

  @Override
  public void run() {
    robot.run();
    robot.run();
  }

}
