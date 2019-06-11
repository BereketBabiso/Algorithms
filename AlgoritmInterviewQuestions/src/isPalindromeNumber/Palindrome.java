package isPalindromeNumber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
	
	public boolean isPalindrome(int x) {
		int test=x;
        if(x<0) return false;        
        if(x>=0 && x<10) return true;
        if(x%10==0) return false;
        int y=0;
        int pw=0;
        List<Integer> list = new ArrayList<>();
        while(!(x<10)){
            list.add(x%10);
            x=x/10;   
            pw++;
        }
        list.add(x);       
        for(Integer i : list){
            y=y+(i*(int)Math.pow(10,pw));
            pw--;
        }       
        if(test==y) return true;
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome p = new Palindrome();
		//System.out.println(p.isPalindrome(0));
		
		int x = 1221;
		int i =0;
//		while(x/10!=0) {
//			x=x/10;
//			i++;
//		}
//		System.out.println(x/(int)Math.pow(10, 5));
//		System.out.println(x%(int)Math.pow(10, 5));
		
		x = x%(int)Math.pow(10, 3);
		int t = x%(int)Math.pow(10, 1);
		x=(x - t)/10;
		System.out.println(x);
		System.out.println(x);
	}

}
