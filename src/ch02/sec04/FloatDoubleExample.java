package ch02.sec04;

public class FloatDoubleExample {
	public static void main(String[] args) {
		//정밀도 확인
		float var1 = 0.1234567890123456789f; //소수점 7개까지만 잘나옴 8번째는 9번째 반올림
		double var2 = 0.1234567890123456789; //소수점 16개까지만 잘나옴 17번째는 반올림 수
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);

		//10의 거듭제곱 리터럴
		double var3 = 3e6;
		float var4 = 3e6F;
		double var5 = 2e-3;
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
	}
 }