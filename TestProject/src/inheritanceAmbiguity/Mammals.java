package inheritanceAmbiguity;

public interface Mammals {

	public default void eat() {
		System.out.println("MammalsInterface::eat");
	}
}
