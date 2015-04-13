package step16.ch03;

import java.util.Scanner;

import step16.ch03.control.MemberControl;
/*
 * Interface의 활용
 * 
 * 
 * 
 * 인터페이스란?
 *  - 호출자와 호출 되는 자의 사이의 호출 규칙을 정의한 것.
 *  - Method 이름 , parameter , return Type을 선언.
 *  
 *  - 그러나 method를 구현 하지는 않는다.
 *  - interface의 모든 method는 public abstract 이다.
 *  => 만약 public abstract를 붙이지 않으면 compile할 때 자동으로 붙인다.
 *  
 *  - instance변수를 선언할 수 없다.
 *  
 *  =>interface의 모든 변수는 public static final이다.
 *  =>변수에 public static final을 붙이지 않으면 comepile할 때 자동으로 붙인다.
 *  - 단 상수 변수는 선언 할 수 있다.
 *  
 *  -MemberControl과 UIObject 의 관계를 살펴보면
 *  =>  MemberContrl이 일방적으로 UIObject Class를 사용한다는 것을 알 수 있다.
 *  =>  UIObject의 execute() 는 MemberControl과 UIObject클래스 사이의 호출 규칙임을 알 수 있다.
 *  => 그럼에도 불구하고 UIObject는 abstractClass로 선언하였따.
 *  => 사실 추상클래스의 목적은 Sub클래스에 공통되는 무언가를 상속 해주는 것 인데 , 
 *       UIObject를 보면 SubClass를 위해 상속해 주는 것이 아무 것도 없다.
 *       
 *  => 이런 경우에는 차라리 UIObject를 interface로 정의 하는 것이 바람직 하다.
 *    
 * Q&A
 * Q : 추상클래스 에서도 추상 메서드를 선언 할 수 있고 , 
 *      interface에서도 추상 메서드를 선언 합니다.
 *      그렇다면 둘중에 아무거나 사용 해도 되지 않나요?
 * A : 자장면도 배부르고  , 김치찌개도 배부르다면 아무거나 먹어도 되지 않나요?
 * A : 기차를 타고가나 버스를 타고가나 아무거나 타도 되지 않느냐?
 * 
 * 결론 : 두 문법의 용도가 다르다 , abstract Class는 something 상속해줄 필요가 있을때 사용되는 문법
 *        추상메서드는 단지 선택사항!!!
 *        서브클래스에서 Overriding을 강제적으로 하기위한 방법일 뿐이다.
 *        추상 클래스에서는 반드시 추상 메서드가 있어야 한는 것은 아니다.
 *          
 *        반면 interface의 용도는 호출규칙을 정의하는 것이다.
 *        
 *        만약 어떤 클래스가 여러개의 규칙을 따를때 어떻게 할 것인가
 *        => abstract클래스의 경우 오직 하나의 클래스만 상속받을 수 있기 때문에,
 *            여러개의 규칙을 준수 하는 클래스를 만들수 없다.
 *            
 *        하지만 interface는 여러개의 interface를 함께 implement할 수 있다.
 *        
 *        그래서 호출 규칙(아까처럼 execute()를 서브클래스에서 무조껀 Overriding해주고 싶을때)
 *        은 interface로 정의하라!
 *      
 * */


public class App {

  public static void main(String[] args) {
    MemberControl memberControl = new MemberControl();

    //1) MemberControl에게 init() 메시지를 보낸다.
    memberControl.init();

    String command = null;
    Scanner keyScan = new Scanner(System.in);
    do {
      //2)사용자에게 프롬프트를 출력한다.
      System.out.print(">");
      
      //3)사용자로부터 명령어를 입력 받는다.
      command = keyScan.nextLine();
      String[] token = command.split(" ");
      
      switch (token[0]) {
      case "add":
        memberControl.add();
        break;
      case "list":
        memberControl.list();
        break;
      case "detail":
        memberControl.detail( Integer.parseInt( token[1] ) );
        break;
      case "delete":
        memberControl.delete(Integer.parseInt(token[1]));
        break;
      case "change":
        memberControl.change(Integer.parseInt(token[1]));
        break; 
      
      default:
        System.out.println("존재하지 않는 명령어입니다.");
      }
      
    //4)명령어에 따라 MemberControl을 실행한다.
    //5)만약 명령어가 "quit"이라면, 반복을 멈춘다.
    //2) 번으로 돌아간다.
    } while (!command.equals("quit"));
    
    keyScan.close();
  }

}










