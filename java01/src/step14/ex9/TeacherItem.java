package step14.ex9;

// 값을 보관하는 역할
public class TeacherItem {
  protected Object value; // 값 객체의 주소 저장
  protected TeacherItem next; // 다음 아이템 객체의 주소 저장 

  @Override
  public String toString() {
    return "Item [value=" + value + "]";
  }

  public TeacherItem() {}
  
  public TeacherItem(Object value) {
    this.value = value;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public TeacherItem getNext() {
    return next;
  }

  public void setNext(TeacherItem next) {
    this.next = next;
  }
  
  
}
