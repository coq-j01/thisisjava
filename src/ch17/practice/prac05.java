package ch17.practice;

import java.util.Arrays;
import java.util.List;

//17강 확인문제 5
public class prac05 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				"This is a java book",
				"Lambda Expressions",
				"Java8 supports lambda expressions"
		);
		list.stream()
			.filter(str -> str.toLowerCase().contains("java"))
			.forEach(System.out::println);
	}
}
