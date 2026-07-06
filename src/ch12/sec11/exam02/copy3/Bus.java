package ch12.sec11.exam02.copy3;

public class Bus extends Car {
	//생성자
	public Bus() {
	}
	
	//메소드
	public void setModel(String model) { 
		super.setModel("버스 - " + model); 
	}
	
	public String getModel() {
		return super.getModel();
	}
}