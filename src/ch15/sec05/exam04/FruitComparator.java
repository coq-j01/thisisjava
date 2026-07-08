package ch15.sec05.exam04;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {
	@Override
	public int compare(Fruit o1, Fruit o2) {
		//이름 비교, 이름 같으면 가격비교
//		if(o1.price < o2.price) return -1;
//		else if(o1.price == o2.price) return 0;
//		else return 1;
		int result = o1.name.compareTo(o2.name);
//		if(result == 0) return o1.price - o2.price;
//		return result;
		return result == 0 ?  o1.price - o2.price : result;
	}
}