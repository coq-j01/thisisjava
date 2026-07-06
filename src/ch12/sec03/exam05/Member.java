package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data //get/set 자동 추가
@AllArgsConstructor //모든 필드로 생성자 생성
public class Member {
	private String id;
	@NonNull private String name;
	private int age;
}