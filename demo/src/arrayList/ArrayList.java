package arrayList;

import java.util.Iterator;
import java.util.List;


public class ArrayList {

	public static void main(String[] args) 
	{
		
		List<String> List=new java.util.ArrayList<String>();
		List.add("Selenium");
		List.add("QTP");
		List.add("123");
		
		System.out.println(List.get(0));
		System.out.println(List.get(1));
		System.out.println(List.get(2));
		System.out.println("List size = "+ List.size());
		System.out.println("");
		System.out.println("This is For Loop");
		
		
		for (int i = 0; i < List.size(); i++)
		{
			
			System.out.println(List.get(i));
			
		}
		System.out.println("");
		
		
		System.out.println("This is For Each loop");
		for (String str : List) 
		{
			System.out.println(str);
			
		}
		System.out.println("");
		
		
		System.out.println("This is While loop");
		Iterator<String> it=List.iterator();
		while(it.hasNext())
		{
			
			String StringValue=it.next();
			System.out.println(StringValue);
		}
		

	}

}
