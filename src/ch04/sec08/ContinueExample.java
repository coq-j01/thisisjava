package ch04.sec08;

public class ContinueExample {
	public static void main(String[] args) throws Exception {
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {
				continue; // i가 홀수 일 때는 print실행하지 않고 다시 for문
			}
			System.out.print(i + " ");
		}
	}
}