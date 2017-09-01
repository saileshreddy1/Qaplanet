package forloops;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {

		ArrayList<String>Al=new ArrayList<String>();
		Al.add("Selenium");
		Al.add("Qtp");
		Al.add("LR");
		Al.add("SlikTest");
		Al.add("Appuim");
		
		System.out.println(Al.get(0));
		System.out.println(Al.get(1));
		System.out.println(Al.get(2));
		System.out.println(Al.get(3));
		System.out.println(Al.get(4));
		
		System.out.println();
		System.out.println(Al.size());
		
		for (int i = 0; i < Al.size(); i++) 
		{
			System.out.println(Al.get(i));
			
		}
		
		System.out.println();
		System.out.println("For-Each-Loop");
		
		for(String a:Al)
		{
			System.out.println(a);
		}
	}

}
