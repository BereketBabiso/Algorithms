package lab10part1;

public class SubsequenceLongest {
	
	public int longestSubsequence(String s, String t) {
		if(s.length()==0 || t.length()==0) return 0;
		int sn=s.length();
		int tn=t.length();
		if(s.charAt(sn-1)==t.charAt(tn-1)) 
				return 1 + longestSubsequence(s.substring(0,sn-1),t.substring(0,tn-1));
		return longestSubsequence(s,t.substring(0,tn-1))>=longestSubsequence(s.substring(0,sn-1),t)?
				longestSubsequence(s,t.substring(0,tn-1)):longestSubsequence(s.substring(0,sn-1),t);
		
	}

	public static void main(String[] args) {
		
		String s = "regular";
		String t = "ruler";
		SubsequenceLongest sl = new SubsequenceLongest();
		System.out.println(sl.longestSubsequence(s, t));

	}

}
