package step16.ch03.ui;

import java.util.ArrayList;
import java.util.HashMap;

import step16.ch03.domain.User;

/**
 * UIObject 상속받기
 * => UIObject excute() method가 일반 메서드라면,
 *      다음과 같이 Sub Class에서 Overriding 하지 않아도 컴파일 할 때 문제되지 않는다.
 *   => 그러나 ,  이것은 이 클래스를 사용하는 MemberControl과의 암묵적인*/


/*
 * UIObject에 추상 Mehod Overriding하기
 * Overriding하지 않으면 컴파일 오류발생*/
public class MemberList implements UIObject {
  
  

  @Override
  public void execute(HashMap<String, Object> parameterMap) {
    int index = 0;
    ArrayList<User> users = (ArrayList<User>) parameterMap.get("users");
    for (User user : users) {
      System.out.printf("%d, %s, %s, %s\n", 
          index++, user.getName(), user.getEmail(), user.getTel());
    }
    
    
  }

}
