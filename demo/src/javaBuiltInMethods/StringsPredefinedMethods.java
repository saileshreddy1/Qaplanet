package javaBuiltInMethods;

public class StringsPredefinedMethods {

	public static void main(String[] args) {

		String x="JavaScript";	
		
		//To convert to small letters
		System.out.println(x.toLowerCase());
		
		//To convert to Capital letters
		System.out.println(x.toUpperCase());
	
		//Get sub string from main string
		System.out.println(x.substring(4)); //Script
		
		//Get Scr from x.substring(starting index, length[optional])
		System.out.println(x.substring(4, 7));//SCR
		
		//Get Java
		System.out.println(x.substring(0, 4));//Java
		
		//Replace
		System.out.println(x.replace("Java", "VB"));	//VBScript	
	//*******************************************
		String y="  Java   ";
		System.out.println(y);
		
		//To remove space from either left side or right side or both sides
		System.out.println(y.trim());
    //*********************************************
		String str="ThisXisXJava";
		String[] a=str.split("X");
		
		System.out.println(a[0]);
		
		System.out.println(a[1]);
		
		System.out.println(a[2]);
		//To convert var into string type
		x.toString();
		
		//convert string digit to int
		String c="10";
		int b=Integer.parseInt(c);
		System.out.println(b);	
			
		System.out.println(x.toString());
	}

}
