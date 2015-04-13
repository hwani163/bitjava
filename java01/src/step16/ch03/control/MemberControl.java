package step16.ch03.control;

import java.util.ArrayList;
import java.util.HashMap;

import step16.ch03.dao.MemberDao;
import step16.ch03.domain.User;
import step16.ch03.ui.MemberAdd;
import step16.ch03.ui.MemberChange;
import step16.ch03.ui.MemberDelete;
import step16.ch03.ui.MemberDetail;
import step16.ch03.ui.MemberInit;
import step16.ch03.ui.MemberList;

//회원 CRUD 작업을 제어하는 클래스: Control
public class MemberControl {
  MemberDao memberDao;
  MemberInit memberInit;
  MemberAdd memberAdd;
  MemberList memberList;
  MemberDetail memberDetail;
  MemberDelete memberDelete;
  MemberChange memberChange;
  
  public MemberControl() {
    memberDao = new MemberDao();
    memberInit = new MemberInit();
    memberAdd = new MemberAdd();
    memberList = new MemberList();
    memberDetail = new MemberDetail();
    memberDelete = new MemberDelete();
    memberChange = new MemberChange();
  }
  
  public void init() {
    memberInit.execute(null);   
  }

  public void add() {
    HashMap<String, Object> box = new HashMap<String, Object>();
//    빈 바구니를 주며 , 등록할 사용자 정보를을 요청한다.
    memberAdd.execute(box); //사용자 정보를 빈 바구니에 담는다.
    
    User user = (User) box.get("user");
//    바구니에 "user"라는 키로 저장된 담긴 사용자 정보를 꺼낸다.
    if (user != null) {
      memberDao.insert(user); //DAO에 있는 user에 저장해주어야 한다.
    }
    
  }

  public void list() {
    HashMap<String, Object> box = new HashMap<String, Object>();
    ArrayList<User> users = memberDao.selectList();
    box.put("users", users);
    
//    안타깝게도 MemberList의 execute() 메서드를 Overriding하지 않았따.
//    그래서 다음은 UIObject에서 상속 받은 method를 호출 하는 것이다.
//    당연히 아무일도 하지 않을 것이다.
//    
//    이렇게 상속받은 메서드를 반드시 Overrinding 하여야 하는데,
//    MemberList처럼 개발자가 실수로 Overriding하지 않는 경우가 있다.
//    그래도 컴파일 에는 문제가 없다.
//    단지 실행에서 원하는 결과가 동작이 되지 않을뿐......
    
//    => SubClass가 SuperClass의 특정 method를 반드시 Overriding하도록 강제시키는것을
//    추상Method라고 한다. Abastract Method
//    어떤 methd는 이름이나 Parameter , Return 타입을 통일시키기 위해 Super클래스에서 정의는 하지만 , 
//    실제적인 구현은 Sub Class에서 해야 할 경우가 있다.
//    이런 경우 SuperClass에서 Method를 구현해봐야 의미가 없다.
//    Sub 클래스에서 재정의 할 것이기 때문이다.
//    => 또는 SuperClass 의 특정 method를 Sub Class에서 반드시 
//    Overrinding 하도록 강제해야 할 때가 있따.
//    => 추상 메서드를 구현 하지 않으면 SubClass는 AbstarctClass 가 되어야 한다.
//    인스턴스를 생성하여 사용할 수 없다.
//    
    
    memberList.execute(box);
  }

  public void detail(int no) {
    HashMap<String, Object> box = new HashMap<String, Object>();
    User user = memberDao.select(no);
    
    box.put("user", user);
    memberDetail.execute(box);
  }

  public void delete(int no) {
    HashMap<String, Object> box = new HashMap<String, Object>();
    box.put("command", "confirm");    //내부적으로 confirm method를 호출할 것이다.
    
    boolean response = (Boolean) box.get("response");   //.get으로 리턴하는 것은 주소이기때문에 Wrapper로 지정해주어야함
    
    if (response == true) {
      memberDao.delete(no);
      box.put("command", "deleteResult");
      memberDelete.execute(box);
    }
    
  }

  public void change(int no) {
    
    HashMap<String, Object> box = new HashMap<String, Object>();
    User user = memberDao.select(no);
    
    box.put("user", user);    
    memberChange.execute(box);
    User changedUser = (User)box.get("changedUser");
    
    
    if (changedUser != null) {
      memberDao.update(no, changedUser);
    }
  }

}














