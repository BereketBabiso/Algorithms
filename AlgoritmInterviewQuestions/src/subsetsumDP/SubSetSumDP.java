package subsetsumDP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubSetSumDP {
	
	private Map<Key, Boolean> map = new HashMap<>();
	
	public boolean subSetSum(List<Integer> set, int k) {
		System.out.println(">>>set : "+set);
	
		if(k<0 || k == 0) return k == 0;
		if(set.size()==1) {
			return set.get(0)==k;
		}
		int n = set.size() -1;
		int x = set.remove(n);
		Key temp1 = new Key(set, (k-x));
		if(!map.containsKey(temp1)) {
			map.put(temp1, subSetSum(set,k-x));
		}
		if(map.get(temp1)) return true;
		Key temp2 = new Key(set, k);
		if(!map.containsKey(temp2)) {
			map.put(temp2,subSetSum(set,k));
		}
		return map.get(temp2);
		
	}

	public static void main(String[] args) {
		SubSetSumDP ss = new SubSetSumDP();
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		int k = 9;
			
		System.out.println(ss.subSetSum(list, k));

	}

}
