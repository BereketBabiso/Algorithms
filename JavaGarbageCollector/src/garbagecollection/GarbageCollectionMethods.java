package garbagecollection;

/*
 	This code shows how to call JVM's garabage collector method and it also shows how to make objects
 	eligible for garbage collection. 
 */

public class GarbageCollectionMethods {

	public static void main(String[] args) throws InterruptedException {
		
		GarbageCollectionMethods obj1 = new GarbageCollectionMethods();
		GarbageCollectionMethods obj2 = new GarbageCollectionMethods();
		
		//Nulliyfing the refence ---> makes the object unreachable, hence eligible for garbage collection
		obj1 = null;
		
		//one way of calling JVM garbage collector
		System.gc();
		
		//Re-assign the reference variable ---->another way of making the object unreachable
		obj2 = getObj();
		
		//another way of calling JVM garbage collector
		Runtime.getRuntime().gc();
		
		localMethod();
		
		//this will invoke gc on the local variable used in the localMethod()
		System.gc();		
		
		
	}
	public static void localMethod() {
		
		GarbageCollectionMethods obj3 = new GarbageCollectionMethods();
	}
	public static GarbageCollectionMethods getObj() {
		return new GarbageCollectionMethods();
	}
	
	protected void finalize() throws Throwable{
		System.out.println("Garbage collector called on");
		System.out.println("object garbage collected : "+this);
	}	
	
}
