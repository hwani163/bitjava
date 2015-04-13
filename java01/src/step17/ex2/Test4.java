package step17.ex2;

import java.io.File;

/*실습목표 :  디렉토리에 들어있는 내용 알아내기!
 *             - 디렉토리에 들어있는 내뇽 알아내기
 *             -List() : 파일 및 디렉토리 이름배열
 *             -ListFiles() : 파일 및 디렉토리 정보를 담은 File인스턴스 배열*/
public class Test4 {

  public static void main(String[] args) {
    
//    현재 폴더에 들어있는 내용을 알아내자!
    File file = new File(".");
    printSimpleInfo(file);
    printDeatilInfo(file);
    printDeatilInfo2(file);
    
    

  }

  private static void printSimpleInfo(File file) {
    System.out.println("=====단순출력=====");
    String[] fileInfoList = file.list();
    
    for (String fileInfo : fileInfoList) {
      System.out.println(fileInfo);
    }
  }
  
  
  private static void printDeatilInfo(File file) {
    System.out.println("=======상세 출력=======");
    String[] fileInfoList = file.list();
    
    File temp=null; 
    for (String fileInfo : fileInfoList) {
      temp = new File(fileInfo);
      System.out.printf("%s%s%s%s     %-20s%d\n",
          temp.isDirectory() ? "d" :"-",
          temp.canRead() ? "r" : "-",
          temp.canWrite() ? "w" : "-",
          temp.canExecute() ? "x" : "-",
          fileInfo ,
          temp.length());
    }
    
    
}
  private static void printDeatilInfo2(File file) {
    System.out.println("=======상세 출력=======");
    File[] fileInfoList=file.listFiles(); 
    for (File temp : fileInfoList) {
      
      System.out.printf("%s%s%s%s     %-20s%d\n",
          temp.isDirectory() ? "d" :"-",
          temp.canRead() ? "r" : "-",
          temp.canWrite() ? "w" : "-",
          temp.canExecute() ? "x" : "-",
          temp.getName() ,
          temp.length());
    }
  
}
}
