package ch17.practice;

import java.util.Arrays;
import java.util.List;

//17강 확인문제 7
class Member2{
	private String name;
	private String job;
	
	public Member2(String name, String job) {
		this.name = name;
		this.job = job;
	}
	public String getName() {return name;}
	public String getJob() {return job;}
}
public class prac07 {
	public static void main(String[] args) {
		List<Member2> list = Arrays.asList(
				new Member2("홍길동","개발자"),
				new Member2("김나리","디자이너"),
				new Member2("신용권","개발자"));
		List<Member2> developers = list.stream()
				.filter(m -> m.getJob().contentEquals("개발자"))
				.toList();
		developers.stream()
			.forEach(m -> System.out.println(m.getName()));
	}
}