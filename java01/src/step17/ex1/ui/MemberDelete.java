package step17.ex1.ui;

import java.util.HashMap;
import java.util.Scanner;

//회원 삭제 화면을 다루는 클래스 : Boundary
public class MemberDelete implements UIObject {
@Override
public void execute(HashMap<String, Object> parameterMap) {
  
  String command = (String) parameterMap.get("command");
  switch (command) {
  case "confirm":
    confirm(parameterMap);
    break;
    
  case "deleteResult":
    deleteResult();
    break;

  }
}

    //다음 메서드처럼 내부에서만 사용되는 메서드라면  , private으로 접근을 제한하기 바란다.
    // method를 통하여 method호출 하는방법 -> 한방에 못가도록 private로 접근을 제한하여야 한다.
    // mehtod 라고해서 모두 개방해서는 안된다. 
    //외부에서 호출 해야할 method만 개방하는 것이 source의 유지보수에 좋다.

  private void deleteResult() {
    
    System.out.println("해당 회원을 삭제하였습니다.");
  System.out.println();
}

  private void confirm(HashMap<String, Object> parameterMap) {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("정말 삭제하시겠습니까?(y/n) ");
    String response = keyScan.nextLine();
    
    if (response.equals("y"))
      parameterMap.put("response", true);
    else {
      System.out.println("삭제를 취소하였습니다.");
      parameterMap.put("response",false);
    }
      
  }


}










