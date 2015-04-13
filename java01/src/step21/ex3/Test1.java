package step21.ex3;
/*
 * 실습 목표 : 이너클래스를 이용하여 상수 값을 정의한 작은 클래스 관리
 *
 *
 *이렇게 상수 값을 정의 하는 경우는 , 패키지 멤버 클래스로 만들기 보다는
 *다음 클래스와 같이 topLevel InnerClass로 만들어서 쓰는 것이
 *소스 코드 관리에 좋다.*/
public class Test1 {
  int 분류 = Category.beauty.RING;
  int 분류2 =Category.movie.ACTION;
  int 분류3 = Category.electronic.COMPUTER;
}
