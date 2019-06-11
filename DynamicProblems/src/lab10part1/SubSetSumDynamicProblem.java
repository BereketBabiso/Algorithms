package lab10part1;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

//Given a set S={s0,s1,.....,sn-1} of non-negative integers and some non-negative integer k,
//find a set T which is a subset of S and sumOf(T)=k. 

public class SubSetSumDynamicProblem {
	
	public Stack<Integer> subSetSum(Stack<Integer> S, int k){
		if(S.size()==1) {
			if(k==0) return new Stack<Integer>();
			else if(S.peek()==k) return S;
			else return null;
		}
		Stack<Integer> T = new Stack<>();
		int last = S.pop();
		T = subSetSum(S,k);
		if(T!=null) return T;
		T = subSetSum(S,(k-last));
		if(T!=null) {
			T.push(last);
			return T;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> S = new Stack<>();
		S.add(1);
		S.add(3);
		S.add(5);
		//System.out.println("subSetSum("+S+", "+5+")");
		
		SubSetSumDynamicProblem sbs = new SubSetSumDynamicProblem();
		System.out.println("The result of subsetsum : "+sbs.subSetSum(S, 9));

	}

}
