package ch07.sec07.exam02;

public class AnimalExample {
	public static void main(String[] args) {
		고양이 cat = new 고양이();
		cat.울다();
		
		강아지 dog = new 강아지();
		dog.울다();
		
		동물 animal = cat;
		animal.울다();
		animal = dog;
		animal.울다();
		// 하나의 변수 사용 => 배열 사용 가능
		동물 [] arr1 = {cat,dog};
		for(동물 ani : arr1) {
			ani.울다();
		}
		
		동물 [] arr2 = {new 고양이(),new 강아지() ,new 강아지(),new 진돗개()};
		for(동물 ani : arr2) {
			ani.울다();
			// ani.꼬리흔들기(); //강아지만 가능
			if(ani instanceof 강아지) { //instanceof 객체확인
				강아지 dog2 = (강아지) ani; //강제 형변환
				dog2.꼬리흔들기();
			}
		}
	}

}
