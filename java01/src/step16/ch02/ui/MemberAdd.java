package step16.ch02.ui;

import java.util.HashMap;
import java.util.Scanner;

import step16.ch02.domain.User;

//UIObject 를 상속받는다.
public class MemberAdd extends UIObject {

  
//  MemberControl 이 호출할 execute()를 Overriding하였다.
  @Override
  public void execute(HashMap<String, Object> parameterMap) {

    Scanner keyScan = new Scanner(System.in);

    User user = new User();

    System.out.print("이름: ");
    user.setName(keyScan.nextLine());
    System.out.print("이메일: ");
    user.setEmail(keyScan.nextLine());
    System.out.print("전화: ");
    user.setTel(keyScan.nextLine());
    System.out.print("홈페이지: ");
    user.setHomepage(keyScan.nextLine());
    System.out.print("트위터: ");
    user.setTwitter(keyScan.nextLine());

    // 6) 저장 여부를 묻는다.
    System.out.println("저장하시겠습니까?(y/n)");
    String response = keyScan.nextLine();

    if (response.equals("y"))
      parameterMap.put("user", user);

  }

}
