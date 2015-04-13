package step14.ex8;


/**
 * LinkedList 알고리즘 구현하기
 * 왜 배열을 사용하지 않고 LinkedList라는 알고리즘을 사용하는가?
 * 배열은 한번 크기를 정하면 바꿀 수 없다.
 * => LinkedList는 저장소의 크기를 바꿀 수 있다.
 * 원리
 * 
 * 열차의 객차를 추가하거나 제거하는 방법
 * */
public class Test {

  public static void main(String[] args)  {
    MyLinkedList ll = new MyLinkedList();
    
      ll.add("홍길똥");
      ll.add("100");   
      ll.add("임꺾쩡");    
      ll.add("100");    
      ll.add("ddd");
      ll.set(1, "hi");
//      ll.insert(-1, 222);

    
    System.out.println(ll.get(0)+" "+ll.get(1)+" "+ll.get(2)+" "+ll.get(3)+" "+ll.get(4));
    
    
    
//     배열 vs LinkedList
//    -값 입력 : LinkedList는 무한으로 값을 넣을 수 있다. 메모리를 효율적으로 관리.
//    값입력 : LinkedLIst는 무한으로 값을 넣을 수 있다. 메모리를 효율적으로 관리.
//     - 조회 : 배열이 훨씬 빠르다. LinkedList는 매번 조회할 때 마다 처음부터 뒤져야 한다.
    
  }

}
