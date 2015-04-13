package step14.ex5;

// 오류를 처리하는 방법
// 
// 일을 시킨 메서드에서 작업을 하다가 오류가 발생했을 때,
// 대처법1: 즉시 실행을 멈춘다.
// 대처법2: 그냥 자기가 처리하고, 계속 실행한다.
// 대처법3: 호출자에게 알린다.
//
// 실습3: 오류 발생했을 때, 호출자에게 알린다.
public class Test4 {

  public static void main(String[] args) {
    try {
      
      MyArrayList3 array = new MyArrayList3();
      for (int i = 0; i < 101; i++) {
        array.add("홍길동"+i);
      }
    } catch (Throwable ex) {
      System.out.println("추가하다가 발생했음!!"+ex.getMessage());
    }
    
    try {
      MyArrayList4 array2 = new MyArrayList4();
      array2.add("홍기동");
      array2.add("김기동");
      array2.add("박기동");
      
      Object value = array2.remove(0);   
      value = array2.remove(0);
      value = array2.remove(0); 
      value = array2.remove(0);
      value = array2.remove(200);
      
    } catch (Throwable ex) {
      System.out.println("더하거나 지우다가 예외 발생!");
    }
    
    
  
    
    // 리턴 값으로 다양한 오류를 구분할 수 있어서 좋다.
    // 고민1: 실제 실행하려면 명령과 오류를 처리하는 명령어가 서로 섞여 있어서 
    //       코드를 읽기가 어렵다.
    // 고민2: 리턴 값으로 다양한 여러 오류를 전달하기에는 매우 복잡하다.
    //       => 메서드 호출 후, 오류의 상태를 조사하기에 직관적이지 않다.
    // 고민3: 단순한 예제에서는 호출자에게 보고하면 되지만,
    //       복잡한 시스템에서는 여런 단계의 호출을 거치는데, 
    //       맨 밑단에서 발생된 오류를 가장 윗단으로 전달하는 방법은?
    
    // 이런 오류 처리에 대한 고민을 해결하기 위해 등장한 문법 => 예외 처리 문법!
  }

}








