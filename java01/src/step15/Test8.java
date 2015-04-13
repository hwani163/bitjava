package step15;

import java.util.ArrayList;

/**
 특정 타입의 객체만 저장 하고 싶을 때
   -  Collection 객체를 선언 할 때 저장할 Type을 지정한다. -> Generic*/

public class Test8 {
  public static void main(String[] args) {
    
//    Generic사용 전
//      - 어떤 Type의 객체를 저장할지 지정하지 않으면 , 다음과 같이 마음대로 저장 할 수 있다.
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(100); //100 -> new Integer(100) : boxing
    list.add(90);
    list.add(80);
    list.add("임꺽정");
    list.add(100);
    list.add(100);
    list.add(90);

    
//    제네릭 사용후
//    특정 타입의 객체만 저장할 수 있도록 제한 할 수 있따.
//    개발자가 다른 타입의 객체를 저장하는 실수를 방지한다.
    ArrayList<String> list2 = new ArrayList<String>();
    list2.add("홍길동");
//    list2.add(100); //지정된 타입이 아닌 다른타입의 객체를 저장하려고하면 컴파일단계에서 오류가 발생한다.
    list2.add("임꺽정");
    list2.add(new String("임꺽정"));
    
    /*
     * 제네릭 사용
     * => 제네릭을 지원하는 클래스에 대해서만 사용할 수 있다.
     * --->API문서에서 클래스 이름뒤에 <E> 의 형태로 선언이 되어있다.*/
    
  
  }

}
