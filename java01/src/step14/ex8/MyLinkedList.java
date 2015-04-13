package step14.ex8;
/**
 * 예외처리 !!확실히하자*/
// LinkedList 알고리즘에 따라 데이터 보관을 수행한다.
// => 데이터를 무한으로 넣을 수 있다.
// => 단 특정 인덱스에 있는 값을 꺼낼 때 속도가 느리다.
//    => 찾아가야 하기 때문에.
public class MyLinkedList {
  Item start; // 시작 Item 객체를 가리킬 참조 변수
  Item end; // 마지막 Item 객체를 가리킬 참조 변수. 항상 마지막은 빈 객체이다.
  int length; // 보관소에 저장된 Item의 개수 
  
  public MyLinkedList() {
    start = new Item();
    end = start;
  }
  
  public void add(Object value) {
    
    end.value = value;
    end.next = new Item();
    end = end.next;
    length++; // Item 추가하면 보관소의 크기를 한 개 증가시킨다.
  }
  
  public int size() {
    return length;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= length) 
      throw new InvalidIndexException("잘못된 index값 잆니다.");
    
    Item cursor = start; // LinkedList를 따라 갈 때 현재 Item을 가리키는 변수
    int count = 0;
    
    while (count < index) {
      cursor = cursor.next;
      count++;
    }
    
    return cursor.value;
  }
  
  public void insert(int index, Object value){
    if (index==length) {
      add(value);
      return;
    }
    
    if (index < 0 || index > length) {
      throw new InvalidIndexException("잘못된 index값 잆니다.");
      
    }
      
    
    Item cursor = start; // LinkedList를 따라 갈 때 현재 Item을 가리키는 변수
    int count = 0;
    Item insertItem = new Item();
    insertItem.value = value;
    length++;
    
    if (index==0) {
      insertItem.next = start;
      start = insertItem;
      return;
    }
    
    while (count < index-1) {
      cursor = cursor.next;
      count++;
    }
    
    insertItem.next = cursor.next;
    cursor.next = insertItem;
    

    
  }
  
  public Object remove(int index){
    if (index < 0 || index >= length) 
      throw new InvalidIndexException("인덱스 범위가 잘못되었어요");
    
    Item cursor = start; // LinkedList를 따라 갈 때 현재 Item을 가리키는 변수
    int count = 0;
    
    if (index==0) {
      start = start.next;
    }
    while (count < index-1) {
      cursor = cursor.next;
      count++;      
    }
    System.out.println("cursorValsue = "+cursor.value);
    cursor = cursor.next.next;
    
    
    
    
    return cursor.value;
  }
  
  public void set(int index, Object value){
    
    int count = 0;    
    if (index < 0 || index >= length) 
      throw new InvalidIndexException("인덱스 범위가 잘못되었어요");    

    Item cursor = start; // LinkedList를 따라 갈 때 현재 Item을 가리키는 변수
    
    while (count < index) {
      cursor = cursor.next;
      count++;
    }
    
    
    cursor.value = value;
    
    
  }
}












