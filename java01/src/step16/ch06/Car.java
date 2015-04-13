package step16.ch06;

public abstract class Car {

  String model;
  int speed;

  public Car() {
    super();
  }

  public void dashBoard() {
    System.out.printf("속도 : %dkm/h\n",this.speed);
  }

//  이 메서드는 자동차마다 다르기 때문에 자신의 차종에 맞게끔 재정의 해야 한다.
  public abstract void accelerate();
   

  public void reduce() {
    if (speed > 0) {
      speed -=10;
    }
    dashBoard();
  }

  public void stop() {
    speed =0;
    dashBoard();
  }



  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

}