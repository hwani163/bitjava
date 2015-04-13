package step16.ch09;
/*
 * interface 상속
 * -> interface도 상속 받을 수 있다.*/
public class Test2 {
  
  static interface Battery{
    void charge();
    float getState();
    
  }
  
//  기존의 Battery 규칙에 새 규칙 추가
  static interface AdvancedBattery extends Battery{
    void highSpeedCharge();
  }
  
//  기존의 규칙에 새 규칙 추가
  
  static interface ExtentionBattery extends AdvancedBattery{
    void append(Battery battery);
  }
  
  static class BitBattery1 implements Battery{

    @Override
    public void charge() {
      
    }

    @Override
    public float getState() {
      return 0;
    }
    
  }
  
  
  //AdvancedBattery 인터페이스가 상속받은 메서드도 구현하야 한다!
  static class BitBattery2 implements AdvancedBattery{

    @Override
    public void charge() {
      //Battery Method 구현
    }

    @Override
    public float getState() {
    //Battery Method 구현
      return 0;
    }

    @Override
    public void highSpeedCharge() {
    //AdvancedBattery Method 구현      
    }
    
  }
  
  static class BitBattery3 implements ExtentionBattery{

    @Override
    public void highSpeedCharge() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void charge() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public float getState() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public void append(Battery battery) {
      // TODO Auto-generated method stub
      
    }
    
  }

}
