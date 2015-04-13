package step14.ex5;

/* 오류가 발생 했을때 리턴값을 통해 호출자에게 오류의 상황을 알린다.*/
public class MyArrayList3 {
  Object[] pool = new Object[100];

  // 배열에서 저장할 위치를 가리키는 변수
  int length;

//  배열의 크기를 초과하여 입력하면 , -1을 Return한다. =>  즉 호출자에게 알린다.
//  add에서 오류가 발생하면 리턴 값으로 알려준다ㅣ.
//  그러면 개발자가 그에 대한 대응책을 아래와 같이 마련할 수 있다.
  int add(Object obj) {
    if (length >= pool.length) {
      System.out.println("사이즈 초과입니다.");
      return -1;
    }
    pool[length++] = obj;
    return length;
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
    // 방법: 끝에서부터 삽입하려는 방까지 다음 칸으로 값을 이동한 후,
    // 현재 방에 값을 넣는다.
    // 1) 마지막 값의 방부터 index로 지정한 방까지의 값을 한 칸 앞으로 이동한다.
    for (int i = length - 1; i >= index; i--) {
      pool[i + 1] = pool[i];
    }
    // 2) index가 지정한 방에 값을 넣는다.
    pool[index] = value;

    // 3) length를 증가시켜서 빈 방을 가리키게 한다.
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
