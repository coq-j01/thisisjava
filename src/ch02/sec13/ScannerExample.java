package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("x 값 입력: ");
		String strX = scanner.nextLine(); //숫자가 아닌 "홍길동" 입력시
		int x = Integer.parseInt(strX); //int로 변환할 수 없어 오류
		
		//int x = scanner.nextInt(); // 처음부터 int만 받음
		
		System.out.print("y 값 입력: ");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);

		int result = x + y;
		System.out.println("x + y: " + result);
		System.out.println();
		int _age =10;
		System.out.println(_age);

		while(true) {
			System.out.print("입력 문자열: ");
			String data = scanner.nextLine();
			if(data.equals("q")) {
				break;
			}
			System.out.println("출력 문자열: " + data);
			System.out.println();
		}

		System.out.println("종료");
	}
}