package step15;

import java.util.HashMap;

/*
 *  사용자 정의 클래스 key로 사용하기
 *  =>비록 데이터가 같다고 하더라도 ,Hash값이 다르면 다른 key로 간주한다.
 *  => 개선코드 : Test7을 참조하라.*/

public class Test6 {
  
  static class MemberPK{
    String id;

    public MemberPK(String id) {
      this.id = id;
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
    
    System.out.println(map.get(k1Copy));
    System.out.println(map.get(k2Copy));
    System.out.println(map.get(k3Copy));
    
    /*같은 값을 갖는 키로 데이터를 꺼낼 수 없는 이유!!!!!!
     * 
     * Key의 Hash값이 다르기 때문이다!!!!!
     * =>Map은 값을 저장할 때 ,  키의 Hash값을 인덱스로 사용하여 저장한다.
     *     따라서 , 값을 꺼낼 때는 같은 해시 값을 사용해야 한다.*/

    
    
  }
}
