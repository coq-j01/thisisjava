package ch12.sec09;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.89;

		DecimalFormat df;
		
		//정수 자리까지 표기
		df = new DecimalFormat("#,###"); //# -> 정수 자리 수(없으면 안 적힘)
		System.out.println( df.format(num) );
		
		//무조건 소수 첫째 자리까지 표기 // #.0 -> .0은 해당자리가 없어도 무조건 출력됨
		df = new DecimalFormat("#,###.0");
		System.out.println( df.format(num) );
	}
}