package step14.ex9;

public class TeatcherStack {
  TeacherItem cursor;
  int length;
  
  public void push(Object value) {
    TeacherItem newItem = new TeacherItem();
    newItem.value = value;
    newItem.next = cursor;
    cursor = newItem;
    length++;
  }
  
  public Object pop() {
    if (cursor == null) {
      return null;
    }
    
    Object value = cursor.value;
    cursor = cursor.next;
    length--;
    return value;
  }

  public int size() {
    return length;
  }
}
