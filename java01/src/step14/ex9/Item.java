package step14.ex9;

//값을 보관하는 역할

public class Item {

  protected Object value; // 객체 값을저장
  protected Item previous; // 다음 Item의 주소저장

  
  public Item() {
  }

  public Item(Object value) {
    this.value = value;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public Item getNext() {
    return previous;
  }

  public void setNext(Item next) {
    this.previous = next;
  }

  @Override
  public String toString() {
    return "Item [value=" + value + "]";
  }

}
