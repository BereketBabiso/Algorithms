package lab10part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PerfectSquareSum {
	
	private List<Integer> perfectSquareNums = new ArrayList<>();
	private HashMap<Integer,Integer> map = new HashMap<>();
	private int table [];
	
	public int perfectSquareSum(int num) {
		perfectSquares(num);	
		table = new int[num+1];
		for(int i=0;i<=num;i++) {
			table[i]--;
		}
		
		return helper(num);
	}
	
	private int helper(int val) {
		
		if(val==0) {
			table[val]=val;
			return table[val];
			}
		
		if(this.perfectSquareNums.size()==1) return val;
		
		int index = this.perfectSquareNums.size();
		int maxPerfectSquare = this.perfectSquareNums.remove(index-1);	
		
		if(table[val]<0) table[val]=helper(val);
		
		if(table[val % maxPerfectSquare]<0) table[val % maxPerfectSquare] = helper(val % maxPerfectSquare);
		 
		int x =table[val];
		int y = val/maxPerfectSquare + table[val % maxPerfectSquare];
		
		
		return x < y ? x:y;
		
		
	}

	private void perfectSquares(int num) {
		for(int i=1;i<=num;i++) {
			if(Math.sqrt(i)-(int)Math.sqrt(i) ==0) perfectSquareNums.add(i);
		}	
				
	}

	public static void main(String[] args) {
		
		PerfectSquareSum pss = new PerfectSquareSum();
		System.out.println(pss.perfectSquareSum(12));
		

	}

}
