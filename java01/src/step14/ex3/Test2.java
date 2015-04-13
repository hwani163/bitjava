package step14.ex3;

/*
 * 강사 이름 목록과 학생 이름 목록을 개별적으로 다루기!*/



public class Test2 {

  
    public static void main(String[] args) {      
      
      MyArrayList2 myArrayList1 = new MyArrayList2();
//      강사 이름 보관
      myArrayList1.add("홍길동");
      myArrayList1.add("임꺽정");
      myArrayList1.add("유관순");      
      myArrayList1.print();
      MyArrayList2 myArrayList2 = new MyArrayList2();
//      학생이름보관  
      myArrayList2.add("홍길동");
      myArrayList2.add("홍길동");
      myArrayList2.print();

    }

  

}
