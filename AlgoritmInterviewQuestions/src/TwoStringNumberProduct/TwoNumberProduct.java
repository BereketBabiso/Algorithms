package TwoStringNumberProduct;

/**
 * 
 * @author berek
 * Given two non-negative integers num1 and num2 represented as strings,
 *  return the product of num1 and num2, also represented as a string.
 *  Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class TwoNumberProduct {
	
	public String multiply(String num1, String num2) {
		long startTime = System.currentTimeMillis();
        String s1;
        String s2;
        int l1 = num1.length();
        int l2 = num2.length();
        if(l1>=l2) {
        	s1 = num1;
        	s2 = num2;
        } else {
        	s1 = num2;
        	s2 = num1;
        }
        l1 = s1.length();
        l2 = s2.length();
        int carryOver = 0;
        String result ="0";
        for(int i=l2-1;i>=0;i--) {
        	
        	int x = s2.charAt(i) -48;
        	
        	String temp = "";
        	for(int j=l1-1;j>=0;j--) {
        		int y = s1.charAt(j) - 48;
        		int prod = x*y + carryOver;
        		
        		if(prod>9) {
        			temp = (prod%10) + temp;
        			carryOver = prod/10;
        		} else {
        			temp = prod + temp;
        			carryOver = 0;
        		}
        		
        	}
        	if(carryOver > 0) {
        		temp = carryOver + temp;
        		carryOver = 0;
        	}
        	temp = appendZeros(temp, l2-1-i);
        	result = sum(result, temp);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time taken : "+(endTime-startTime)+"ms");
        return result;
    }

	public String appendZeros(String temp, int i) {
		while(i>0) {
			temp = temp + "0";
			i--;
		}
		return temp;
	}

	public String sum(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) return "0";
		int l1 = num1.length();
		int l2 = num2.length();
		int carryOver = 0;
		String result="";
		while(l1>0 || l2>0) {
			if(l1>0 && l2>0) {
				int x = num1.charAt(l1-1) - 48;
				int y = num2.charAt(l2-1) - 48;
				l1--;
				l2--;
				int sum = x+y+carryOver;
				if(sum>9) {
					result = sum%10 + result;
					carryOver = sum/10;
				} else  {
					result = sum + result;
					carryOver = 0;
				}
			}
			else if( l1>0) {
				l1--;
				int x = num1.charAt(l1) - 48;
				int sum = x + carryOver;
				if(sum>9) {
					result = sum%10 + result;
					carryOver = sum/10;
				} else {
					result = sum + result;
					carryOver = 0;
				}
			}
			else {
				l2--;
				int y = num2.charAt(l2) - 48;
				int sum = y + carryOver;
				if(sum>9) {
					result = sum%10 + result;
					carryOver = sum/10;
				} else {
					result = sum + result;
					carryOver = 0;
				}
			}
		}
		if( carryOver>0) result = carryOver + result;
		return result;
	}

	private String reverse(String string) {
		if(string.length()==1) return string;
		return string.charAt(string.length()-1) + reverse(string.substring(0, string.length()-1));
	}
	
	public static void main(String[] args) {
		TwoNumberProduct prod = new TwoNumberProduct();
		System.out.println("sum of 533 and 5778 = "+prod.sum("533", "5778"));
		System.out.println("product of 12 and 12 = "+prod.multiply("12", "12726"));
		System.out.println(12*12726);
		
	}

}
