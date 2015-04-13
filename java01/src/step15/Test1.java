package step15;

import java.util.ArrayList;

/**
 * Collection API
 *  - 데이터 목록을 다루는 클래스
 *  - List : 인덱스 기반으로 데이터를 저장하고 꺼낸다. , 데이터 중복 허용.
 *  - Set : 인덱스 기반으로 데이터 저장하고 꺼낸다. 데이터 중복 불가
 *             : 집합처럼 데이터를 다루기 때문에 중복이 허용되지 않는다.
 *             =>Hash값을 인덱스로 사용하기 때문에 , 넣은 순서로 꺼낼 수 없다.
 *  - Map : HashCode 기반으로 데이터를 저장하고 꺼낸다.
 * 
 *  ArrayList
 *  단순히 데이터 목록을 관리할 때 사용한다.
 *  속도가 빠름니다.*/

public class Test1 {
  public static void main(String[] args) {
    
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(100); //100 -> new Integer(100) : boxing
    list.add(90);
    list.add(80);
    list.add("임꺽정");
    list.add(100);
    list.add(100);
    list.add(90);

    
    System.out.println(list);
    
    list.remove(3);
    System.out.println(list);
    list.remove("임꺽정");
    System.out.println(list);
    list.add(2, "70707070");
//    remove에 Value를 주면 그 값을 갖는 객체를 찾아서 지운다.
//    단 , 첫번째로 일치하는 객체를 지운다.
    list.remove(new Integer(100));
    System.out.println(list);
  
  }

}
