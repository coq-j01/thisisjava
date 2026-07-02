package ch09.sec06.exam04;

public class 사람Example {
	public static void main(String[] args) {
		사람 human = new 사람();

		class 강아지 implements 사람.반려동물 {
			@Override
			public void 울다() {
				System.out.println("멍멍");
			}
		}

		human.set반려동물(new 강아지());
		
		human.cry();

		class 고양이 implements 사람.반려동물 {
			@Override
			public void 울다() {
				System.out.println("야옹");
			}
		}
		
		human.set반려동물(new 고양이());
		
		human.cry();
	}
}