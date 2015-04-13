package step17.ex1.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class MemberDao {
  ArrayList<User> users = new ArrayList<User>();
  int length = users.size();

  
  
//  DataOutputStream을 사용하여 사용자 정보를 바이너리 형식으로 출력한다.
  public void save(File file) throws IOException{
    DataOutputStream out = new DataOutputStream(
                                        new BufferedOutputStream(
                                            new FileOutputStream(file)));
    
    String csv =null;
    
//    사용자 정보를 출력하기전에 사용자 수를 먼저 파일에 write한다.
    out.writeInt(users.size());
    
//    ArrayList에 보관된 사용저 정보를 반복해서 출력한다.
    for(User user : users){
      out.writeUTF(user.getName());
      out.writeUTF(user.getEmail());
      out.writeUTF(user.getTel());
      out.writeUTF(user.getHomepage());
      out.writeUTF(user.getTwitter());
    }
    
    out.close();
    
  
  }
//DataInputStream을 사용하여 사용자 정보를 바이너리 형식으로 출력한다.
  public void load(File file) throws IOException{
    DataInputStream in = new DataInputStream(
                                    new BufferedInputStream(
                                        new FileInputStream(file)));
    
    //temp -> 양동이
    int len = in.readInt();
    User user =null;
  for (int i = 0; i < len; i++) {
    user = new User();
    user.setName(in.readUTF());
    user.setTel(in.readUTF());
    user.setHomepage(in.readUTF());
    user.setTwitter(in.readUTF());
    
    users.add(user);
    }
    
    in.close();
    

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
