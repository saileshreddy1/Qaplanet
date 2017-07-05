package google;

import java.util.List;

public class ArrayList {

	public static void main(String[] args) {

		List<String> data=new  java.util.ArrayList<String>();
		data.add("selenium");
		data.add("QTP");
		data.add("uft");
		data.add("selenium");
		
		for (int i = 0; i < data.size(); i++) 
		{
			System.out.println(data.get(i));
		}
		

//		for(String s:data)
//		{
//			System.out.println(s);
//		}
//		List<String>data=new java.util.ArrayList<String>();
//		
//		data.add("Hello World");
//		data.add("Testing");
//		for (int i = 0; i < data.size(); i++) 
//		{
//			System.out.println(data.get(i));
//			
//		}
	}

}
