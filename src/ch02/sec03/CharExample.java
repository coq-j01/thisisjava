package ch02.sec03;

public class CharExample {
	public static void main(String[] args) {
		char c1 = 'A';          	//문자 저장
		char c2 = 65;          	//유니코드 직접 저장
		
		char c3 = '가';         	//문자 저장
		char c4 = 44032;      	//유니코드 직접 저장
				
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		//(int)를 추가해 정수형으로 바꿔 출력
		System.out.println((int)c1);
		System.out.println((int)c2);
		System.out.println((int)c3);
		System.out.println((int)c4);
	}
} 