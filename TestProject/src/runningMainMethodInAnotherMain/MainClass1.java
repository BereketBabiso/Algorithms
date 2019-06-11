package runningMainMethodInAnotherMain;

public class MainClass1 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("From main method1 : before calling main method2");
		MainClass2.main(args);
		System.out.println("From main method1 : after calling main method2");

	}

}
