package step14.ex5;

/* 예외가 발생하는 부분에 다음 코드를 넣는다.
 * 
 * throw new Exception("오류정보")
 * 예외 정보를 던지는 메서드 선언부에 다음 코드를 넣는다.
 * public void
 * Throwable ->오류정보를*/


public class MyArrayList4 {
  Object[] pool = new Object[100];

  // 배열에서 저장할 위치를 가리키는 변수
  int length;

//  배열의 크기를 초과하여 입력하면 , -1을 Return한다. =>  즉 호출자에게 알린다.
// 오류 상황을 알리기위해 더이상 리턴 값을 사용할 필요가 없다.
//  오류 내용은 Throwable 객체에 담는다.
//  호출자에게 알리는 방법은 throw 명령을 사용하여 Throwable 객체를 던지는 것이다.
//  오류정보를 던지는 메서드는 어떤 오류를 던지는지 선언해야 한다.
//  강조! thorow는 오직 Throwable 객체만 던질 수 있다.
  void add(Object obj) throws Throwable {
    if (length >= pool.length) {
      throw new Throwable("오류정보");
    }
    pool[length++] = obj;
  }

  // 풀에 저장된 값을 제거한다. 보통 제거된 값을 리턴한다.
  Object remove(int index) throws Throwable {
    if (index>=pool.length) {
      throw new Throwable("공간을 초과하였다.");
    }
    if (index>=length) {
      throw new Throwable("존재하지 않는 값이다..");
    }
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
