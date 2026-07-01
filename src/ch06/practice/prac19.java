package ch06.practice;

//6강 확인문제 19
class Account{
	private int balance;
	
	void setBalance(int balance) {
		if(balance>=0 && balance<=1000000)
			this.balance = balance;
	}
	int getBalance() {
		return balance;
	}
}
public class prac19 {
	public static void main(String[] args) {	
		Account account = new Account();
		
		account.setBalance(10000);
		System.out.println("현재 잔고 : "+account.getBalance());
		
		account.setBalance(-100);
		System.out.println("현재 잔고 : "+account.getBalance());
		
		account.setBalance(2000000);
		System.out.println("현재 잔고 : "+account.getBalance());
		
		account.setBalance(300000);
		System.out.println("현재 잔고 : "+account.getBalance());
	}
}
