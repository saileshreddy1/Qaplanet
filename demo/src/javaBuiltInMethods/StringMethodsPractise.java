package javaBuiltInMethods;

public class StringMethodsPractise {

	public static void main(String[] args) {
		
		
		String data="JavaScript";
		
		System.out.println(data.toLowerCase());
		
		System.out.println(data.toUpperCase());
		
		System.out.println(data.substring(3));
		
		System.out.println(data.substring(2, 4));
		
		System.out.println(data.subSequence(0, 6));
		
		System.out.println(data.replace("Java", "Selenium "));
		
		String y="   java          ";
		
		System.out.println(y);
		
		System.out.println(y.trim());
		
		String str="ThisXisXjava";
		
		String[] a=str.split("X");
		
		System.out.println(a[0]);
		
		System.out.println(a[1]);

		System.out.println(a[2]);
		
		System.out.println(data.toString());
		//convert string digit to int
		String c="10";
		
		int b=Integer.parseInt(c);
		
		System.out.println(b);	
		
		String s="10";
		
		int i=Integer.parseInt(s);
		
		System.out.println(i);
		
		
		
		
	}
	
}
