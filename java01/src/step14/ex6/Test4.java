package step14.ex6;

/**
 * 예외 발생했을 때 처리하는 방법
 * 1) try .... catch 로 내부에서 처리하기
 * 2) 상위 호출자에게 전달하기
 * 3)내부에서 일단 처리하고 상위 호출자에게 전달하기*/
public class Test4 {
 
  private static void problem() {
    // TODO Auto-generated method stub
    
  }
  
  static void m1(){
    try {
      problem();  //변기에 똥 묻었으
    } catch (Exception e) {
      System.out.println("적절하게 예외를 처리한다.");
    }
  }
  

  public static void main(String[] args) {
    
  }

}
