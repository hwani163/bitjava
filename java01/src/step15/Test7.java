package step15;

import java.util.HashMap;

/*
 *  사용자 정의 클래스 key로 사용하기
 *  같은 데이터에 대해 같은 hash값과 true(equals())를 리턴하도록
 *  hashCode()와 equals()를 Overriding한다.*/

public class Test7 {
  
  static class MemberPK{
    String id;

    public MemberPK(String id) {
      this.id = id;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
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
      MemberPK other = (MemberPK) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      return true;
    }
    
    
  }

  static class Member {
    String id;
    String password;
    String name;
    String email;
    String tel;

    public Member(String id, String password, String name, String email,
        String tel) {
      this.id = id;
      this.password = password;
      this.name = name;
      this.email = email;
      this.tel = tel;

    }

    @Override
    public String toString() {
      return "Member [id=" + id + ", password=" + password + ", name=" + name
          + ", email=" + email + ", tel=" + tel + "]";
    }

  }

  public static void main(String[] args) {

    Member m1 = new Member("hong", "1111", "홍길동", "hong@test.com",
        "010-010-0000");
    Member m2 = new Member("park", "1111", "박지성", "jspark@test.com",
        "010-010-0001");
    Member m3 = new Member("kim", "1111", "연아킴", "ynkim@test.com",
        "010-010-0002");
    
    
    MemberPK k1 = new MemberPK("hong");
    MemberPK k2 = new MemberPK("park");
    MemberPK k3 = new MemberPK("kim");

    HashMap map = new HashMap();
    
    map.put(k1, m1);
    map.put(k2, m2); 
    map.put(k3, m3);
    
    System.out.println(map.get(k1));
    System.out.println(map.get(k2));
    System.out.println(map.get(k3));
    
    MemberPK k1Copy = new MemberPK("hong");
    MemberPK k2Copy = new MemberPK("park");
    MemberPK k3Copy = new MemberPK("kim");
    
    System.out.println("============================="
        + "===================================");
    
    System.out.println(map.get(k1Copy));
    System.out.println(map.get(k2Copy));
    System.out.println(map.get(k3Copy));
    
    System.out.println("\nk1과 k1Copy hashCode() 비교");
    System.out.println(k1.hashCode());
    System.out.println(k1Copy.hashCode());
    
    
    /*같은 값을 갖는 키로 데이터를 꺼낼 수 있는 이유!!!!!!
     * 
     * hashCode()의 리턴값이 같고 , equals() 가 true를 리턴하기 때문이다.
     * */

    
    
  }
}
