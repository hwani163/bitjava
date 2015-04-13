package step14.exa;

import step14.exa.Item;

public class MyQueue {
  
//  큐 알고리즘
//  first In First Out
//  첫번째로 추가된 값이 첫 번째로 나온다.
  Item start;
  Item end;
  int length;
  
 
//  맨 마지막에 추가한다.
  public void put(Object value){
    Item putItem = new Item(value);

    if (length == 0) {
      start = putItem;
      end = putItem;
      putItem.next=null;
    }
    
    end.next = putItem;
    putItem.next=null;
    end = putItem;

    length++;
    
  }
  
  
//  무조건 맨 첫 번 째 값을 꺼낸다.
  public Object get(){
    
    if (length != 0) {
      
      Object firstValue =start.value;
      start = start.next;
      length--;
      
      return firstValue;
    }
       
    return null;
  }
  
  public int size(){
    return length;
  }
  
  

}
