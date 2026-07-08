package ch15.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//15강 확인문제 9
public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("hong", 86);
		map.put("white", 92);
		map.put("blue", 96);

		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			int score = map.get(key);
			if(maxScore < score) {
				maxScore = score;
				name = key;
			}
			totalScore+=score;
		}
		//iterator.remove(); -> 이거 쓰면 map도 같이 지워짐,, 값을 공유
		System.out.println("평균 점수 : "+(totalScore / map.size()));
		System.out.println("최고 점수 : "+ maxScore);
		System.out.println("최고 점수를 받은 아이디 : "+name);
	}
}
