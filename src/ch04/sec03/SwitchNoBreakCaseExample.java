package ch04.sec03;

public class SwitchNoBreakCaseExample {
	public static void main(String[] args) {
		int time = (int)(Math.random()*4) + 8;  
		System.out.println("[현재시간: " + time + " 시]");
		
		switch(time) {
			case 8:
				System.out.println("출근합니다.");
			case 9:
				System.out.println("회의를 합니다.");
			case 10:
				System.out.println("업무를 봅니다.");
			default:
				System.out.println("외근을 나갑니다.");
		}
		
		switch(time) {
        case 8:
            System.out.println("출근합니다.");
            System.out.println("회의를 합니다.");
            System.out.println("부장님에게 보고한다.");
            System.out.println("업무를 봅니다.");
            System.out.println("외근을 나갑니다.");
            break;
        case 9:
            System.out.println("회의를 합니다.");
            System.out.println("업무를 봅니다.");
            System.out.println("외근을 나갑니다.");
            break;
        case 10:
            System.out.println("업무를 봅니다.");
            System.out.println("외근을 나갑니다.");
            break;
        default:
            System.out.println("외근을 나갑니다.");
        }

	}
}