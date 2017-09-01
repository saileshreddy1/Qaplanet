package coreJavaExamples;

public class Blocks {


/*
 
 	Blocks are two types
 	
 	* Static block
 	* Non-Static block or Instance block Dynimic block
 	* Static block and static varibles execute in fifo manner
 	* It will execute implicitally
 	 
 	
 	Static block : with the help of Static  keyword 
 	
 	It will execute at the time of class loading 
 	
 	Non-Static block or Instance block : 
 	{
 		
 	}
 	At the time of instance creation
 */
	
	static int i=m1();
	static 
	{
		System.out.println("Static block");
	}
	
	
	{
		System.out.println("Non-Static block");
	}
	
	
	public static int m1()
	{
		System.out.println("Static method");
		return i;
	}
	public static void main(String[] args) {
		 
//		Blocks b=new Blocks();
//		Blocks b1=new Blocks();
//		Blocks b2=new Blocks();
//		Blocks b3=new Blocks();
		new Blocks();
		
		
	}

}
