package step16.ch09;


/*클래스는 왜! 다중 상속을 못하는가?
 * =>다중 상속의 문제점 : 같은 이름의 속성이나 메서드가 있 을때 무엇을 상속해야 하는가
 * */
public class Test1 {
  
  static class A{
    int a;
    public void m(){
      System.out.println("ㅎㅎㅎ");
    }
  }
  static class B{
    boolean a;
    public void m(){
      System.out.println("ㅋㅋㅋ");
    }
  }
  
  /*
  static classC extends A , B{
    int a 또는 boolean a 둘중 무엇을 상속받을 것인가.
    A의 m() or B의 m() 둘중 무엇을 상속받을 것인가?
  }
*/
  
  public static void main(String[] args) {

  }

}
