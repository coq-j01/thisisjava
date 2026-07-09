package ch13.practice;
//13강 확인문제 3
class Container0<K,V>{
	private V v;
	private K k;
	
	public void set(K k,V v) {
		this.k =k;
		this.v =v;
	}
	public K getKey() {return k;}
	public V getValue() {return v;}
}
public class prac03 {
	public static void main(String[] args) {
		Container0<String,String> container1 = new Container0<String, String>();
		container1.set("홍길동","도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1+job);
		
		Container0<String,Integer> container2 = new Container0<String, Integer>();
		container2.set("홍길동",35);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2+age);
	}
}