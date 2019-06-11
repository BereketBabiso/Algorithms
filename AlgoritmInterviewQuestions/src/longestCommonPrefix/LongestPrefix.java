package longestCommonPrefix;

/**
 * 
 * @author Bereket Babiso Nov 27, 2018. Dearborn, MI.
 * Write a function to find the longest common prefix string amongst an array of strings.

   If there is no common prefix, return an empty string "".
 *
 */
public class LongestPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null) return "";
        String result = strs[0];
        for(int i=1;i<strs.length;i++) {
            if(result.equals("")) break;
            if(strs[i].equals("") || strs[i].charAt(0)!=result.charAt(0)) {
                result="";
                break;
            }
            result = commonPrefix(result,strs[i]);
        }
        return result;
    }
   private static String commonPrefix(String s1, String s2) {
		if(s1.length()==1 || s2.length()==1) {
			return s1.charAt(0) == s2.charAt(0) ? s1.charAt(0) + "" : "";
		}
		if(s1.charAt(0)!= s2.charAt(0)) return "";
		return s1.charAt(0) + commonPrefix(s1.substring(1), s2.substring(1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"flower","flow","flight"};
		System.out.println(LongestPrefix.longestCommonPrefix(strs));

	}

}
