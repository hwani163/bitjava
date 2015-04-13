package step17.ex2;

import java.io.File;

/*
 * File 클래스 사용법 익히기!!
 * File 클래스
 *  - 파일시스템의 파일 정보를 다루는 역할!*/
public class Test1 {

  public static void main(String[] args) throws Exception {
    
    File file = new  File("./src/../bin");   //이클립스에서 실행할 때 현재 폴더는 프로젝트 폴더 이다.
    
    //파일 경로정보 알아내기
    System.out.println(file.getAbsolutePath());   //절대 path
    System.out.println(file.getCanonicalPath());  //총계산이된 path
    System.out.println(file.getPath());
    System.out.println(file.getParent());
    
    //파일 정보 조회
    System.out.println(file.getName());
    System.out.println(file.getTotalSpace());
    System.out.println(file.getFreeSpace());
    System.out.println(file.getUsableSpace());
    
    file.canExecute();
    file.canRead();
    file.canWrite();
    
//    디렉토리인지 파일인지 검사
    if(file.isFile())
      System.out.println("파일이다.");
    if(file.isDirectory())
      System.out.println("디렉토리이다.");
    
    
  }

}
