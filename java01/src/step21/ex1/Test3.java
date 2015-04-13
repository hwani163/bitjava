package step21.ex1;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/* 실습목표 : close 버튼을 눌렀을 때 시스템(JVM) 종료하기!
 * Close버튼을 누르면 WindowEvent가 발생한다.
 * JVM은 WindowEvent를 처리할 객체를 찾는다.
 * WindowEvent를 처리할 객체란?
 * 
 * 그 Event처리 객체의  windowClosing() 메서드를 호출한다.
 * 그 이벤트를 처리하는 객체를 "리스너" 라고 부른다.
*  
*  이벤트 처리과정 : 
*  6) Messagequeue에 들어있는 이벤트 정보를 꺼내서 , 
*  유형에 따라 EventObject 서브 클래스의 객체를 생성하여 이벤트 정보를 옮긴다.
*  예) 윈도우의 close 버튼 이벤트는 WindowEcent 객체에 저장된다.
*  * EventObject : 이벤트 정보를 표현하는 최상위 객체.
*  
*  7) 그 EventObject객체를 EventQueue 에 보관한다.
*  EventQueue : 이벤트 객체를 순서대로 저장하는 보관소.
*  
*  8) EventDispatcherThread 는 계속 EventQueue를 감시하고 있다가.
*  이벤트가 하나 들어오면 그 이벤트를 꺼낸다.
*  
*  9) 이벤트 정보를 조사하여 그 이벤트를 받을 객체에 전달한다.
*  
*  10) 해당 객체 이벤트를 처리할 객체를 찾아서 ,  규칙에 따라 적절한 메서드를 호출한다.
*   * 이벤트를 처리하는 객체를 " 리스너라고 부른다.
*   * 규칙 ? 각각의 이벤트마다 리스너가 반드시 구현해야할 메서드를 정의하고있다.
*   예) WindowEvent --> WindowListener(인터페이스)
*         이벤트를 처리하는 클래스는 반드시 그 규칙에 따라 작성해야 한다.
*         인터페이스를 구현해야 한다.
*         
*         
*         
*   이벤트 리스너란??
*   =>=>Event Source(이벤트를 발생시킨 위젯)와 Listener(이벤트를 처리하는 객체) 사이의 호출 규칙이다.
*   ==> 이벤트가 발생했을 때 해당 위젯을 그 이벤트에 맞는 리스너를 찾아서 메서드를 호출한다.
*   => 각 이벤트 마다 호출 규칙이 정해져 있다.
*   => 이벤트 - 리스너
*       windowEvent  - WindowListener(Interface)
*       MouseEvent - MouseListener(Interface)
*       KeyEvent - KeyListener(Interface)
*     
*     
*     
*     
*     실습 목표 해결
*     1) close 버튼을 눌렀을 때 발생되는 이벤트 : windowEvent
*     2) WindowEvent 를 처리할 때 호출하는 메서드 규칙 : WindowListener
*     3) 특히 close 버튼에 대해 호출하는 메서드 : windowClosing();
*     
*     
*     코딩작업
*     1) windowListener를 구현한 클래스를 만든다.
*     2) windowClosing() 메서드가 호출 될 때 JVM을 종료하는 코드를 넣는다
*     3) windowEvent를 발생시키는 Frame 객체에 리스너를 등록한다.
*     
*   
*/
public class Test3 extends Frame{
  
  private static final long serialVersionUID = 1L;
  class MyWindowListener implements WindowListener{

    @Override
    public void windowClosing(WindowEvent e) {    //close버튼을 누를때
      System.exit(0);
    }
    @Override
    public void windowActivated(WindowEvent e) {} //윈도우가 포커스를 가질때 

    
    @Override
    public void windowDeactivated(WindowEvent e) {}   //윈도우가 포커스를 잃을 때
    @Override
    public void windowClosed(WindowEvent e) {
      
    }    //윈도우를 끌때


    @Override
    public void windowDeiconified(WindowEvent e) {} //윈도우가 다시 원래크기로 복원 되었을 때

    @Override
    public void windowIconified(WindowEvent e) {} //윈도우가윈도우가 최소화 되었을 때

    @Override
    public void windowOpened(WindowEvent e) {}    //윈도우를 열 때
    
  }
  public Test3(String title){
    super(title);
    addWindowListener(new MyWindowListener());
   setTitle(title);
   setSize(400, 300);
   setVisible(true);
  }
  public static void main(String[] args) {
    new Test3("두번 째 윈도우");
    

  }
}
