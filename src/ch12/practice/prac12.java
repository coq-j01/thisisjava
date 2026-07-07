package ch12.practice;
//12강 확인문제 12
public class prac12 {
	public static void main(String[] args) {
		Integer obj1 =100;
		Integer obj2 =100;
		Integer obj3 =300;
		Integer obj4 =300;
		
		System.out.println(obj1 == obj2);
		System.out.println(obj3 == obj4); // 공간부족문제로 false 나옴
		System.out.println(obj3.equals(obj4));
	}
}
