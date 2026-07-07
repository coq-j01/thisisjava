package ch12.practice;
//12강 확인문제 10
public class prac10 {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		for(int i=1; i<=100; i++){
			//str+=i; //StringBuilder사용하여 코드 개선
			str.append(i);
		}
		System.out.println(str.toString());
	}

}
