package ch16.sec01;

@FunctionalInterface // 추상 메소드가 하나여야 함
public interface Calculable {
	//추상 메소드
	void calculate(int x, int y);
}