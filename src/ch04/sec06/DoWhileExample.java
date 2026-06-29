package ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {
	public static void main(String[] args) {
		
//		System.out.println("메시지를 입력하세요.");
//		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
//
//		Scanner scanner = new Scanner(System.in);
//		String inputString;
//
//		do {
//			System.out.print(">");
//			inputString = scanner.nextLine();
//			System.out.println(inputString);
//		} while( ! inputString.equals("q") );
//
//		System.out.println();
//		System.out.println("프로그램 종료");
		
		//1. 1~100 까지의 합 구하기
		int num =1;
		int sum =0;
		do {
			sum += num;
			num++;
		}while(num<=100);
		System.out.println("1~"+(num-1)+"까지의 합은 "+sum);
		
		//2. 구구단
		int x=2, y;
		do {
			System.out.println(x+"단");
			y=1;
			do {
				System.out.println(x+"*"+y+"="+ x*y );
				y++;
			}while(y<=9);
			x++;
		}while(x<=9);
	}
}