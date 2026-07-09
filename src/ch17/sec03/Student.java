package ch17.sec03;

public class Student {
	private String name;
	private int score; //Student -> int 타입변환(매핑)
	
	public Student (String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() { return name; }
	public int getScore() { return score; }
}