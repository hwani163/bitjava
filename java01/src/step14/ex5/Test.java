package step14.ex5;

public class Test {

/**  
  오류를 처리하는 방법
  일을 시킨 메서드에서 작업을 하다가 오류가 발생 했을때 어떻게 할 것인가?
  대처법 1: 즉시 실행을 멈춘다.
  대처법 2: 그냥 자기가 처리한다.
  대처법 3: 호출자에게 알린다.
  

 */
//  실습 1 : 오류발생했을때 실행을 멈추기!
  public static void main(String[] args)  {
    MyArrayList array = new MyArrayList();
    array.add("홍길동");
    array.add("심청");
    array.add("견우");
    
//    다음과 같이 오류상황을 유도
//    =>결과 : 즉시 실행을 멈춘다.!! Java에서는 간단히 오류 내용을 출력한다.
    array.remove(1000);
    array.print();
    
//    고민!!
//    간단한 프로그램인 경우 오류가 발생 했을때 프로그램을 종료하더라도 크게
//    문제가 되지 않는다.
//    그러나 , Naver , Daum 처럼 24일 365일동안 멈추지 않고 실행되어야 하는 경우
//    오류가 발생했다고 해서 실행을 멈춘다면 엄청난 문제가 발생될 수 있다.
    
//    오류가 발생되더라도 실행을 멈추지 않는 방법은?
    
//    
    
    

  }

}