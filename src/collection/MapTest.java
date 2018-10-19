package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		// HashMap
		System.out.println("------HashMap无序输出------");
		HashMap hsMap = new HashMap();
		hsMap.put("3", "Value3");
		hsMap.put("1", "Value1");
		hsMap.put("2", "Value2");
		hsMap.put("b", "ValueB");
		hsMap.put("a", "ValueA");
		Iterator it = hsMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
		}

		// TreeMap
		System.out.println("------TreeMap按Key排序输出------");
		TreeMap teMap = new TreeMap();
		teMap.put("3", "Value3");
		teMap.put("1", "Value1");
		teMap.put("2", "Value2");
		teMap.put("b", "ValueB");
		teMap.put("a", "ValueA");
		Iterator tit = teMap.entrySet().iterator();
		while (tit.hasNext()) {
			Map.Entry e = (Map.Entry) tit.next();
			System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
		}

		// LinkedHashMap
		System.out.println("--LinkedHashMap根据输入的顺序输出--");
		LinkedHashMap lhsMap = new LinkedHashMap();
		lhsMap.put("3", "Value3");
		lhsMap.put("1", "Value1");
		lhsMap.put("2", "Value2");
		lhsMap.put("b", "ValueB");
		lhsMap.put("a", "ValueA");
		Iterator lit = lhsMap.entrySet().iterator();
		while (lit.hasNext()) {
			Map.Entry e = (Map.Entry) lit.next();
			System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
		}

	}

	public static void testHashMap() {
		Map<String, Integer> map = new HashMap<>();

		map.put("语文", 1);
		map.put("数学", 2);
		map.put("英语", 3);
		map.put("历史", 4);
		map.put("政治", 5);
		map.put("地理", 6);
		map.put("生物", 7);
		map.put("化学", 8);

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		int n = 20;
		System.out.println(n >>> 16);

	}
}