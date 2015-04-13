package step14.ex7;

// /*예외처리가 사용된 MyArrayList사용하기*/
public class Test {

  public static void main(String[] args) {
    
    MyArrayList arr = new MyArrayList();
    try {
      arr.add("홍길동");
      arr.add("임꺽정");
      arr.add("유관순");
      arr.print();
      arr.insert(1, "안중근");
      arr.print();
      arr.remove(3);
      arr.print();
      System.out.println(arr.get(2));
      
      arr.set(2, "워싱턴");
      
      System.out.println(arr.get(2));
      arr.print();
    } catch (PoolOverFlowException e) {
      System.out.println("용량초과");
    } catch (InvalidIndexException e) {
      System.out.println("인덱스 무효!");
    }
  }

}








