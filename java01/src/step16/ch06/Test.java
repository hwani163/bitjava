package step16.ch06;

/* 추상 클래스 활용: 3단계
 * 일반화 작업을 통해 뽑은 수퍼 클래스를 추상 클래스로 만들기
 * 어차피 서브 클래스에서 재정의 할 메서드는 추상 메서드로 만들기
 */

public class Test {

  public static void main(String[] args) {
    
//    어처구니가 없게시리 , Car클래스를 직접 사용하려고 한다.
//    Car클래스는 단지 서브클래스의 공통 속성이나 기능을 상속해주는 용도임에도 불구하고.
//    다음 명령이 불가능 하게 만들라! => 추상 클래스로 선언하라
    
//    Car car0 = new Car();
    Tico car1 = new Tico();
    car1.setModel("티코2015");
    car1.setCc(800);
    car1.setCapacity(5);
    
    car1.accelerate();
    car1.accelerate();
    car1.accelerate();
    car1.accelerate();
    car1.accelerate();
    
    car1.reduce();
    car1.reduce();
    car1.reduce();
    car1.reduce();
    car1.reduce();
    
    VolvoTruck car2 = new VolvoTruck();
    car2.setModel("volvo FH");
    car2.setHp(540);
    car2.setWeight(0);
    
    
    car2.accelerate();
    car2.accelerate();
    car2.accelerate();
    car2.stop();
    
    
    car2.load(600000);
    car2.accelerate();
    car2.accelerate();
    car2.accelerate();
    
    car2.reduce();
    car2.reduce();
    car2.reduce();
  }

}
