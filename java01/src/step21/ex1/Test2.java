package step21.ex1;

import java.awt.Frame;

/*
 * 윈도우 만들기
 */

public class Test2 extends Frame{
  
  private static final long serialVersionUID = 1L;
  public Test2(String title){
    super(title);
    
   setTitle(title);
   setSize(400, 300);
   setVisible(true);
  }
  public static void main(String[] args) {
    new Test2("두번 째 윈도우");
    

  }
}
