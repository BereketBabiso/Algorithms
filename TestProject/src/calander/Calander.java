package calander;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

public class Calander {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.HOUR_OF_DAY);
		System.out.println(gc.getTime());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i =0;i<100;i++) list.add(i);
		System.out.println(list.get(50));
		
		
		StringJoiner sj = new StringJoiner(", ","[","]");
		String[] arr = {"Java", "C++", "C", "Python", "PHP"};
		for(String s : Arrays.asList(arr)) {
			sj.add(s);
		}
		System.out.println(sj.toString());
		
		String t = new String("hello");
		System.out.println(t.toUpperCase().hashCode());
		
		StringBuffer sb = new StringBuffer("hello");
		System.out.println(sb.toString());
		sb.insert(1, 'o');
		System.out.println(sb.toString());

	}

}
