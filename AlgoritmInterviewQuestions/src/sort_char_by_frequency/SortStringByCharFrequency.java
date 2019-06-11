package sort_char_by_frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * input = "tree" , output = "eetr";
 * Two solution is provided below. rearange1 and rearange2(best). 
 */
public class SortStringByCharFrequency {
	
	 public static String frequencySort(String s) {
		 long startTime = System.currentTimeMillis();
		 Map<Character, Integer> map = new HashMap<>();
		Object[] arr = new Object[s.length()];
		//List<Character> list = new ArrayList<>();
		for(int i =0 ;i<s.length();i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		for(Character c : map.keySet()) {
			if(arr[map.get(c)]== null) {
				List<Character> list = new ArrayList<>();
				list.add(c);
				arr[map.get(c)] = list;
			}else {
				List<Character> a = (ArrayList<Character>) arr[map.get(c)];
				a.add(c);
			}
		}
		String result="";
		for(int j=arr.length-1;j>0;j--) {
			if(arr[j]!=null) {
				result = result + arr[j].toString();
			}
		}
		System.out.println(result.replaceAll(", |\\[|\\]", ""));
		long endTime = System.currentTimeMillis();
		
		System.out.println("first approach : "+(endTime - startTime));
		
		 return result;
	 }
	 
	 public String rearrange(String str) {
		    long startTime = System.currentTimeMillis();
			if(str==null || str.trim().length()<3) return str;
			String res =  helper(str);
			long endTime = System.currentTimeMillis();
			
			System.out.println("time taken using first approach (using stream api map sort) : "+(endTime-startTime));
			
			return res;
		}
		
		private String helper(String str) {
			Map<Character, Integer> map = new LinkedHashMap<>();
			char x;
			for(Character c : str.toCharArray()) {
				if(map.containsKey(c)) {
					map.put(c, map.get(c)+1);
				} else {
					map.put(c, 1);
				}
			}
			//System.out.println(map);
			long start = System.currentTimeMillis();
			Map<Character, Integer> sortedMap = map.entrySet().stream()
					                               .sorted(Entry.comparingByValue())
					                               .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2)->e1,LinkedHashMap::new));
			long end = System.currentTimeMillis();
			System.out.println("map sorting "+(end-start));
			String res = "";
			String temp="";
			for(Character c : sortedMap.keySet()) {
				temp = repeat(c,sortedMap.get(c));
				res = temp+res;
			}
			return res;
		}

		private String repeat(Character c, Integer integer) {
			if(integer==0) return "";
			integer--;
			return c + repeat(c,integer);
		}
		
		public String reaarange2(String str) {
			long start = System.currentTimeMillis();
			if(null==str || str.trim().length()<3) return str;
			String res = helper(str);
			long end = System.currentTimeMillis();
			System.out.println("time taken using second approach >>>> : "+(end-start));
			return res;
		}
		
		private String helper2(String str) {
			int n = str.length();
			Map<Character, Integer> map = new LinkedHashMap<>();
			for(Character c : str.toCharArray()) {
				if(map.containsKey(c)) {
					map.replace(c, map.get(c)+1);
				} else {
					map.put(c, 1);
				}
			}
			System.out.println(map);
			LinkedList<Character>[] arrList = new LinkedList[n+1];
			for(Character c : map.keySet()) {
				if(null==arrList[map.get(c)]) {
					LinkedList<Character> list = new LinkedList<Character>();
					list.add(c);
					arrList[map.get(c)] = list;
				}
				else if(!arrList[map.get(c)].contains(c)) {
					arrList[map.get(c)].add(c);
				}
			}
			System.out.println(arrList[2]);
			String result="";
			for(int i=0;i<=n;i++) {
				if(null!=arrList[i]) {
					int x = arrList[i].size();
					while(x>0) {
						result = repeat(arrList[i].removeFirst(),i) + result;
						x--;
					}
				}
			}
			return result;
		}

  
		public String rearrange3(String str) {
			int[] allCharArray = new int[95];
			char x;
			for(Character c : str.toCharArray()) {
				allCharArray[c-32] = allCharArray[c-32]+1;
			}
			String reslt = "";
			for(int i=0;i<95;i++) {
				if(allCharArray[i]>0) {
					x =  (char)(i+32);
					reslt = reslt + repeat(x,allCharArray[i]);
				}
			}
			return reslt;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="abcdefghijklmnopqstruvwxyzaaaaabbbbcccddeeffgghhiijjkkllmmnnooppqqssttuuvvxxyyzz"
				+ "abcdefghijklmnopqstruvwxyzaaaaabbbbcccddeeffgghhiijjkkllmmnnooppqqssttuuvvxxyyz";
		
	    String s="aabbbzzzz";
		
		SortStringByCharFrequency tst = new SortStringByCharFrequency();
		System.out.println("option1 : "+tst.rearrange(str));
		System.out.println("option2 : "+tst.reaarange2(str));
		System.out.println("option3 : "+tst.rearrange3(str));
		
		
//		String t = "berkt";
//		int[] arr = new int[95];
//		for(Character c : t.toCharArray()) {
//			arr[c-32] = arr[c-32]+1;
//		}
//		String reslt = "";
//		for(int i=0;i<95;i++) {
//			if(arr[i]>0) {
//				System.out.println(arr[i]);
//				reslt = reslt + (char)(i+32);
//			}
//		}
//		System.out.println("testing some shit : "+reslt);

	}

}
