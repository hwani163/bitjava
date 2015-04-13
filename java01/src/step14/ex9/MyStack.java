package step14.ex9;

import step14.ex9.Item;

public class MyStack {

  Item start;
  Item end;
  int length;
  int popcnt;

  public MyStack() {
  }

  public int size() {
    return length;
  }

  public void push(Object value) {

    Item pushItem = new Item(value);

    if (length == 0) {
      start = pushItem; //start는 처음 넣을때만 하면 되니깐 start를 pushItem지정해준다.
    }

    pushItem.previous = end;  //pushItem의 전값에 end를 넣는다 만약 처음 넣은거면 previous에 null들어간다.
    
    end = pushItem;  //그리고 pushItem이 end를 가리키게 한다.

    length++;

  }
  public Object pop() {
    if (length != 0) {
      Object returnValue = end.value;
      length--;
      end = end.previous;
      return returnValue;
    }
    return null;
  }

}
