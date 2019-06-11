package length_of_longest_substring;



public class LongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
	if(s==null || s.isEmpty()) return 0;
	int n = s.length();
	int temp1 = 1;
	int temp2 = 0;
	String temp;
	String x="";
	for(int i=0; i<n;i++) {
		temp = s.charAt(i) + "";
		if(n>i+1) {
			x = s.substring(i+1);
			if(temp1 >= s.length()) break;
			temp2 = subStringLength(s.substring(i+1), temp);
			if(temp2 > temp1) temp1 = temp2;
		}
	}
	return temp1;
	}

	private static int subStringLength(String substring, String temp) {
		String t = substring.charAt(0) + "";
		if(temp.contains(t)) return temp.length();
		temp= temp + t;		
		return substring.length()==1 ? temp.length() : subStringLength(substring.substring(1), temp);
	}

	public static void main(String[] args) {
		String s ="ab";
		//char c = s.charAt(1);
		System.out.println(LongestSubstring.lengthOfLongestSubstring("ab"));

	}

}
