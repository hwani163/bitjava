package step16.ch03.ui;

import java.util.HashMap;


/*
 * interface 적용!
 * 
 * UIObject는 subClass에게 상속 해줄 어떤 것도 없다!
 * 단지 MemberControl이 호출 하는 method에 대하여 규칙을 정하고 싶을뿐....
 * 따라서 UIObject는 abstractClass로 정의하는 것 보다
 * interface로 정의하는것이 좋다.
 * 
 *  - interface를 만나게되면 누구와 누구의 호출 규칙인지 파악하라!
 *  - 호출자가 누구며 , 호출 당하는 자가 누구인지 확인하라!
 *  
 *  UIObject는 MemberControl과 UIObject사이의 호출 규칙이다.
 *  호출자 : MemberControl
 *  피호출자 : UI Class (MemberDelete , MemberList.....)
 * 
 * 문법 : 
 *  - class 클래스명 implements 규칙명{....}
 *  - 인터페이스를 구현하는 클래스는 인터페이스에 선언된 모든 메서드를 만들어야 한다.
*/

public interface  UIObject {
  
//  interface에 선언하는 method는 반드시 public abstract이어야 한다.
//  안적으면 compiler가 자동으로 추가한다.
//  public 대신 다른 접근자는 사용불가한다. 왜냐하면 규칙이기 때문이다. 규칙은 항상 공개되어야 한다.!!!!!!!!!!!
//  규칙은 구현 해서는 안된다. 반드시 abstract Method이여야 한다.
  public  abstract  void execute(HashMap<String, Object> parameterMap);

}
