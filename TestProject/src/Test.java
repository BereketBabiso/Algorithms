import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Test {
	
	public void setMaps(Map<String, String> map1, Map<String,String> map2) {
		map1.put("name", "bere");
		map2.put("name", "lizy");
		map1.put("age", "24");
		map2.put("name", "30");
		map1.put("moto", "love");
		map2.put("moto", "love");
	}
	
	public static void main(String[] args) {
		
		Map test = new HashMap<>();
		test.put(1,1);
		test.put(1,2);
		System.out.println(test);
		
		String t = " test";
		System.out.println(t.charAt(0)==' ');
		
		
		/*Test t = new Test();
		long start = System.currentTimeMillis();
		Map<String, String> UnmatchingMap = new HashMap<>();
		Map<String, String> map = new HashMap<>();
		t.setMaps(UnmatchingMap, map);
		
		Consumer<String> consumer = (field->{
			if(UnmatchingMap.get(field).equalsIgnoreCase(map.get(field))) {
				UnmatchingMap.remove(field);
			}
		});
		
		map.keySet().stream().forEach(consumer);
		
		System.out.println(System.currentTimeMillis() -start);
		System.out.println(UnmatchingMap);*/
	}

}
