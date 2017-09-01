package coreJavaExamples;

public class Constructors {

	Constructors()
	{
		System.out.println("Zero-args Constructor");
	}
	
	
	Constructors(int i)
	{
		System.out.println("Args Constructor " + i);
	}
	
	public static void main(String[] args) 
	{
			
		Constructors c=new Constructors();
		Constructors c1=new Constructors(10);
		System.out.println(c);
		System.out.println(c1);
		
		

	}

}
