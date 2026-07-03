package ch09.practice;
//9강 확인문제 4
class Car{
	class Tire{}
	static class Engine{}
}
public class CarExample {
	public static void main(String[] args) {
		Car mycar = new Car();
		Car.Tire tire = mycar.new Tire();
		Car.Engine engine = new Car.Engine();
	}
}
