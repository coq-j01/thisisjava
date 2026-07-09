package ch13.practice;

import oracle.net.aso.k;

//13강 연습문제 4
class Pair<K,V>{
	private K key;
	private V value;
	
	Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {return key;}
	public V getValue() {return value;}
}
class ChildPair<K,V> extends Pair<K,V> {
	ChildPair(K k, V v){
		super(k,v);
	}
}
class OtherPair<K,V>{
	private K key;
	private V value;
	
	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {return key;}
	public V getValue() {return value;}
}
class Util<K,V>{
	public static <K,V> V getValue(Pair<K,V> p , K k) {
		K key = p.getKey();
		if(key.equals(k)) return p.getValue();
		else return null;
	}
}
public class prac04 {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair,"홍길동");
		System.out.println(age);
		
		ChildPair<String, Integer> childpair = new ChildPair<>("홍삼원", 31);
		Integer childage = Util.getValue(childpair,"홍삼순");
		System.out.println(childage);
	}
}