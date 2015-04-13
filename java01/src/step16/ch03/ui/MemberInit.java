package step16.ch03.ui;

import java.util.HashMap;

//초기 화면을 다루는 클래스: Boundary
public class MemberInit implements UIObject {

  //아무것도 하는일이 없다고 해도 일관성을 위해 똑같이 해준다.
//  일관된 코딩을 위해 동일한 클래스를 상속 받게 한다.
  
  @Override
  public void execute(HashMap<String, Object> parameterMap) {
    System.out.println("회원 관리 시스템에 오신 걸 환영합니다.");
    }

}
