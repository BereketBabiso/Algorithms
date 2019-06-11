package twoNumbersSum;

/**
 * 
 * @author bereket
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)  , Output: 7 -> 0 -> 8
 *
 */
public class TwoNumberSum {
	
	public TreeNode addTwoNumber(TreeNode num1, TreeNode num2) {
		return num1==null? num2 : num2==null ? num1 : sum(num1, num2);
	}
	
	private TreeNode sum(TreeNode num1, TreeNode num2) {		
		int carryOver=0;
		int x = num1.value;
		int y = num2.value;
		int sum = x +y;
		if(sum>9) {			
			carryOver = sum/10;
			sum = sum%10;
		}
		TreeNode result = new TreeNode(sum);
		TreeNode temp = result.next;
		
		num1 = num1.next;
		num2=num2.next;
		
		while(num1!=null || num2!=null) {
			if(num1!=null && num2!=null) {
				x = num1.value;
				y = num2.value;
				sum = x+y+carryOver;
				if(sum>9) {
					carryOver = sum/10;
					sum = sum%10;
				} else carryOver = 0;
				TreeNode node = new TreeNode(sum);
				temp = node;
				temp = temp.next;
				num1 = num1.next;
				num2 = num2.next;
			}
			else if(num1!=null) {
				
			}
		}
		return result;
	}

	public class TreeNode {
		private int value;
		private TreeNode next;
		public TreeNode(int val) {
			value = val;
		}
		
		public void print() {
			TreeNode node = this;
			StringBuilder sb = new StringBuilder("["+node.value);
			while(node.next!=null) {
				node = node.next;
				sb.append(", "+node.value);
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
//		TwoNumberSum tsum = new TwoNumberSum();
//		TreeNode num1 = 
		StringBuilder sb = new StringBuilder();
		sb.append(2);
		sb.append(4);
		System.out.println(sb.toString());

	}

}
