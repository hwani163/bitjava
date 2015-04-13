package step21.ex1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/* 실습목표 : 이벤트 리스너를 좀더 쉽게 만들기
 * 인터페이스를 미리 구현한 추상클래스의 도움을 받는다.
 * 즉! WindowListener를 구현 하려면 해당 인터페이스에 모든 메서드를 구현해야 한다 ->
 * WindowaAdapt의 도움을 받으면 특정 메서드만 Overriding할 수 있따.
*/
public class Test4 extends Frame{
  
  private static final long serialVersionUID = 1L;
  
  //이 클래스를 상속 받으면 필요한 메서드만 오버라이딩 할수 있어서 편하다.
  class MyWindowListener extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  }
  public Test4(String title){
    super(title);
    addWindowListener(new MyWindowListener());
   setTitle(title);
   setSize(400, 300);
   setVisible(true);
  }
  public static void main(String[] args) {
    new Test4("두번 째 윈도우");
    

  }
}
