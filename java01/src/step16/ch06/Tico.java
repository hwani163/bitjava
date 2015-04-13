package step16.ch06;

public class Tico extends Car {
  
//  이 메서드는 추상 메서드 이기 때문에
//  서브 클래스에서 반드시 구현 하여야 한다. 
  @Override
  public void accelerate() {
    if (speed < 150) {
      speed+=10;
    }
    dashBoard();
    
  }
  protected int cc;
  protected int capacity;
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

}
