package step17.ex1.domain;

//  복합 자료형 정의
//  csv 문자열을 가지고 User instance 초기화 하는 생성자를 추가하였다.
//  csv 문자열 출력 메서드 추가 : User instance의 정보를 가지고 CSV 문자열을 생성.
public class User {
  protected int no;
  protected String name;
  protected String email;
  protected String tel;
  protected String homepage;
  protected String twitter;
  
  @Override
  public String toString() {
    return "User [no=" + no + ", name=" + name + ", email=" + email + ", tel="
        + tel + ", homepage=" + homepage + ", twitter=" + twitter + "]";
  }
  
  public String toCsv(){
    return name+","+email+","
        +tel+","+homepage+","+twitter;
  }

  public User() {}
  
  public User(int no, String name, String email, String tel,
      String homepage, String twitter) {
    this.no = no;
    this.name = name;
    this.email = email;
    this.tel = tel;
    this.homepage = homepage;
    this.twitter = twitter;
  }
  public User(String csv){
    String[] attributes = csv.split(","); //사용자 정보(csv)를 콤마로 구분한다.
    
    this.no = 0;
    this.name = attributes[0];
    this.email = attributes[1];
    this.tel = attributes[2];
    this.homepage = attributes[3];
    this.twitter = attributes[4];
    
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public String getTwitter() {
    return twitter;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }
  
  
      
}
