package step21.ex1;

import java.awt.Frame;

/*
 * 윈도우 만들기
 * 자바 윈도우 프로그래밍!
 * => 결국 JVM 은 OS에서 제공하는 메서드를 호출한다.
 * 그러나 자바개발자는 OS의 함수 이름을 알 필요가 없다.
 * 자바에서 제공하는 클래스와 메서드 사용법만 알면 된다.
 * JVM이 해당기능을 수행ㅎ는 OS의 함수를 호출 할 것인다.
 * 
 * JAVA WINDOW PROGRAMING LIBLARY
 * 1) AWT(abstract window toolkit)
 * 모든 OS 에 공통으로 존재하는 윈도우를 만들 수 있따. -> 윈도우 모양이 단순
 * OS 마다 OS고유의 모습으로 출력한다.
 * OS 가 윈도우 컴포넌트를 완전히 그린다.
 * 
 * 2)Swing
 * -> OS가 비어있는 윈도우를 그린다. -> 나머지는 자바에서 그린다.
 * OS가 완전히 그리는 것이 아니라 일부만 그리기 때문에 속도가 매우 느림
 * 하지만 JVM에 의해서 그려지는 것 이기 때문에 OS에 상관없이 동일한 모양을 출력한다.
 * 
 * 3)JAVA FX
 * => 자바코드가 아니라 특정 형식의 Tag를 사용하여 윈도우를 정의할 수 있따.
 * -> 훨씬 풍부한 UI를 만들 수 있다.
 * 
 * 4) SWT 
 * -> 이클립스에서 제공하는 자바 윈도우 프로그래밍 라이브러리이다.
 * -> AWT + Swing의 장점을 결합한 라이브러리이다.
 * -> 기본 윈도우는 AWT로 그려서 속도를 높이고
 * OS 에서 제공하지 않는 UI는 Swing으로 그려서 출려갛ㄴ다.
 * OS마다 출력화면이 약간씩 다르다 OS의 기본 UI는 해당 OS의 모양으로 나오기 떄문이다.
 * 이것으로 만든 프로그램이 이클립스이다.
 * */
public class Pra1 {
public static void main(String[] args) {
  
  Frame frame = new Frame();
  frame.setTitle("석환윈도우");
  frame.setSize(200, 300);
  frame.setVisible(true);
}
}
