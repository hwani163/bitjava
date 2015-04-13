package step17.ex2;


/*실습 목표 : 재귀호출 집중 분석
 * 재귀 호출
 *  - 메서드 안에서 다시 자기를 호출 하는 것!
 *   Stack 메모리와 함께 고민하면 이해가 빠르다.
 *   자신을 호출한다고 생각하지 말고 또다른 메서드를 호출 한다고 생각하라!
 *    - 호출 될 때마다 Stack메모리가 증가한다 그래서 Stack메모리가 부족하게되면
 *    Stack Over flow Error발생
 *    수학공식을  Method로 만들때 유용하다*/
public class Test6 {

  
//  1+2+3+4+5+6+....n
  
  static int sigma(int n){
    if(n==1){
      return 1;
      }
    return n+sigma(n-1);
  }
  public static void main(String[] args) {
    
    System.out.println(sigma(100));

  }

}
