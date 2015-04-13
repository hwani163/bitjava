package step21.ex1;

import java.awt.Frame;

public class Pra2 extends Frame{

  public Pra2(String title){
    super(title);
    setTitle(title);
    setSize(400,300);
    setVisible(true);
  }
  
public static void main(String[] args) {
  new Pra2("하이루");
}
}
