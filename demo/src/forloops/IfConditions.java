package forloops;

public class IfConditions {

	static
	{
		int x=10;
		if(x==10)
		{
			System.out.println("x value is 10");
		}
	}
	
	public static void main(String[] args) {
						
		ifcondition();
				
		ifElse();
				
		ifElseIF();
				
		nestedIF();
		
		switchCase();
	}
	
	
	static void ifcondition()
	{
		int x=10;
		if(x==10)
		{
			System.out.println("x value is 10");
		}
	}

	static void ifElse()
	{
		int x=10;
		if(x%2==0)
		{
			System.out.println("Even");
		}
		else
		{
			System.out.println("Odd");
		}
	}
	
	
	static void ifElseIF()
	{
		String str="SELENIUM";
		
		if (str=="QTP")
		{
			System.out.println("QTP");
			
		}
		else if(str=="LOADRUNNER")
		{
			System.out.println("LOAD RUNNER");
		}
		else if(str=="SELENIUM")
		{
			System.out.println("SELENIUM");
		}
		else
		{
			System.out.println("Invalid Input");
		}
		
	}
	
	static void nestedIF()
	{
		int x=10;
		
		if (x<=10)
		{
			if (x<=5) 
			{
				System.out.println("x value is less than 5");
				
			}
			else
			{
				System.out.println("x value is greate than 5");
			}
		}
		else
		{
			System.out.println("x value is greater than 10");
		}
	}
	
	static void switchCase()
	{
		int n=20;
		
		switch(n)
		{
			case 10:
			System.out.println("10");
			break;
			
			case 20:
			System.out.println("20");
			break;
			
			case 30:
			System.out.println("30");
			break;
			
			default :
			System.out.println("invalid input");
			break;
			
		}
		
	}
	
	
}
