package ch12.practice;

//12강 확인문제 17
public class prac17 {
	public static void main(String[] args) {
		//첫번째는 알페벳 두번째부터 숫자와 알파벳으로 구성된 9~12자 사이 id값 확인하기
		String id = "5Angel1004";
		String regExp = "[A-Za-z]{1}[a-zA-Z0-9]{7,11}";
		boolean isMatch=id.matches(regExp);
		if(isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		}else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}
}
