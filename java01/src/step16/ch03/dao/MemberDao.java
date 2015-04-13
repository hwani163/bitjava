package step16.ch03.dao;

import java.util.ArrayList;

import step16.ch03.domain.User;

//회원 데이터를 다루는 클래스 : Entity
public class MemberDao {
  ArrayList<User> users = new ArrayList<User>();
  int length = users.size();

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
