package step14.ex2;
/*
 * 배열을 사용하여 여러 값을 보관한다.
 * ex1.Test에서 값 저장과 관련된 메서드를 이 클래스로 가져온다.*/
public class MyArrayList {static Object[] pool = new Object[100];

// 배열에서 저장할 위치를 가리키는 변수
static int length;

static void add(Object obj) {
  pool[length++] = obj;
}

// 풀에 저장된 값을 제거한다. 보통 제거된 값을 리턴한다.
static Object remove(int index) {
  Object value = pool[index];
  length--;
  for (int i = index; i < length; i++) {
    pool[i] = pool[i + 1];
  }
  return value;
}

static void insert(int index, Object value) {
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
static void set(int index, Object value) {
  pool[index] = value;
}

// 풀에 저장된 값을 꺼내기
static Object get(int index) {
  return pool[index];
}

static void print() {
  for (int i = 0; i < length; i++) {
    System.out.print(pool[i] + ",");
  }
  System.out.println();
}
  

}
