package step16.ch05;


/*Car를 상속받는다.
 * dashBoard()와 accelerate() 는 이 클래스에 맞게끔 Overriding한다.
 * load()와 dump() 기능을 추가한다.*/
public class VolvoTruck extends Car {
  
  int hp;
  int weight;
  
//  기존 출력 + 다른 출력 기능을 덧붙일 때
  public void dashBoard(){
    super.dashBoard();    
    System.out.printf("중량 : %dkg\n",this.weight);
    
  }

  public void dump(){
    weight =0;
    dashBoard();
  }
  public void load(int weight){
    this.weight += weight;
    dashBoard();
  }
  
//  accelerate()는 이 클래스에 맞게끔 완전히 재정의 한다.
  
  @Override
  public void accelerate(){
    int reduceSpeed=0;
    if (weight > 0 && weight<10000) {
      reduceSpeed=2;
    }else if(weight>=10000 && weight <50000){
      reduceSpeed = 4;
    }else if( weight >50000){
      reduceSpeed = 6;
    }else {
      reduceSpeed=0;
    }
    
    if (speed < 200) {
      speed+=(10-reduceSpeed);
    }
    dashBoard();
  }
  
 

  public int getHp() {
    return hp;
  }
  public void setHp(int cc) {
    this.hp = cc;
  }
  
  public int getWeight() {
    return weight;
  }
  
  public void setWeight(int weight) {
    this.weight = weight;
  }
  

}
