package ch12.practice;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//12강 확인문제 16
public class prac16 {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat simpledate = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		String day = simpledate.format(today);
		System.out.println(day);
	}
}
