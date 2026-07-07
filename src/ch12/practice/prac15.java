package ch12.practice;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//12강 확인문제 15
public class prac15 {
	public static void main(String[] args) {
		//올해 얼마나 남았는지 확인하는 코드
		LocalDate today = LocalDate.now();
		LocalDate lastday = LocalDate.of(2026, 12, 31);
		long remaindays = today.until(lastday, ChronoUnit.DAYS);
		System.out.println("올해는 "+remaindays+"일 남았습니다.");
	}
}
