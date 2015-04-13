package step14.ex4;

/*
 * 다양한 자료형을 저장하기!
 * Auto Boxing 개념 이해하기
 * =>Reference타입이 Object이기 때문에 어떤 자바 객체라도 저장할 수 있다.*/


/**
 * 원시타입 변수와 랩퍼타입 레퍼런스 사이의 자동 변환기법!(Auto Boxing)*/
public class Test {

  
    public static void main(String[] args) {      
      
      MyArrayList array = new MyArrayList();
      
      array.add("홍길동");
      array.add(new Integer(30));
      array.add("임꺽정");
      array.add(new Integer(20));
      array.add("둘  리");
      array.add(new Integer(40));
      
      
//      엥?
      array.add("장길산");
      array.add(100);   //어떻게 int의 값이 Object 레퍼런스 변수에 저장될 수 있는가?
      // 100 이라는 값이 저장되는 것이 아니라.
//      100이라는 값을 갖고있는 인스턴스의 주소가 저장되는 것이다.
//      아니 , 개발자가 인스턴스를 만들라고 명령하지도 않았는데?
//      =>자바 컴파일러가 해당 문구를 인스턴스 생성하는 문구로 자동변경한다.
      
      
//      int 랩퍼 클래스(int 자료형의 값을 다루는 클래스)의 일반적인 사용 예
      int a = 10;
      Integer obj1 = new Integer(10);
      Integer obj2 = new Integer(20);
      
      
//      Auto Boxing
//      wrapper 객체의 값을 뽑아서 일반 변수에 넣고 , 
//      일반 변수의 값을 래퍼 객체로 만드는 것을 자동화 하는것
//      "unBoxing"
//      wrapper일반 변수에 랩퍼 객체를 저장하려 하면 , 자동으로 값을 뽑아서 저장한다.
      int c = new Integer(30);    //컴파일러는 인스턴스에 대해 intValue() 문장으로 바꾼다.
      
//      "boxing"
//      일반적인 값을 Reference변수에 저장하려고 하면 , 그 값을 갖는 인스턴스를 자동 
//      생성한후 그 인스턴스의 주소를 저장한다.
      Integer obj = 30;
      
      
      
      
    }

  

}
