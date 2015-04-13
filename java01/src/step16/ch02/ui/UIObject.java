package step16.ch02.ui;

import java.util.HashMap;


/*
 * 추상클래스 적용후!
 * 
 * 1) 이 클래스를 직접사용하지말고 => 직접사용을 제한한다.
 * 2) 이 클래스의 기능을 상속 받아서 서브 클래스를 만들어 사용하라!
 * 
 * 추상 method적용
 *  반드시 서브 클래스에서 execute() 를 Overriding 하도록 강제한다.
*/

public abstract  class UIObject {
  public  abstract void execute(HashMap<String, Object> parameterMap);

}
