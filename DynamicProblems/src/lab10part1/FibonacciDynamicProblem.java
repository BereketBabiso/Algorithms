package lab10part1;

public class FibonacciDynamicProblem {
	private int table[];
	
	public int fibonacci(int n) {
		table = new int[n+1];
		for(int i=0;i<=n;i++) {
			table[i]--;
		}
		return helper(n);
	}
	
	public int helper(int num) {
		if(num==0 || num==1) {
			table[num]=num;
			return table[num];
		}
		
		if(table[num-1]<0) {
			table[num-1]=helper(num-1);
		}
		if(table[num-2]<0) table[num-2]=helper(num-2);
		
		return table[num-1]+table[num-2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciDynamicProblem fibDP = new FibonacciDynamicProblem();
		System.out.println(fibDP.fibonacci(6));

	}

}
