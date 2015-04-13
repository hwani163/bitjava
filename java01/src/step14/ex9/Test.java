package step14.ex9;

public class Test {

  public static void main(String[] args) {

    
    MyStack stack = new MyStack();
    stack.push("홍길동");
//    System.out.println(stack.pop());
    stack.push("임꺽정");
    stack.push("유관순");
    stack.push("안중근");
    stack.push("윤봉길");
//    System.out.println(stack.pop());
//    System.out.println(stack.pop());
    stack.push("원석환");
//    System.out.println(stack.pop());
    Object value = null;
    while ((value=stack.pop()) != null){
      System.out.println(value);
    }
    
    
    
  }

}
