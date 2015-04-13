package step21.ex2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/* 실습목표 : 실무에서 많이 쓰는 방법
 *  
*/
public class Test6 extends Frame{
  
  private static final long serialVersionUID = 1L;
  
  

  public Test6(String title){
    super(title);
     
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
   setTitle(title);
   setSize(400, 300);
   setVisible(true);
  }
  public static void main(String[] args) {
    new Test6("두번 째 윈도우");
    

  }
}
