package step14.ex6;

import step14.ex6.Test6.EmptyValueException;
import step14.ex6.Test6.InvalidIndexException;

/**
 * 
 * 사용자 정의 예외 : 부모 타입의 예외와 자식 타입의 예외를 동시에 catch하는 방법
 */

public class Test8 {

  static class EmptyValueException extends Exception {
  }

  static class InvalidIndexException extends Exception {
  }

  static String[] names = new String[10];
  static int length;

  static void add(String name) throws Exception {
    if (length >= names.length) {
      throw new Exception("배열의 크기를 초과하였습니다.");

    }
    names[length++] = name;
  }

  // 사용자 정의 예외 도입 후
  // - 굳이 어떤 예외 상황인지 메시지를 남길 필요가 없다.
  // - 클래스 이름이 어떤 예외 상황인지 나타내기 때문이다.
  static void remove(int index)
  /* throws Exception */// 이렇게 던지는 예외 타입의 상위 클래스를 지정해도 된다.
      throws EmptyValueException, InvalidIndexException
  // 구체적으로 각각의 예외를 지정해도 된다.
  {
    // 인덱스가 배열의 크기 범위 안에서 가리키지만, 값이 없는 방을 가리킨다.
    if (index >= length && index < names.length)
      throw new EmptyValueException(); // 빈방 오류

    // 인덱스가 배열의 크기를 벗어난다면,
    if (index >= names.length || index < 0)
      throw new InvalidIndexException(); // 무효한 인덱스 오류

    length--;
    for (int i = index; i < length; i++)
      names[i] = names[i + 1];

  }

  static void print() {
    for (int i = 0; i < length; i++)
      System.out.print(names[i] + ",");
    System.out.println();
  }

  // 예외를 캐치할 때 다형적 변수 사용하기
  public static void main(String[] args) {

    try {
      add("홍길동");
      add("임꺽정");
      add("유관순");
      add("안중근");
      add("윤봉길");
      print();
      remove(2);
      print();
      remove(3);
      print();
      // 값이 들어있지 않은 인덱스 가리키기
      remove(3);
      // 무효한 인덱스를 지정하는 경우
      // remove(-100);
//      예외를 캐치할 때 부모 클래스 변수를 가지고 캐치하게 되면
//      그 부모의 자식 클래스 예외까지 캐치할 수 있기 때문에
//      자식 클래스 예외를 따로 캐치할 수 없다.
//      ==>해결책 : 부모 예외 캐치를 자식 아래로 옮겨라
      
      
    } catch (EmptyValueException e1) {
      System.out.println("빈방을 가리키고 있네요.");
    } catch (InvalidIndexException e2) {
      System.out.println("무효한 인덱스입니다.");
    } catch (Exception e1) {
      System.out.println("빈방을 가리키고 있거나 무효한 인덱스 이네요.");
    }
  }
}
