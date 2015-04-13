package step15;

import java.util.HashSet;
import java.util.Iterator;


/**
 * Address클래스 변경
 * 같은 데이터를 갖는 경우 ,  같은 해시값을 리턴하도록 변경한다.
 * 같은 데이터를 갖는 경우  , equals()의 리턴 값이 true가 되도록 한다.
 * 
 * HashSet에 같은 값을 갖는 인스턴스에 대해 중복 저장되게 하지 않으려면
 * HashCode()와 equals()를 Overriding하여야 한다.
 * 둘중 하나만 해서는 안된다.*/
public class Test4 {
  
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

    
    
    
@Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((tel == null) ? 0 : tel.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Address other = (Address) obj;
      if (email == null) {
        if (other.email != null)
          return false;
      } else if (!email.equals(other.email))
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      if (tel == null) {
        if (other.tel != null)
          return false;
      } else if (!tel.equals(other.tel))
        return false;
      return true;
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


    
//    iterator 는 사용후 되감을 수 없다 따라서 출력 하려면 다시 얻어야 한다.
    iterator = hs.iterator();
    while(iterator.hasNext()){
     System.out.println(iterator.next());
    }
    
    /*
     * 
     * HashSet에 데이터 보관!!!
     * => 두 인스턴스의 HashCode() 리턴값이 같고 , equals()의 리턴 값이 true이면 , 
     *      같은 데이터로 간주하여 중복 저장하지 않는다.
     *
     */

  }

}
