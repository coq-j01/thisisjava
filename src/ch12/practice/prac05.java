package ch12.practice;

import java.util.HashSet;

//12강 확인문제 5
class Student{
	private String studentNum;
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	String getStudentNum() {
		return studentNum;
	}
	//studentNum이 같으면 같은 객체로 판단할 수 있도록 코드 작성
	@Override
	public int hashCode() {
		int hashcode = Integer.parseInt(studentNum);
		return hashcode;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student student) {
			if(studentNum.equals(student.studentNum)) return true;
		}
		return false;
	}
}
public class prac05 {
	public static void main(String[] args) {
		//Student를 저장하는 HashSet 생성
		HashSet<Student> hashSet = new HashSet<Student>();
		
		//Student 저장
		hashSet.add(new Student("1"));
		hashSet.add(new Student("1")); //같은 학번으로 중복 저장 안 됨
		hashSet.add(new Student("2"));
		
		//저장된 Student 수 출력
		System.out.println("저장된 Student 수 : "+hashSet.size());
	}
}
