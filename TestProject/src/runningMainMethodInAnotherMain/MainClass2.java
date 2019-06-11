package runningMainMethodInAnotherMain;

public class MainClass2 {
	
	public void method() {
		System.out.println("member method called from main method2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("from main method 2");
		MainClass2 mc2 = new MainClass2();
		mc2.method();

	}

}
