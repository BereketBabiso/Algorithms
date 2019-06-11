package staticMembers;

public class InstanceCounter {
	public static int counter=0;
	
	protected InstanceCounter(){
		counter++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i =0;i<10;i++) {
		InstanceCounter ic = new InstanceCounter();
		}
		System.out.println("#of instances created : "+counter);
		

	}

}
