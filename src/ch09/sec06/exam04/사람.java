package ch09.sec06.exam04;

public class 사람{
	//정적 멤버 인터페이스
	public static interface 반려동물 {
		//추상 메소드
		void 울다();
	}

	//필드
	private 반려동물 반려동물;

	//메소드
	public void set반려동물(반려동물 반려동물) {
		this.반려동물 = 반려동물;
	}

	public void cry() {
		this.반려동물.울다();
	}
}