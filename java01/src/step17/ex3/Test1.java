package step17.ex3;

import java.io.File;
import java.io.FileOutputStream;

/*
 * 실습목표 : Byte Data 출력(byte 단위)
 * 
 * 기본 입출력 개요
 * - byte 또는 char 단위로 입출력 하기
 * - 도구 :
 *          1) InputStream , OutputStream계열
 *          2) Reader , Writer계열
 *          
 *          
 *    InputStream , OutputStream 계열
 *      - Byte단위로 입출력하는 클래스 ->"Byte Stream"
 *      - Char단위로 입출력하는 클래스 ->"Char Stream" 
 *          
 *    Reader , Writer 계열
 *      - char 단위로 입출력 하는 클래스
 *      - 읽기 : 파일(UTF-8) => JVM(UniCode2)
 *      - 쓰기 : JVM(UniCode) => 파일(UTF-8)
 *      읽고 쓸 때 유니코드를 시스템 기본 문자 집합으로 변환하는 기능을 수행한다.
 *      
 *    저장소유형
 *      - 메모리 , 파일 , 프로세스(실행 중인 프로그램)
 *      
 *              "Data Sink Stream Class"
 *      저장소유형에 따라서 데이터를 입출력 하는 도구
 *      1) 메모리
 *          - Byte Stream : ByteArrayInputStream / ByteArrayOutputStream 클래스
 *          - Char Stream : CharArrayReader / CharArrayWriter
 *                            :  StringReader / StringWriter
 *      2) 파일
 *          -Byte Stream : FileInputStream / FileOutputStream
 *                           : 예) BinaryFile =>기본 텍스트편집기로 편집할수없는 데이터 , 
 *                                                  .pdf .gif .jpg .....(전용편집기가 있어야만 편집가능)
 *                                                  
 *          -char Stream : FileReader / FileWriter
 *                            예) TextFile =>기본 text편집기로 편집할수 있는 데이터.
 *                                txt , java , csv rtf , css , html , js
 *          
 *      3)프로세스
 *         -byte Stream : PipedInputStream/PipedOutputStream
 *         -char stream : PipedReader/PipedWriter
 *         
 *           "Data Processing Stream Class"
 *   위에서 언급한 입출력 클래스 외의 나머지 클래스는
 *   입출력 중간에서 데이터를 가공하는 일을 한다.
 *         */
public class Test1 {
  public static void main(String[] args) throws Exception {
    File file = new File("temp/test.txt");
    FileOutputStream out = new FileOutputStream(file);
//    write(int) : 1byte를 출력한다.
//    write() 메서드의 파라메터 타입이 int라고해서 속지말라!
//    int 값 줘봐야 맨 끝 1바이트만 출력된다.
    out.write(0x2fab);
    out.write(0xaabb);
    out.write(0x8899);
    out.write(0xabcd);
    
//    항상 입출력을 완료한 후 자원을 해제하여야 한다.
    out.close();
    
      }

}
