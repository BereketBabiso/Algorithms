package staticMembers;

public class StaticClass {
	
	static int a = 3;
	static int b; 
	int x =6;
	static {
	 b = 3*a;
	 int y =10;
	}
	public static void meth() {
		System.out.println("a = "+a+" and b = "+b);
		StaticClass sc = new StaticClass();
		System.out.println("x = "+sc.x);// static method can only directly access static data 
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
