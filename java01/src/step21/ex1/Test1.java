package step21.ex1;

import java.awt.Frame;

/*
 * 윈도우 만들기
 * 
 * 자바 윈도우 프로그래밍!
 * => 결국 JVM은 OS에서 제공하는 메서드를 메서드를 호출한다.
 *     그러나 자바 개발자는 OS의 함수 이름을 알 필요가 없다.
 *     자바에서 제공하는 클래스와 메서드 사용법 만 알 면 된다.
 *     JVM이 해당 기능을 수행하는 OS의 함수를 호출 할 것이다.
 *     
 *     자바 윈도우 프로그래밍 라이브러리
 *     1) AWT (Abstract Window Toolkit)
 *        => 모든 OS에 공통으로 존재하는 윈도우를 만들 수 있다. =>윈도우 모양이 단순하다.
 *        => OS 마다 OS고유의 모습으로 출력한다.
 *        => OS가 윈도우 컴포넌트(위젯 widget) 를 완전히 그린다. 
 *     2) Swing
 *        => OS가 비어있는 윈도우를 그린다. => 나머지는 자바에서 OS의 도구를 이용하여 그린다.
 *        => OS가 완전히 그리는 것이 아니라 일부만 그리기 때문에 속도가 느리다.
 *        => OS에 상관 없이 동일한 모양을 출력한다.
 *     3) JAVA FX
 *     => 자바 코드가 아니라 특정 형식의 Tag를 사용하여 윈도우를 정의 할 수 있따.
 *     => 훨씬 풍부한 UI를 만들 수 있따.
 *     4) SWT
 *     ==> 이클립스에서 제공하는 자바 윈도우 프로그래밍 라이브러리이다.
 *     => AWT + SWing 의 장점을 결합한 라이브러리이다.
 *     => 기본 윈도우는 AWT로그려서 속도를 높이고
 *          OS에서 제공하지 않는 UI는 Swing처럼 직접 그려서 출력한다.
 *          => OS마다 출력 화면이 약간씩 다르다. OS의 기본 UI는 해당 OS 모양으로 출력하고
 *          => OS에 없는 것은 다른 형태로 출력한다.
 *          => 적용프로그램 => 이클립스 IDE
 *    
 *     */

public class Test1 {
  public static void main(String[] args) {
    
    Frame frame = new Frame();
    frame.setTitle("석환 윈도우");
    frame.setSize(400, 300);
    frame.setVisible(true);

  }
}
