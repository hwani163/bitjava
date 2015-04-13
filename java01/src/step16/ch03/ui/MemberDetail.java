package step16.ch03.ui;
import java.util.HashMap;
import step16.ch03.domain.User;

//회원 상세 정보 화면을 다루는 클래스 : Boundary
public class MemberDetail implements UIObject {
  
 @Override
  public void execute(HashMap<String, Object> parameterMap) {
   User user = (User) parameterMap.get("user");
   
   System.out.printf("이름: %s\n", user.getName());
   System.out.printf("이메일: %s\n", user.getEmail());
   System.out.printf("전화: %s\n", user.getTel());
   System.out.printf("홈페이지: %s\n", user.getHomepage());
   System.out.printf("트위터: %s\n", user.getTwitter());
   System.out.println();
  } 
  

}
