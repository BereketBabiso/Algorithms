package varargs;

public class Varargs {
	
	public static int sum(int ...v) {
		int sum = 0;
		for(int i=0;i<v.length;i++) sum+=v[i];
		return sum;
	}
	public static void varargsOverloadTest() {
		System.out.println("printed from no arguments method");
	}
	public static void varargsOverloadTest(String s) {
		System.out.println("printed from one parameter method and passed argument is : "+s);
	}
	public static void varargsOverloadTest(String ...s) {
		System.out.println("printed from method with varargs and the input is :");
		for(int i=0;i<s.length;i++) System.out.println(s[i]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sum of [1,2,3] = "+Varargs.sum(1,2,3));
		System.out.println("Method overloading test with varargs");
		Varargs.varargsOverloadTest();
		Varargs.varargsOverloadTest("Liza");
		Varargs.varargsOverloadTest("Bereket","Lisa");

	}

}
