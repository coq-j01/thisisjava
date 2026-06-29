package ch02.sec06;

public class TextBlockExample {
	public static void main(String[] args) {
		String str1 = "" +
		"{\n" +
		"\t\"id\":\"winter\",\n" +
		"\t\"name\":\"눈송이\"\n" +
		"}";
		
		String str3 ="{\n\t\"id\":\"winter\",\n\t\"name\":\"눈송이\"\n}";

		String str2 = """
		{
			"id":"winter",
			"name":"눈송이"
		}
		""";	//텍스트블럭 문법

		System.out.println(str1);
		System.out.println("------------------------------------");
		System.out.println(str3);
		System.out.println("------------------------------------");
		System.out.println(str2);
		System.out.println("------------------------------------");
		String str = """
		나는 자바를 \
		학습합니다.
		나는 자바 고수가 될 겁니다.
		"""; // \<-백슬래시에 의해서 줄바꿈 취소
		System.out.println(str);
	}
}