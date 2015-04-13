package step16.ch02;

import java.util.Scanner;

import step16.ch02.control.MemberControl;


/*이번 chaper 학습목표
 * 상속 :  일반화(Generalization)
 * => 기존 UI클래스들의 공통점을 찾아서 SuperClass로 정의하기.
 * => MemberControl이 UI 객체를 사용할 떄 더 일관된 방법으로 호출 할 수 있다.
 * 
 * 작업 : 
 *    1) UIObject Class생성
 *    2) 기존 UI 클래스들은 UIObject를 상속 받는다.
 *    3) MemberControl 변경하기!
 *
 *
 *추상 클래스(Abstract Class)
 *=> 직접사용하는 경우는 없다.
 *     Sub클래스 에게 공통으로 상속 해줄 Method와 Instance변수를 가지고 있는 클래스를
 *     만들때 사용하는 문법!
 *=> 추상 클래스 그 자체는 직접 인스턴스로 만들어 쓸 수 없다.
 *=> Sub클래스에 무언가를 상속해주는 용도.
 *=> UIObject.java 의 경우 직접적으로 클래스를 사용하기 보다는
 *=> MemberAdd와 MemberList와 같이 UI를 처리하는 클래스를 만들 때 
 *     상속 받기 위한 용도.
 *     즉 UIObject 클래스는 추상 클래스로 선언하기가 적합하다!!
 *
 *
 *
 *
 *
 *
 * 상속의 두가지 기능
 * 1) Specialization(특수화)
 * ->Super Class를 상ㅅㄱ받아서 좀더 특별하게 만드는 것.
 * ->인스턴스 변수와 메스더를 추가하면 더 특별한 클래스가 된다.
 * 
 * 2) Generaliztion(일반화)
 *    ->클래스 들의 common method 와 instance변수를 찾아서
 *    superClass로 정의하고 그 superClass를 상속 받는것!
 *    SuperClass를 잘 만들려고 하지말자! =>슬럼프에 빠진다.*/





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










