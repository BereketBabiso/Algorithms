package strategyPattern;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
   write a function that takes list of integers and predicates to return sum of elements, even sums or odd sums
   as needed.
 */

public class StrategyPattern {
	
	public int sum(List<Integer> numbers,Predicate<Integer>selector) {
		return numbers.stream().filter(selector).reduce(0, (a,b)->a+b);
	}

	public static void main(String[] args) {
		
		StrategyPattern sp = new StrategyPattern();
		System.out.println("the whole sum  = "+sp.sum(Arrays.asList(1,2,3,4,5), x->true));
		System.out.println("the even sum  = "+sp.sum(Arrays.asList(1,2,3,4,5), x->x%2==0));
		System.out.println("the odd sum  = "+sp.sum(Arrays.asList(1,2,3,4,5), x->x%2!=0));

	}

}
