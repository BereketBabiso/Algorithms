/*
 Given a 32-bit signed integer, reverse digits of an integer.
 Input: 123    Output: 321
 Input: -123   Output: -321
 Input: 120    Output: 21
 
 Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer 
range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when 
the reversed integer overflows.
 */
public class ReverseNumber {
	public int reverse(String x) {
		try {
		int y = Integer.parseInt(x);
		return reverse(y);}
		catch(NumberFormatException ex) {
			return 0;
		}
	}
	public int reverse(int x) {
        String ret ="";
        int sign =1;
        if(x<0) {
            sign = -1;
            x = -x;
        }
        if((x<(-1*(int)Math.pow(2,31)))||(x>=(int)Math.pow(2,31))) return 0;
        while(!(x<10)){
            int t = x%10;
            ret = ret+t;
            x=x/10;
        }
        ret=ret+x;
        if(ret.charAt(0)==0 && ret.length()>1) ret=ret.substring(1);
        try{
        int result = Integer.parseInt(ret)*sign;
        return result;}
        catch(NumberFormatException ex){
            return 0;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNumber rn = new ReverseNumber();
		System.out.println(rn.reverse("9646324351"));
		String s="+ 1";
		char x = s.charAt(0);
		System.out.println(Double.parseDouble(s));

	}

}
