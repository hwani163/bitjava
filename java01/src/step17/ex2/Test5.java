package step17.ex2;

import java.io.File;
import java.io.IOException;

/*
 * 실습목표 : 현재 디렉토리의 모든 파일 및 디렉토리 정보 출력하기
 *  - 하위 디렉토리 모두 포함.*/
public class Test5 {

  public static void main(String[] args) throws Exception {
    
    File file = new File(".");
    
    printFileInfo(file);
//    ./
//    ./src
//    ./src/SelectStudent.java
//    ...
  }

  private static void printFileInfo(File file) throws IOException {
    System.out.println(file.getAbsolutePath());
    
    if (file.isDirectory()) {
      File[] fileList = file.listFiles();
      for (File file2 : fileList) {
        printFileInfo(file2);
      }
    }
    
    
    
    
    
    
    
//    File[] fileInfoList=file.listFiles();
//    
// for (File temp : fileInfoList) {
//      
//     if (temp.isDirectory()){
//       System.out.println(temp.getName());
//       System.out.print(temp.getPath()+"/");
//       File[] fileInfoList2 = temp.listFiles();
//       printFileInfo(temp);
//     }
//     
//       
//     else
//       System.out.println(temp.getPath()+"/");
//     
//    }
          
    }
    
  }

