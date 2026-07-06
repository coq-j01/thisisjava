package ch12.sec06;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		int a=10;
		short b = 20;
		byte c =30;
		float d = 10.234f;
		double e = 123.456; 
		
		Object [] arr = { //boxing
				a,b,c,d,e
		};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].getClass().getSimpleName());
		}
	}
}