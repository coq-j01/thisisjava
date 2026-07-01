package ch06.practice;

//6강 확인문제 15번
class MemberService {
	String id;
	String password;
	
	boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) return true;
		else return false;
	}
	void logout(String id) {
		System.out.println(id+"님이 로그아웃 되었습니다.");
	}
}

public class prac15 {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong","12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}
