package ch03.sec08;

public class BitLogicExample {
	public static void main(String[] args) {
		System.out.println("45 & 25 = " + (45 & 25)); // 00101101 & 00011001 -> 00111101
		System.out.println("45 | 25 = " + (45 | 25)); // 00101101 | 00011001 -> 00001001
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + (~45));
		System.out.println("-------------------------------");

		byte receiveData = -120;
		
		String binary = String.format("%8s",
            Integer.toBinaryString(receiveData & 0xFF))
            .replace(' ', '0');

	    System.out.println(binary);

		//방법1: 비트 논리곱 연산으로 Unsigned 정수 얻기
		int unsignedInt1 = receiveData & 255; // 255대신 0xff 사용 가능 
		System.out.println(unsignedInt1);
		
        String binary2 = String.format("%32s",
                Integer.toBinaryString(unsignedInt1))
                .replace(' ', '0');
        System.out.println(binary2);
		
		//방법2: 자바 API를 이용해서 Unsigned 정수 얻기
		int unsignedInt2 = Byte.toUnsignedInt(receiveData);
		System.out.println(unsignedInt2);

		int test = 136;
		byte btest = (byte) test;
		System.out.println(btest);
	}
}