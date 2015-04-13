package step16.ch05;

public class Car {

  String model;
  int speed;

  public Car() {
    super();
  }

  public void dashBoard() {
    System.out.printf("속도 : %dkm/h\n",this.speed);
  }

//  이 메서드는 자동차마다 다르기 때문에 굳이 Super클래스에서 정의할 필요가 없다.
  public void accelerate() {
    if (speed < 150) {
      speed+=10;
    }
    dashBoard();
  }

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