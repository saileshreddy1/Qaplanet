package coreJavaExamples;

public class ArrayExample {

	public static void main(String[] args) {

//		 integerArrayExample();
//		
//		 StringArrayExample();
		 
		 twoDimansionalArray();
		
	}
	
	public static void integerArrayExample()
	{
		int [] array=new int[10];

//		int [] array={10,20,30,40,50,60,70,80,90,100};
		
		array[0]=10;
		array[1]=20;
		array[2]=30;
		array[3]=40;
		array[4]=50;
		array[5]=60;
		array[6]=70;
		array[7]=80;
		array[8]=90;
		array[9]=100;
		
		System.out.println("Size of Array : "+array.length);
		
		for(int i=0; i < array.length;i++)
		{
			System.out.println(array[i]);
		}
	}
	
	
	public static void StringArrayExample()
	{
		
		
		String str1[]={"MR.","Ms."};
		
		String str2[]={"Raju","Ramesh",};
		
		String str3[]={"Latha","Rani"};
		
		System.out.println(str1[0]+str2[0]);
					
		System.out.println(str1[0]+str2[1]);
		
		System.out.println(str1[1]+str3[0]);
		
		System.out.println(str1[1]+str3[1]);
	}
	
	public static void twoDimansionalArray()
	{
		String str1[]={"MR.","Ms."};
		
		String str2[]={"raju","Ramesh",};
		
		String str3[]={"latha","rani"};
		
		
		String str[][]={str1,str2,str3};
		
		System.out.println(str[0][1]+str[2][1]);
		
		System.out.println(str[0][0]+str[1][1]);
		
		
	}

}
