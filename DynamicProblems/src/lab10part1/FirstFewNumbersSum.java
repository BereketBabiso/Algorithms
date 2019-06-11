package lab10part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FirstFewNumbersSum {
	private List<Integer> result = new ArrayList<>();
	int sum;
	
	public List<Integer> firstFewNumbersSum(Stack<Integer> S,int k){
		helper(S,k);
		return result;
	}
	private void helper(Stack<Integer> S,int k) {
		if(S.size()==1) {
			int x = S.pop();
			if(x<=k) {
				this.sum+=x;
				this.result.add(x);
			}
		}
		else {
			int x = S.pop();
			helper(S,k);
			if(x+sum<=k) {
				this.sum+=x;
				this.result.add(x);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> S = new Stack<Integer>();
		S.add(3);
		S.add(4);
		S.add(5);
		S.add(7);
		S.add(8);
		System.out.println(S);
		FirstFewNumbersSum ffns = new FirstFewNumbersSum();
		System.out.println(ffns.firstFewNumbersSum(S, 10));

	}

}
