package step14.ex8;

//값을 보관하는 역할

public class Item {

  protected Object value; // 객체 값을저장
  protected Item next; // 다음 Item의 주소저장

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
    return next;
  }

  public void setNext(Item next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "Item [value=" + value + "]";
  }

}
