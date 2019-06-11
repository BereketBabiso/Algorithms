package question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NOverKElements {
	private HashMap<Integer,Integer> map = new HashMap<>();
	
	public List<Integer> nOverKElements(int[] input,int k) {
		int ratio = input.length/k;
		List<Integer>ret = new ArrayList<>();
		for(int i=0;i<input.length;i++) {
			if(this.map.containsKey(input[i])) {
				map.replace(input[i], map.get(input[i])+1);
			}else {
				map.put(input[i],1);
			}
		}
		map.keySet().forEach(i->{
			if(map.get(i)>ratio) ret.add(i);
		});
		
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
		int k=4;
		NOverKElements p = new NOverKElements();
		System.out.println(p.nOverKElements(arr, k));
		
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(2);
		list.addLast(3);
		list.addFirst(1);
		list.removeLast();
		System.out.println(list);

	}

}
