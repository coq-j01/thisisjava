package ch06.practice;

import java.util.Scanner;

//6강 확인문제 20
class Account2 {
	String accountNumber;
	String owner;
	int balance;
}

class BankApplication {
	Account2[] account = new Account2[100];
}

public class prac20 {
	public static void main(String[] args) {
		BankApplication bankapplication = new BankApplication();
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int bankbook = 0;
		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택 > ");
			String select = scanner.nextLine();
			switch (select) {
			case "1" -> {
				System.out.println("----------\n계좌생성\n----------");
				bankapplication.account[bankbook] = new Account2();
				System.out.print("계좌번호 : ");
				bankapplication.account[bankbook].accountNumber = scanner.nextLine();
				System.out.print("계좌주 : ");
				bankapplication.account[bankbook].owner = scanner.nextLine();
				System.out.print("초기입금액 : ");
				bankapplication.account[bankbook].balance = Integer.parseInt(scanner.nextLine());
				System.out.println("결과 : 계좌가 생성되었습니다. ");
				bankbook++;
			}
			case "2" -> {
				System.out.println("----------\n계좌목록\n----------");
				if (bankbook != 0) {
					for (int i = 0; i < bankbook; i++) {
						System.out.println(bankapplication.account[i].accountNumber + "\t"
								+ bankapplication.account[i].owner + "\t"
								+ bankapplication.account[i].balance);
					}
				} else
					System.out.println("개설된 계좌가 없습니다.");
			}
			case "3"->{
				System.out.println("----------\n예금\n----------");
				System.out.print("계좌번호 : ");
				String accountNum = scanner.nextLine();
				System.out.print("예금액 : ");
				int bal = Integer.parseInt(scanner.nextLine());
				for (int i = 0; i < bankbook; i++) {
					if(bankapplication.account[i].accountNumber.equals(accountNum)) {
						bankapplication.account[i].balance += bal;
					}else if(i==(bankbook-1)) System.out.println("해당계좌를 찾지 못했습니다.");
				}
			}
			case "4" ->{
				System.out.println("----------\n출금\n----------");
				System.out.print("계좌번호 : ");
				String accountNum = scanner.nextLine();
				System.out.print("출금액 : ");
				int bal = Integer.parseInt(scanner.nextLine());
				for (int i = 0; i < bankbook; i++) {
					if(bankapplication.account[i].accountNumber.equals(accountNum) && bankapplication.account[i].balance>=bal) {
						bankapplication.account[i].balance -= bal;
					}else if(bankapplication.account[i].balance<bal){
						System.out.println("출금액이 계좌금액보다 커서 출금을 할 수 없습니다.");
					}else if(i==(bankbook-1))System.out.println("해당계좌를 찾지 못했습니다.");
				}
			}
			case "5" ->{
				System.out.println("프로그램 종료");
				run = false;
			}
			}
		}
	}
}
