package question3_LinkedList_best;

import java.util.LinkedList;

public class SumOfTwoNumbersInTwoLists {
	LinkedList<Integer> ret = new LinkedList<>();
	int carryOver;
	
	public LinkedList<Integer> sumOfTwoNumbers(LinkedList<Integer>num1,LinkedList<Integer>num2){
		
		if(num1.isEmpty()) {
			this.ret.addFirst(this.carryOver);
			return this.ret;
		}
		int x = num1.removeLast();
		int y = num2.removeLast();
		int z = x + y+this.carryOver;
		if(z<10) {
			this.ret.addFirst(z);
			this.carryOver=0;
			sumOfTwoNumbers(num1,num2);
		}
		else {
			this.ret.addFirst(z%10);
			this.carryOver = z/10;
			sumOfTwoNumbers(num1,num2);
		}
		
		return this.ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> num1 = new LinkedList<>();
		num1.add(5);
		num1.add(6);
		num1.add(3);
		System.out.println(num1);
		LinkedList<Integer> num2 = new LinkedList<>();
		num2.add(8);
		num2.add(4);
		num2.add(2);
		System.out.println(num2);
		
		SumOfTwoNumbersInTwoLists stl = new SumOfTwoNumbersInTwoLists();
		System.out.println(stl.sumOfTwoNumbers(num1, num2));

	}

}
