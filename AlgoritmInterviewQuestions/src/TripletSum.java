import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TripletSum {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>x=new ArrayList<>();
		x.add(1);
		x.add(2);
		List<Integer>y=new ArrayList<>();
		x.add(2);
		x.add(1);
		HashMap<List<Integer>,Integer> map = new HashMap<>();
		map.put(x,1);
		map.put(y,2);
		System.out.println(map.get(x));
		

	}

}
