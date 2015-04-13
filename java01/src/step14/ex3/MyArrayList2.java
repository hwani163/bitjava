package step14.ex3;

 /* 데이터 목록응ㄹ 개별로 관리하기위해 클래스 변수를 인스턴스 변수로 전환한다.*/
public class MyArrayList2 {
   Object[] pool = new Object[100];

// 배열에서 저장할 위치를 가리키는 변수
 int length;

 void add(Object obj) {
  pool[length++] = obj;
}

// 풀에 저장된 값을 제거한다. 보통 제거된 값을 리턴한다.
 Object remove(int index) {
  Object value = pool[index];
  length--;
  for (int i = index; i < length; i++) {
    pool[i] = pool[i + 1];
  }
  return value;
}

 void insert(int index, Object value) {
  //방법: 끝에서부터 삽입하려는 방까지 다음 칸으로 값을 이동한 후, 
  //    현재 방에 값을 넣는다.
  //1) 마지막 값의 방부터 index로 지정한 방까지의 값을 한 칸 앞으로 이동한다.
  for (int i = length - 1; i >= index; i--) {
    pool[i + 1] = pool[i];
  }
  //2) index가 지정한 방에 값을 넣는다.
  pool[index] = value;
  
  //3) length를 증가시켜서 빈 방을 가리키게 한다.
  length++;
}

// 기존에 저장된 값을 변경 
 void set(int index, Object value) {
  pool[index] = value;
}

// 풀에 저장된 값을 꺼내기
 Object get(int index) {
  return pool[index];
}

 void print() {
  for (int i = 0; i < length; i++) {
    System.out.print(pool[i] + ",");
  }
  System.out.println();
}
  

}
