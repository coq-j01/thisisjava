package ch16.practice;
//16강 확인문제 5
class Button{
	@FunctionalInterface
	public static interface ClickListener{
		void onClick();
	}
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	public void click() {
		this.clickListener.onClick();
	}
}
public class prac05 {
	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setClickListener(()->System.out.println("OK 버튼을 클릭했습니다."));
		btnOk.click();
		
		Button btnCancel = new Button();
		btnCancel.setClickListener(()->System.out.println("Cancel 버튼을 클릭했습니다."));
		btnCancel.click();
	}
}
