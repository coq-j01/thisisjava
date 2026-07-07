package ch12.practice;
//12강 확인문제 6
class Member{
	private String id;
	private String name;
	
	Member(String id, String name){
		this.id = id;
		this.name = name;
	}
	//toString() 오버라이딩
	@Override
	public String toString() {
		return id + ": "+name;
	}
}
public class prac06 {
	public static void main(String[] args) {
		Member member = new Member("blue","이파란");
		System.out.println(member);
	}
}
