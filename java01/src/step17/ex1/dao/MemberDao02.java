package step17.ex1.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import step17.ex1.domain.User;


/*
 * File 데이터 저장과 읽기 관련 메서드 추가
 * =>UserInstance를 가지고 CSV 문자열을 만드는 코드를 User클래스에 둔다!
 * => Csv 문자열을 가지고 User인스턴스를 만드는 코드를 User클래스에 둔다.
 *    => 코드개선 : 
*    => MemberDao의 코드를 간결하게 유지한다.
*    => User정보를 다루는 코드는 User 클래스에 있는 것이 바람지갛다. 유지보수가 편리한다.
*/
public class MemberDao02 {
  ArrayList<User> users = new ArrayList<User>();
  int length = users.size();

  //ArrayList에 보관된 정보를 File로 출력한다.
//  => 파일 저장과 관련된 오류는 호출자에게 알려야 한다.
  public void save(File file) throws IOException{
    //파일이 없으면 생성하고  , 해당File 이 있으면 기존파일을 지우고 새로만든다.
    FileWriter out = new FileWriter(file);
    
    String csv =null;
    
    for(User user : users){
     out.write(user.toCsv()+"\n");
    }
    
    out.close();
    
  
  }
//  File에 저장된 데이터를 읽어, ArrayList에 보관한다.
  public void load(File file) throws IOException{
    StringBuffer buf = new StringBuffer();  //MutableObject 변경할수 있는 객체
    FileReader in = new FileReader(file);
    
    //temp -> 양동이
    char[] temp = new char[1024];
    int leng=0;
    
    
    while((leng = in.read(temp))!=-1){
    buf.append(temp, 0, leng);
    }
    
    in.close();
//    System.out.println(buf);  
    //buf : members.csv 파일 전체 내용이 들어있음
    
    
    String data = buf.toString();
    String[] userList = data.split("\n");
    
    String[] attributes =null;
    User loadUser=null;
    
    for (String csvUserInfo : userList) {  //한 줄의 사용자 정보(csv)를 가져온다.
      users.add(new User(csvUserInfo));  //csv를 파라메터로 받는 생성자를이용하여 users에 추가시킨다.
//      User 인스턴스를 ArrayList(Dao)에 저장한다.
    }

  }
  
  public void insert(final User user) {
    users.add(user);
    
  }

  public ArrayList<User> selectList() {
    return users;
  }

  public User select(int no) {
    return users.get(no);
  }

  public void delete(int no) {
    users.remove(no);
  }

  public void update(int no, User changedUser) {
    users.add(no, changedUser);
  }

}
