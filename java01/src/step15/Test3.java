package step15;

import java.util.HashSet;
import java.util.Iterator;


/**
 * HashSet 객체의 데이터 관리 방식
 * */
public class Test3 {
  
  static class Address{
    String name;
    String tel;
    String email;
    
    public Address(String name , String tel , String email){
      this.name = name;
      this.tel = tel;
      this.email = email;
    }

    @Override
    public String toString() {
      return "Address [name=" + name + ", tel=" + tel + ", email=" + email
          + "]";
    }
    
  }
  
  public static void main(String[] args) {
    
    Address a1 = new Address("길동", "010-010-0101", "kildong@naver.com");
    Address a2 = new Address("꺽정이", "010-010-0101", "kildong@naver.com");
    Address a3 = new Address("길동", "010-010-0101", "kildong@naver.com");
    
    HashSet hs = new HashSet();
    
    hs.add(a1);
    hs.add(a2);
    hs.add(a3);
    hs.add(a2);   //이미 같은 주소가 Set에 들어 있다. 중복 불가!
    hs.add(a1);   //이미 같은 주소가 Set에 들어 있다. 중복 불가!
    
    
//    hashSet은 값을 직접 꺼낼수 없고 => 꺼내주는 자으 ㅣ도움을 받아야 한다.
    Iterator iterator = hs.iterator();
    
    while(iterator.hasNext()){
     System.out.println(iterator.next());
   }
    
    System.out.println("-------------------------------------------------------------------------------");
    hs.add(new String("유관순"));
    hs.add(new String("임꺽정"));
    hs.add(new String("임꺽정"));
    
//    왜 String은 주소가 다른데도 
//    임꺽정은 서로 다른 인스턴스인데 중복이 안됨
//    왜그럴까?
//    데이터가 같다고 저장 안되는 것은 아니다. 왜냐하면 위에 Address는 주소만 달라도 중복이 안된다..
//    HashCode가 같기 때문에 중복 저장이 안된다.
//    즉 StringClass는  같은 값을 가지면 같은 HashCode 를 가지도록
//    HashCode 메서드를 Overriding 한셈이다.
    
//    추론!
//    만약 Address클래스도 같은 데이터에 대해 같은 HashCode 값을 리턴하도록 만든다면
//    중복 저장되는 일이 없을 것이다.!!!!!!
//    Test4에서 확인하자

    
//    iterator 는 사용후 되감을 수 없다 따라서 출력 하려면 다시 얻어야 한다.
    iterator = hs.iterator();
    while(iterator.hasNext()){
     System.out.println(iterator.next());
    }

  }

}
