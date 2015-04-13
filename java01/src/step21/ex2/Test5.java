package step21.ex2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/* 실습목표 : 로컬 익명 이너클래스를 사용하여 이벤트 리스너 구현하기요
 * => 익명 이너클래스는 인스턴스를 하나 ㅏㄲ에 만들 수 없다.
 *  인스턴스가 한개만 필요한 경우 익명 이너 클래스를 사용하라.
 *  
 *  로컬 익명 이너클래스 => 메서드안에 선언한 익명 클래스
 *  
*/
public class Test5 extends Frame{
  
  private static final long serialVersionUID = 1L;
  
  

  public Test5(String title){
    super(title);
    WindowListener listener = new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    addWindowListener(listener);
   setTitle(title);
   setSize(400, 300);
   setVisible(true);
  }
  public static void main(String[] args) {
    new Test5("두번 째 윈도우");
    

  }
}
