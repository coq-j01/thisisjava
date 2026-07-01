package ch06.practice;

class ShopService{
	private static ShopService shopservice = new ShopService();
	
	private ShopService() {
    }
	
	static ShopService getInstance(){
		return shopservice;
	}
}
public class prac18 {
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		}else {
			System.out.println("다른 ShopService 객체입니다.");
		}
	}
}
